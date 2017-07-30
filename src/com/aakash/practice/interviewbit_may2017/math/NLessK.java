package com.aakash.practice.interviewbit_may2017.math;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/17/17.
 */
@AwesomeQuestion
public class NLessK {

    public int solve(ArrayList<Integer> A, int B, int C) {
        return helper(A, B, String.valueOf(C), false);
    }

    private int helper(ArrayList<Integer> A, int B, String cStr, boolean flag){
        if(cStr == "0" || cStr.length() < B || A.size() == 0){
            return 0;
        }
        int count = 0;
        int C = Integer.valueOf(cStr);
        if(B  == 1){
            for(Integer i : A){
                if(i < C && i<=9){
                    count++;
                }
            }
            return count;
        }

        int n = A.size();
        int x = cStr.charAt(0) - '0';
        if(cStr.length() > B){
            if(A.get(0) == 0){
                count += (n-1) * Math.pow(n, B-1);
            } else {
                count += Math.pow(n, B);
            }
        } else {
            for (Integer i : A) {
                if (i < x && (flag || i > 0)) {
                    count += Math.pow(n, B - 1);
                }
            }
            if (A.contains(x) && cStr.length() > 1) {
                count += helper(A, B - 1, cStr.substring(1), true);
            }
        }
        return count;
    }



    public int solve2(ArrayList<Integer> A, int B, int C) {
        String cStr = String.valueOf(C);
        if(C == 0 || cStr.length() < B || A.size() == 0){
            return 0;
        }
        int count = 0;
        if(B  == 1){
            for(Integer i : A){
                if(i < C && i<=9){
                    count++;
                }
            }
            return count;
        }

        int d = A.size(), d2;
        int x = cStr.charAt(0) - '0';
        if(cStr.length() > B){
            if(A.get(0) == 0){
                count += (d-1) * Math.pow(d, B-1);
            } else {
                count += Math.pow(d, B);
            }
        } else {
            int dp[] = new int[B + 1];
            int[] lower = new int[11];
            for(int i = 0; i <= B; i++)
                dp[i] = 0;
            for(int i = 0; i <= 10; i++)
                lower[i] = 0;
            for(int i = 0; i < d; i++)
                lower[A.get(i) + 1] = 1;

            for(int i = 1; i <= 10; i++)
                lower[i] = lower[i-1] + lower[i];

            boolean flag = true;
            dp[0] = 0;
            for(int i = 1; i <= B; i++) {
                d2 = lower[cStr.charAt(i-1) - '0'];
                dp[i] = dp[i-1] * d;

                // For first index we can't use 0
                if(i == 1 &&  A.get(0) == 0 && B != 1)
                    d2 = d2 - 1;

                //Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
                if(flag)
                    dp[i] += d2;
                //Is digit[i - 1] present in A ?
                flag = flag & (lower[(cStr.charAt(i-1) - '0') + 1] == lower[cStr.charAt(i-1) - '0'] + 1);
            }
            return dp[B];
        }
        return count;
    }

    public static void main(String[] args) {
        NLessK nLessK = new NLessK();
        // not working.
        System.out.println(nLessK.solve(new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 7, 8, 9})), 5, 10004));
    }
}
