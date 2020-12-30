package com.mklippa.algorithms.numerical;

import java.util.Random;

public class IsPrime {
    private final Random rand = new Random();

    public boolean solve(int p, int maxTests) {
        for (int i = 0; i < maxTests; i++) {
            int n = rand.nextInt(p - 1) + 1;
            if (Math.pow(n, p-1) % p != 1)
                return false;
        }
        return true;
    }
}
