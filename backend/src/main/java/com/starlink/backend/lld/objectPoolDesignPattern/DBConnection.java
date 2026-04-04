package com.starlink.backend.lld.objectPoolDesignPattern;

import java.time.Instant;

public class DBConnection {

    private final String  connectionId;
    private final String  dbUrl;

    // Thread-safety ke liye volatile
    private volatile boolean inUse;
    private volatile Instant borrowedAt; // leak detection ke liye

    public DBConnection(int id) {
        this.connectionId = "CONN-" + String.format("%02d", id);
        this.dbUrl        = "jdbc:mysql://zomato-prod:3306/orders";
        this.inUse        = false;
        this.borrowedAt   = null;

        // Expensive — real mein DB handshake hota hai
        simulateExpensiveCreation();
        System.out.println("  [CREATED] " + connectionId);
    }

    private void simulateExpensiveCreation() {
        try { Thread.sleep(100); } // 100ms simulate
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public String executeQuery(String sql) {
        if (!inUse) throw new IllegalStateException(
            connectionId + " not borrowed from pool!");
        System.out.printf("  [%s] [Thread=%-12s] Query: %s%n",
            connectionId, Thread.currentThread().getName(), sql);
        return "ResultSet:" + sql.hashCode();
    }

    // Pool ke liye internal methods
    void markBorrowed() {
        this.inUse      = true;
        this.borrowedAt = Instant.now();
    }

    void markReturned() {
        this.inUse      = false;
        this.borrowedAt = null;
    }

    // Reset state for next user
    void reset() {
        // Real mein: auto-commit reset, temp tables clear, etc.
        System.out.println("  [" + connectionId + "] Reset for reuse");
    }

    // Leak detection — kitne seconds se use mein hai
    long getBorrowedSeconds() {
        if (borrowedAt == null) return 0;
        return Instant.now().getEpochSecond() - borrowedAt.getEpochSecond();
    }

    public boolean isInUse()         { return inUse; }
    public String  getConnectionId() { return connectionId; }

    @Override
    public String toString() {
        return connectionId + (inUse ? "[BUSY]" : "[FREE]");
    }
}