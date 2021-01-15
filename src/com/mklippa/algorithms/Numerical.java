package com.mklippa.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Numerical {
    private final static Random rand = new Random();

    // O(num)
    public static List<Integer> findFactors(int num) {
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
    public static List<Integer> findFactors2(int num) {
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

    // O(N*log(log(N)))
    public static List<Integer> findPrimes(int maxNumber) {
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

    public static int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    public static boolean isPrime(int p, int maxTests) {
        for (int i = 0; i < maxTests; i++) {
            int n = rand.nextInt(p - 1) + 1;
            if (Math.pow(n, p-1) % p != 1)
                return false;
        }
        return true;
    }

    public static int exponentiate(int value, int exp) {
        final int mod = (int)Math.pow(10, 9) + 7;

        List<Integer> powers = new ArrayList<>();
        List<Integer> valueToPowers = new ArrayList<>();

        int lastPower = 1;
        int lastValue = value;

        powers.add(lastPower);
        valueToPowers.add(lastValue);

        while (lastPower < exp) {
            lastPower *= 2;
            lastValue = (lastValue * lastValue) % mod;
            powers.add(lastPower);
            valueToPowers.add(lastValue);
        }

        int result = 1;

        for (int powerIndex = powers.size()-1; powerIndex >= 0; powerIndex--) {
            if (powers.get(powerIndex) <= exp) {
                exp -= powers.get(powerIndex);
                result = (result * valueToPowers.get(powerIndex)) % mod;
            }
        }

        return result;
    }

    // O(log(power))
    public static double raiseToPower(double value, long power) {
        if (power < 0) {
            value = 1 / value;
            power = -power;
        }
        return power(value, power);
    }

    private static double power(double value, long power) {
        if (power == 1) return value;

        double res = power(value, power / 2);
        if (power % 2 == 0) return res * res;
        return res * res * value;
    }

    public static double raiseToPower2(double value, int power) {
        if (power < 0) {
            power = -power;
            value = 1 / value;
        }
        double ans = 1;
        double cur = value;
        for (long i = power; i > 0; i /= 2) {
            if (i % 2 == 1) ans *= cur;
            cur *= cur;
        }
        return ans;
    }

    public static List<Integer> randomizeArray(List<Integer> arr) {
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
