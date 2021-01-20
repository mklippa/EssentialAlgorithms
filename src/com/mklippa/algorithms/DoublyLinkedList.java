package com.mklippa.algorithms;

public class DoublyLinkedList {
    public static <T> void insertCell(Cell<T> afterMe, Cell<T> newCell) {
        newCell.next = afterMe.next;
        afterMe.next = newCell;

        newCell.next.prev = newCell;
        newCell.prev = afterMe;
    }

    public static class Cell<T> {
        private T value;
        private Cell<T> next;
        private Cell<T> prev;

        public Cell() {}

        public Cell(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Cell<T> getNext() {
            return next;
        }

        public void setNext(Cell<T> next) {
            this.next = next;
        }

        public Cell<T> getPrev() {
            return prev;
        }

        public void setPrev(Cell<T> prev) {
            this.prev = prev;
        }
    }
}
