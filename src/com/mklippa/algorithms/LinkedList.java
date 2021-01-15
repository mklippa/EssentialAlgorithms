package com.mklippa.algorithms;

public class LinkedList {
    public static class Cell<T> {
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

        public static <T> void addAtBeginning(Cell<T> top, Cell<T> newCell) {
            newCell.next = top.next;
            top.next = newCell;
        }

        public static <T> void addAtEnd(Cell<T> top, Cell<T> newCell) {
            while (top.next != null) {
                top = top.next;
            }
            top.next = newCell;
        }

        public static <T> void delete(Cell<T> afterMe) {
            afterMe.next = afterMe.next.next;
        }

        public static <T> Cell<T> findCell(Cell<T> cell, T target) {
            while (cell != null) {
                if (cell.value == target)
                    return cell;
                cell = cell.next;
            }
            return null;
        }

        public static <T> Cell<T> findCellBefore(Cell<T> top, T target) {
            while (top.next != null) {
                if (top.next.value == target)
                    return top;
                top = top.next;
            }
            return null;
        }

        public static  <T> void insert(Cell<T> afterMe, Cell<T> newCell) {
            newCell.next = afterMe.next;
            afterMe.next = newCell;
        }

        public static void iterate(Cell top) {
            while (top != null) {
                System.out.println(top.value);
                top = top.next;
            }
        }
    }
}
