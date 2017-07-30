package com.aakash.practice.leetcode.may2017;

import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/8/17.
 */
public class Problem575 {

    public int distributeCandies(int[] candies) {
        int type = typeOfCandies(candies);
        int n = candies.length;

        return Math.min(type, n/2);

    }

    private int typeOfCandies(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        int t = candies[0];
        for(int i=1;i<candies.length;i++){
            if(t != candies[i]){
                count++;
                t = candies[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem575 problem575 = new Problem575();
        int[] candies = new int[]{1, 1, 1, 1};
        System.out.println(problem575.distributeCandies(candies));
    }

}
