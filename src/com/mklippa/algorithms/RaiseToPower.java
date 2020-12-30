package com.mklippa.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RaiseToPower {
    public int exponentiate(int value, int exp) {
        List<Integer> powers = new ArrayList<>();
        List<Integer> valueToPowers = new ArrayList<>();

        int lastPower = 1;
        int lastValue = value;

        powers.add(lastPower);
        valueToPowers.add(lastValue);

        while (lastPower < exp) {
            lastPower *= 2;
            lastValue *= lastValue;
            powers.add(lastPower);
            valueToPowers.add(lastValue);
        }

        int result = 1;

        for (int powerIndex = powers.size()-1; powerIndex >= 0; powerIndex--) {
            if (powers.get(powerIndex) <= exp) {
                exp -= powers.get(powerIndex);
                result *= valueToPowers.get(powerIndex);
            }
        }

        return result;
    }

    // O(log(power))
    public double solve(double value, long power) {
        if (power < 0) {
            value = 1 / value;
            power = -power;
        }
        return power(value, power);
    }

    private double power(double value, long power) {
        if (power == 1) return value;

        double res = power(value, power / 2);
        if (power % 2 == 0) return res * res;
        return res * res * value;
    }

    public double solve2(double value, int power) {
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
}