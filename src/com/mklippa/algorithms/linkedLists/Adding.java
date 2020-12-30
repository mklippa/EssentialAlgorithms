package com.mklippa.algorithms.linkedLists;

public class Adding {
    public <T> void addAtBeginning(Cell<T> top, Cell<T> newCell) {
        newCell.next = top.next;
        top.next = newCell;
    }

    public <T> void addAtEnd(Cell<T> top, Cell<T> newCell) {
        while (top.next != null) {
            top = top.next;
        }
        top.next = newCell;
    }
}
