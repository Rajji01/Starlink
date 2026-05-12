package com.starlink.backend.lld.command;

import java.util.ArrayDeque;
import java.util.Deque;

// ─── INVOKER — history manage karta hai ──────────────────
public class CartManager {

    private final Deque<Command> history  = new ArrayDeque<>(); // undo ke liye
    private final Deque<Command> redoStack = new ArrayDeque<>(); // redo ke liye

    // Execute + history mein push
    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
        redoStack.clear(); // naya action = redo history clear!
    }

    // Undo — last command reverse
    public void undo() {
        if (history.isEmpty()) {
            System.out.println("[UNDO] Nothing to undo!");
            return;
        }
        Command last = history.pop();
        System.out.println("[UNDO] Reversing last action...");
        last.undo();
        redoStack.push(last); // redo ke liye save
    }

    // Redo — jo undo kiya use wapas karo
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("[REDO] Nothing to redo!");
            return;
        }
        Command last = redoStack.pop();
        System.out.println("[REDO] Re-applying action...");
        last.execute();
        history.push(last);
    }

    public int historySize() { return history.size(); }
}