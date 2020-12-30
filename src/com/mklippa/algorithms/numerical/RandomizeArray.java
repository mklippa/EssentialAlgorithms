package com.mklippa.algorithms.numerical;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomizeArray {
    public List<Integer> solve(List<Integer> arr) {
        Random rnd = new Random();
        int len = arr.size();
        for (int i = 0; i < len - 1; i++) {
            // rnd.nextInt((max - min) + 1) + min
            int j = rnd.nextInt(len);
            Collections.swap(arr, i, j);
        }
        return arr;
    }
}
