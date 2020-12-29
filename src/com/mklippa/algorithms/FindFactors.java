package com.mklippa.algorithms;

import java.util.ArrayList;
import java.util.List;

public class FindFactors {
    public List<Integer> solve(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 0) factors.add(num);
        return factors;
    }
}
