package com.mklippa.exercises.chapter2;

import com.mklippa.algorithms.Numerical;

public class Exercise14 {
    public static void generateCarmichaelNumbers(int maxNumber) {
        boolean[] isComposite = generateCompositeNumbers(maxNumber);

        for (int i = 2; i <= maxNumber; i++) {
            if (isComposite[i])
                if (isCarmichael(i)) {
                    System.out.println(i + ": ");
                    System.out.println(Numerical.findFactors(i));
                    System.out.println();
                }
        }
    }

    private static boolean isCarmichael(int number) {

        for (int i = 1; i < number; i++) {
            if (Numerical.gcd(number, i) == 1)
                if ((int)Math.pow(i, number-1) % number != 1)
                    return false;
        }

        return true;
    }

    private static boolean[] generateCompositeNumbers(int maxNumber) {
        boolean[] isComposite = new boolean[maxNumber+1];

        for (int i = 4; i <= maxNumber; i += 2) {
            isComposite[i] = true;
        }

        int nextPrime = 3;
        int stopAt = (int)Math.sqrt(maxNumber);

        while (nextPrime <= stopAt) {
            for (int i = nextPrime*nextPrime; i <= maxNumber; i += nextPrime) {
                isComposite[i] = true;
            }
            nextPrime += 2;
            while (nextPrime <= maxNumber && isComposite[nextPrime])
                nextPrime += 2;
        }

        return isComposite;
    }
}
