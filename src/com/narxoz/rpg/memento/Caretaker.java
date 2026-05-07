package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.HeroMemento;
import java.util.Stack;

public class Caretaker {
    private final Stack<HeroMemento> history = new Stack<>();

    public void save(HeroMemento memento) {
        if (memento != null) {
            history.push(memento);
            System.out.println("  📸 Snapshot saved. History size: " + history.size());
        }
    }

    public HeroMemento undo() {
        if (history.isEmpty()) {
            System.out.println("  ⚠️ No snapshots to undo!");
            return null;
        }
        HeroMemento memento = history.pop();
        System.out.println("  ↩️ Undo - restoring previous state. History size: " + history.size());
        return memento;
    }

    public HeroMemento peek() {
        if (history.isEmpty()) {
            System.out.println("  ℹ️ No snapshots stored");
            return null;
        }
        System.out.println("  👁️ Peeking at latest snapshot");
        return history.peek();
    }

    public int size() {
        return history.size();
    }
}