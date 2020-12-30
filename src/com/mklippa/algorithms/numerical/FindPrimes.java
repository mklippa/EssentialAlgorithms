package com.mklippa.algorithms.numerical;

import java.util.ArrayList;
import java.util.List;

public class FindPrimes {
    // O(N*log(log(N)))
    public List<Integer> solve(int maxNumber) {
        boolean[] isComposite = new boolean[maxNumber+1];

        for (int i = 4; i <= maxNumber; i += 2) {
            isComposite[i] = true;
        }

        int nextPrime = 3;
        int stopAt = (int)Math.sqrt(maxNumber);
        while (nextPrime <= stopAt) {
            for (int i = nextPrime*2; i <= maxNumber; i += nextPrime) {
                isComposite[i] = true;
            }
            nextPrime += 2;
            while (nextPrime <= maxNumber && isComposite[nextPrime])
                nextPrime += 2;
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxNumber; i++) {
            if (!isComposite[i])
                primes.add(i);
        }

        return primes;
    }
}
