package com.aakash.practice.hackerrank;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/26/17.
 */
public class NumberLetterCount {

    private static Map<Integer, Integer> charCountMap = new HashMap<>();
    static {
        charCountMap.put(0, 0);
        charCountMap.put(1, 3);
        charCountMap.put(2, 3);
        charCountMap.put(3, 5);
        charCountMap.put(4, 4);
        charCountMap.put(5, 4);
        charCountMap.put(6, 3);
        charCountMap.put(7, 5);
        charCountMap.put(8, 5);
        charCountMap.put(9, 4);
        charCountMap.put(10, 3);
        charCountMap.put(11, 6);
        charCountMap.put(12, 6);
        charCountMap.put(13, 8);
        charCountMap.put(14, 8);
        charCountMap.put(15, 7);
        charCountMap.put(16, 7);
        charCountMap.put(17, 9);
        charCountMap.put(18, 8);
        charCountMap.put(19, 8);
        charCountMap.put(20, 6);
        charCountMap.put(30, 6);
        charCountMap.put(40, 5);
        charCountMap.put(50, 5);
        charCountMap.put(60, 5);
        charCountMap.put(70, 7);
        charCountMap.put(80, 6);
        charCountMap.put(90, 6);
    }

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int i = a.nextInt();
        while(i-- > 0){
            int k = a.nextInt();
            System.out.println(getTotalSum(k));
        }
    }

    private static int getTotalSum(int n) {
        int totalSum = 0;
        for (int i = 1; i <= n; i++) {
            int currSum;
            if (i < 20) { 
                currSum = charCountMap.get(i);
            } else if (i < 100) {
                currSum = charCountMap.get(i - (i % 10)) + charCountMap.get(i % 10);
                // store sum of curr number.
                charCountMap.put(i, currSum);
            } else if (i < 1000) {
                if (i % 100 == 0) {
                    currSum = charCountMap.get(i / 100) + "hundred".length();
                } else {
                    currSum = charCountMap.get(i / 100) + "hundred".length() + "and".length() + charCountMap.get(i % 100);
                }
            } else {
                currSum = 11; // one thousand
            }
            totalSum += currSum;
        }
        return totalSum;
    }
}
