package com.mklippa.algorithms.numerical;

import java.util.ArrayList;
import java.util.List;

public class FindFactors {
    // O(num)
    public List<Integer> solve(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 1) factors.add(num);
        return factors;
    }

    // O(sqrt(N))
    public List<Integer> solve2(int num) {
        List<Integer> factors = new ArrayList<>();

        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }

        int maxFactor = (int)Math.sqrt(num);

        for (int i = 3; i <= maxFactor; i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 1) factors.add(num);
        return factors;
    }
}
