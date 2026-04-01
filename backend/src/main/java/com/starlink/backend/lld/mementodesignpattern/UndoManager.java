package com.starlink.backend.lld.mementodesignpattern;// ─── 3. CARETAKER — snapshots manage karo ───────────────
import java.util.ArrayDeque;
import java.util.Deque;

public class UndoManager {

    // Undo stack — last saved sabse upar
    private final Deque<PaymentSnapshot> undoStack = new ArrayDeque<>();
    // Redo stack — undo ke baad redo possible
    private final Deque<PaymentSnapshot> redoStack = new ArrayDeque<>();

    private final PaymentForm form;

    public UndoManager(PaymentForm form) {
        this.form = form;
    }

    // Current state save karo
    public void saveState() {
        undoStack.push(form.save());
        redoStack.clear(); // naya save = redo history clear
        System.out.println("Undo stack size: " + undoStack.size());
    }

    // Ek step peeche jao
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        // Current state redo mein daalo
        redoStack.push(form.save());
        // Pichla state restore karo
        form.restore(undoStack.pop());
    }

    // Undo ke baad aage jao
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }
        undoStack.push(form.save());
        form.restore(redoStack.pop());
    }

    public int getUndoCount() { return undoStack.size(); }
    public int getRedoCount() { return redoStack.size(); }
}