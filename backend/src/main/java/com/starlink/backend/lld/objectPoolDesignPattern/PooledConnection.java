package com.starlink.backend.lld.objectPoolDesignPattern;

// AutoCloseable = try-with-resources support
// close() automatically call hoga — return bhoolna impossible
public class PooledConnection implements AutoCloseable {

    private final DBConnection     connection;
    private final DBConnectionPool pool;
    private       boolean          closed = false;

    public PooledConnection(DBConnectionPool pool) throws InterruptedException {
        this.pool       = pool;
        this.connection = pool.borrow(); // pool se lo
    }

    // Actual query delegate karo
    public String executeQuery(String sql) {
        if (closed) throw new IllegalStateException("Connection already closed!");
        return connection.executeQuery(sql);
    }

    // try-with-resources mein automatically call hoga
    @Override
    public void close() {
        if (!closed) {
            pool.returnToPool(connection);
            closed = true;
        }
    }

    public DBConnection getConnection() { return connection; }
}