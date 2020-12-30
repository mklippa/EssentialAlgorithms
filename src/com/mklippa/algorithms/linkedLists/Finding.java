package com.mklippa.algorithms.linkedLists;

public class Finding {
    public <T> Cell<T> findCell(Cell<T> cell, T target) {
        while (cell != null) {
            if (cell.value == target)
                return cell;
            cell = cell.next;
        }
        return null;
    }

    public <T> Cell<T> findCellBefore(Cell<T> top, T target) {
        while (top.next != null) {
            if (top.next.value == target)
                return top;
            top = top.next;
        }
        return null;
    }
}
