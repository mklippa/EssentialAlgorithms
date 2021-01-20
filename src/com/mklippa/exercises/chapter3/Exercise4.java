package com.mklippa.exercises.chapter3;

import com.mklippa.algorithms.DoublyLinkedList;

public class Exercise4 {
    public static <T> void addAtEnd(DoublyLinkedList.Cell<T> sentinel, DoublyLinkedList.Cell<T> newCell) {
        DoublyLinkedList.Cell<T> cell = sentinel;
        while (cell.getNext() != null) {
            cell = cell.getNext();
        }
        cell.setNext(newCell);
        newCell.setPrev(cell);
    }
}
