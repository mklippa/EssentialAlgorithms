package com.mklippa.algorithms.linkedLists;

public class Iterating {
    public void iterate(Cell top) {
        while (top != null) {
            System.out.println(top.value);
            top = top.next;
        }
    }
}
