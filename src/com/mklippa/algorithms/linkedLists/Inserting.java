package com.mklippa.algorithms.linkedLists;

public class Inserting {
    public <T> void insert(Cell<T> afterMe, Cell<T> newCell) {
        newCell.next = afterMe.next;
        afterMe.next = newCell;
    }
}
