package com.mklippa.algorithms;

import java.util.HashSet;

public class LinkedList {

    public static <T> boolean hasLoopReversing(Cell<T> sentinel) {
        if (sentinel.next == null) return false;

        Cell<T> newSentinel = reverseList(sentinel);

        reverseList(sentinel);

        return newSentinel == sentinel;
    }

    public static <T> Cell<T> reverseList(Cell<T> sentinel) {
        Cell<T> prevCell = null;
        Cell<T> currCell = sentinel;
        while (currCell != null) {
            Cell<T> nextCell = currCell.next;
            currCell.next = prevCell;

            prevCell = currCell;
            currCell = nextCell;
        }

        return prevCell;
    }

    public static <T> boolean hasLoopRetracing(Cell<T> sentinel) {
        Cell<T> cell = sentinel;
        while (cell.next != null) {
            Cell<T> tracer = sentinel;
            while (tracer != cell) {
                if (tracer.next == cell.next) {
                    cell.next = null;
                    return true;
                }
                tracer = tracer.next;
            }
            cell = cell.next;
        }
        return false;
    }

    public static <T> boolean hasLoopHashTable(Cell<T> sentinel) {
        HashSet<Cell<T>> visited = new HashSet<>();

        Cell<T> cell = sentinel;
        while (cell.next != null) {
            if (visited.contains(cell.next)) {
                cell.next = null;
                return true;
            }
            visited.add(cell);
            cell = cell.next;
        }

        return false;
    }

    public static <T> boolean hasLoopMarking(Cell<T> sentinel) {
        boolean hasLoop = false;

        Cell<T> cell = sentinel;
        while (cell.next != null) {
            if (cell.next.visited) {
                cell.next = null;
                hasLoop = true;
                break;
            }
            cell = cell.next;
            cell.visited = true;
        }

        cell = sentinel;
        while (cell.next != null) {
            cell.visited = false;
            cell = cell.next;
        }

        return hasLoop;
    }

    public static <T extends Comparable<T>> Cell<T> selectionSort(Cell<T> input) {
        Cell<T> sentinel = new Cell<>();
        sentinel.next = null;

        while (input.next != null) {
            Cell<T> bestAfterMe = input;
            T bestValue = bestAfterMe.next.value;

            Cell<T> afterMe = input.next;
            while (afterMe.next != null) {
                if (afterMe.next.value.compareTo(bestValue) > 0) {
                    bestAfterMe = afterMe;
                    bestValue = afterMe.next.value;
                }
                afterMe = afterMe.next;
            }

            Cell<T> bestCell = bestAfterMe.next;
            bestAfterMe.next = bestCell.next;

            bestCell.next = sentinel.next;
            sentinel.next = bestCell;
        }

        return sentinel;
    }

    public static <T extends Comparable<T>> Cell<T> insertionSort(Cell<T> input) {
        Cell<T> sentinel = new Cell<>();
        sentinel.next = null;

        input = input.next;
        while (input != null) {
            Cell<T> newCell = input;
            input = input.next;
            Cell<T> afterMe = sentinel;
            while (afterMe.next != null && afterMe.next.value.compareTo(newCell.value) < 0)
                afterMe = afterMe.next;
            newCell.next = afterMe.next;
            afterMe.next = newCell;
        }
        return sentinel;
    }

    public static <T> Cell<T> copyList(Cell<T> oldSentinel) {
        Cell<T> newSentinel = new Cell<>();
        Cell<T> lastAdded = newSentinel;
        Cell<T> oldCell = oldSentinel.next;

        while (oldCell != null) {
            lastAdded.next = new Cell<>();
            lastAdded = lastAdded.next;
            lastAdded.value = oldCell.value;
            oldCell = oldCell.next;
        }

        lastAdded.next = null;
        return newSentinel;
    }

    public static <T extends Comparable<T>> void insertCell(Cell<T> top, Cell<T> newCell) {
        while (top.next != null && top.next.value.compareTo(newCell.value) < 0)
            top = top.next;

        newCell.next = top.next;
        top.next = newCell;
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

    public static class Cell<T> {
        private T value;
        private Cell<T> next;
        private boolean visited;

        public Cell(T value, Cell<T> next) {
            this.value = value;
            this.next = next;
        }

        public Cell() {}

        public Cell(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Value: %s", value);
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
    }
}
