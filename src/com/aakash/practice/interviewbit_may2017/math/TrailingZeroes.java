package com.aakash.practice.interviewbit_may2017.math;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/17/17.
 */

public class TrailingZeroes {

    public int trailingZeroes(int a) {
        int f2 = 0, f5 = 0;
        for (int i = 2; i <= a; i++) {
            f2 += getFactors(i, 2);
            f5 += getFactors(i, 5);
        }
        return Math.min(f2, f5);
    }

    private int getFactors(int n, int k) {
        int count = 0;
        while (n > 0) {
            if (n % k != 0) {
                break;
            }
            n = n / k;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TrailingZeroes tz = new TrailingZeroes();
        System.out.println(tz.trailingZeroes(0));
    }


}

