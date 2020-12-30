package com.mklippa.algorithms.linkedLists;

public class Cell<T> {
    public T value;
    public Cell<T> next;

    @Override
    public String toString() {
        return String.format("Value: %s", value);
    }
}
