package com.mklippa.exercises;

import com.mklippa.algorithms.LinkedList;

public class Ex_3_1 {
    public static <T> LinkedList.Cell<T> addAtEnd(LinkedList.Cell<T> bottom, LinkedList.Cell<T> newCell) {
        bottom.setNext(newCell);
        return newCell;
    }

    public static <T> LinkedList.Cell<T> delete(LinkedList.Cell<T> afterMe, LinkedList.Cell<T> bottom) {
        if (afterMe.getNext() == bottom) {
            bottom = afterMe;
        }
        afterMe.setNext(afterMe.getNext().getNext());
        return bottom;
    }
}
