package com.aakash.interviewbit_may2017.arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/18/17.
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Link : https://www.interviewbit.com/problems/max-non-negative-subarray/
 */

public class MaxNonNegativeSubArray {

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long maxSum = -1;
        int maxStart = -1, maxEnd = -1;
        int currStart = 0;
        long currSum = 0;
        for(int i=0;i<a.size();i++){
            if(a.get(i) < 0){
                currSum = 0;
                currStart = i+1;
            } else {
                currSum += a.get(i);
                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxStart = currStart;
                    maxEnd = i;
                } else if (currSum == maxSum && (i - currStart) > (maxEnd - maxStart)) {
                    maxStart = currStart;
                    maxEnd = i;
                }
            }

        }

        if(maxStart == -1){
            return new ArrayList<>();
        }

       return new ArrayList<>(a.subList(maxStart, maxEnd + 1));
    }

    public static void main(String[] args) {
        MaxNonNegativeSubArray maxNonNegativeSubArray = new MaxNonNegativeSubArray();
        System.out.println(maxNonNegativeSubArray.maxset(new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368))));
    }
}
