package com.mklippa.algorithms.linkedLists;

public class Cell<T> {
    public T value;
    public Cell<T> next;

    public Cell(T value){
        this.value = value;
    }

    public Cell() {
        this.value = null;
    }

    @Override
    public String toString() {
        return String.format("Value: %s", value);
    }
}
