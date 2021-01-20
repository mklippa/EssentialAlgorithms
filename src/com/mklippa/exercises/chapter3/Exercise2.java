package com.mklippa.exercises.chapter3;

import com.mklippa.algorithms.LinkedList;

public class Exercise2 {
    public static <T extends Comparable<T>> LinkedList.Cell<T> findMax(LinkedList.Cell<T> sentinel) {
        LinkedList.Cell<T> curr = sentinel.getNext();
        LinkedList.Cell<T> res = sentinel.getNext();
        while (curr != null) {
            if (curr.getValue().compareTo(res.getValue()) > 0) {
                res = curr;
            }
            curr = curr.getNext();
        }
        return res;
    }
}
