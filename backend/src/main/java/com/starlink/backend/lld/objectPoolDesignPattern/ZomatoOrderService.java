package com.starlink.backend.lld.objectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZomatoOrderService {

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("=".repeat(65));
        System.out.println("  ZOMATO DB CONNECTION POOL — Thread-Safe Demo");
        System.out.println("=".repeat(65));

        DBConnectionPool pool = DBConnectionPool.getInstance();

        // ─── Scenario 1: try-finally (basic) ───────────
        System.out.println("=== Scenario 1: try-finally pattern ===");
        DBConnection conn = null;
        try {
            conn = pool.borrow();
            conn.executeQuery("SELECT * FROM orders WHERE status='PLACED'");
        } finally {
            pool.returnToPool(conn); // exception aaye ya na aaye
        }

        // ─── Scenario 2: try-with-resources (best) ─────
        System.out.println("\n=== Scenario 2: try-with-resources (recommended) ===");

        // close() automatically call hoga — return bhoolna impossible
        try (PooledConnection pc = new PooledConnection(pool)) {
            pc.executeQuery("INSERT INTO orders VALUES ('U001','R101',450)");
            pc.executeQuery("UPDATE wallet SET balance=balance-450 WHERE user_id='U001'");
        } // ← pc.close() automatically call — conn pool mein wapas

        pool.printStats(); // sab free hone chahiye

        // ─── Scenario 3: Multi-thread — real concurrency ───
        System.out.println("\n=== Scenario 3: 10 threads, pool size 5 ===");

        int           THREAD_COUNT = 10;
        ExecutorService executor   = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch latch        = new CountDownLatch(THREAD_COUNT);

        for (int i = 1; i <= THREAD_COUNT; i++) {
            final int threadNum = i;
            executor.submit(() -> {
                try (PooledConnection pc = new PooledConnection(pool)) {

                    // Query execute karo
                    pc.executeQuery("SELECT * FROM orders WHERE id=" + threadNum);

                    // Kuch kaam simulate karo
                    Thread.sleep(200);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    System.out.println("[ERROR] " + Thread.currentThread().getName()
                        + ": " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); // sab threads khatam hone tak wait karo
        executor.shutdown();

        pool.printStats(); // sab 5 free hone chahiye

        // ─── Scenario 4: Double return prevent ─────────
        System.out.println("\n=== Scenario 4: Double return prevention ===");
        DBConnection c = pool.borrow();
        pool.returnToPool(c); // first return — OK
        pool.returnToPool(c); // second return — blocked!

        // ─── Scenario 5: Singleton proof ───────────────
        System.out.println("\n=== Scenario 5: Singleton proof ===");
        DBConnectionPool p1 = DBConnectionPool.getInstance();
        DBConnectionPool p2 = DBConnectionPool.getInstance();
        System.out.println("Same pool instance? " + (p1 == p2)); // true
    }
}