package com.starlink.backend.lld.objectPoolDesignPattern;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DBConnectionPool {

    // ─── Singleton ───────────────────────────────────────
    // volatile — DCL ke liye zaruri (CPU cache + reordering)
    private static volatile DBConnectionPool instance;

    public static DBConnectionPool getInstance() {
        if (instance == null) {                          // Check 1 — no lock
            synchronized (DBConnectionPool.class) {
                if (instance == null) {                  // Check 2 — with lock
                    instance = new DBConnectionPool("ZomatoPool", 5);
                }
            }
        }
        return instance;
    }

    // ─── Pool internals ──────────────────────────────────
    private final String               poolName;
    private final int                  maxSize;

    // BlockingQueue — thread-safe, bounded
    // offer() aur poll() atomic hain — no manual synchronization
    private final BlockingQueue<DBConnection> available;

    // Sab connections track karo — leak detection ke liye
    private final List<DBConnection> allConnections;

    // Borrow timeout — kitna wait karein agar pool empty ho
    private static final long BORROW_TIMEOUT_SECONDS = 5;

    // Leak detection — kitne seconds baad forceful reclaim
    private static final long LEAK_THRESHOLD_SECONDS = 30;

    // ─── Private Constructor ─────────────────────────────
    private DBConnectionPool(String poolName, int poolSize) {
        this.poolName       = poolName;
        this.maxSize        = poolSize;
        this.available      = new ArrayBlockingQueue<>(poolSize);
        this.allConnections = new ArrayList<>();

        System.out.println("\nInitializing [" + poolName + "] size=" + poolSize);
        System.out.println("Creating connections (expensive operations)...");

        for (int i = 1; i <= poolSize; i++) {
            DBConnection conn = new DBConnection(i);
            allConnections.add(conn);
            available.offer(conn); // queue mein daalo
        }

        System.out.println("Pool ready! " + available.size()
            + "/" + maxSize + " connections available\n");

        // Leak detector start karo — background mein chalta rahega
        startLeakDetector();
    }

    // ─── BORROW ──────────────────────────────────────────
    // Blocking — pool empty ho toh wait karo (timeout ke saath)
    public DBConnection borrow() throws InterruptedException {

        System.out.println("[BORROW] " + Thread.currentThread().getName()
            + " requesting connection...");

        // poll(timeout) — atomic operation on BlockingQueue
        // Agar available empty hai toh thread BLOCK hoga — busy wait nahi
        DBConnection conn = available.poll(
            BORROW_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        if (conn == null) {
            // Timeout ho gaya — pool still empty
            throw new RuntimeException(
                "Pool [" + poolName + "] exhausted! "
                + "No connection available in " + BORROW_TIMEOUT_SECONDS + "s. "
                + "Available=" + available.size() + "/" + maxSize);
        }

        conn.markBorrowed();

        System.out.println("[BORROW] " + Thread.currentThread().getName()
            + " got " + conn.getConnectionId()
            + " | Available: " + available.size() + "/" + maxSize);

        return conn;
    }

    // ─── RETURN ──────────────────────────────────────────
    public void returnToPool(DBConnection conn) {
        if (conn == null) {
            System.out.println("[RETURN] null connection — ignoring");
            return;
        }

        if (!conn.isInUse()) {
            System.out.println("[RETURN] " + conn.getConnectionId()
                + " already returned — double return prevented!");
            return; // Double return prevent
        }

        conn.reset();        // next user ke liye clean
        conn.markReturned();
        available.offer(conn); // queue mein wapas

        System.out.println("[RETURN] " + conn.getConnectionId()
            + " returned by " + Thread.currentThread().getName()
            + " | Available: " + available.size() + "/" + maxSize);
    }

    // ─── LEAK DETECTOR ───────────────────────────────────
    // Background thread — connections jo return nahi hui unhe detect karo
    private void startLeakDetector() {
        ScheduledExecutorService scheduler
            = Executors.newSingleThreadScheduledExecutor(r -> {
                Thread t = new Thread(r, "LeakDetector");
                t.setDaemon(true); // app exit pe automatically stop
                return t;
            });

        scheduler.scheduleAtFixedRate(() -> {
            for (DBConnection conn : allConnections) {
                if (conn.isInUse()
                        && conn.getBorrowedSeconds() > LEAK_THRESHOLD_SECONDS) {
                    System.out.println("\n[LEAK DETECTED] " + conn.getConnectionId()
                        + " borrowed for " + conn.getBorrowedSeconds() + "s"
                        + " — forcefully reclaiming!");
                    returnToPool(conn); // force return
                }
            }
        }, 10, 10, TimeUnit.SECONDS); // har 10 sec pe check karo
    }

    // ─── STATS ───────────────────────────────────────────
    public void printStats() {
        System.out.println("\n--- Pool Stats [" + poolName + "] ---");
        System.out.println("Total       : " + allConnections.size());
        System.out.println("Available   : " + available.size());
        System.out.println("In use      : "
            + (allConnections.size() - available.size()));
        allConnections.forEach(c ->
            System.out.println("  " + c));
    }

    public int getAvailableCount() { return available.size(); }
    public int getTotalCount()     { return allConnections.size(); }
}