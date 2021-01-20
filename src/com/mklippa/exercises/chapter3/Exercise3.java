package com.mklippa.exercises.chapter3;

import com.mklippa.algorithms.DoublyLinkedList;

public class Exercise3 {
    public static <T> void addAtBeginning(DoublyLinkedList.Cell<T> sentinel, DoublyLinkedList.Cell<T> newCell) {
        if (sentinel.getNext() == null) {
            sentinel.setNext(newCell);
            newCell.setPrev(sentinel);
        }
        else {
            newCell.setPrev(sentinel);
            newCell.setNext(sentinel.getNext());
            newCell.getNext().setPrev(newCell);
            sentinel.setNext(newCell);
        }
    }
}
