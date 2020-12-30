package com.mklippa.algorithms.linkedLists;

public class Deleting {
    public <T> void delete(Cell<T> afterMe) {
        afterMe.next = afterMe.next.next;
    }
 }
