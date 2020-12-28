package com.mklippa.algorithms;

public class RaiseToPower {

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