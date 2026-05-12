package com.starlink.backend.lld.command;

// ─── COMMAND INTERFACE ───────────────────────────────────
public interface Command {
    void execute();
    void undo();
}