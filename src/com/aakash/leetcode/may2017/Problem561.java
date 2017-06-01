package com.aakash.leetcode.may2017;

import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/4/17.
 */
public class Problem561 {

    public int arrayPairSum(int[] nums){

        if(nums.length % 2 != 0){
            throw new RuntimeException("length error");
        }

        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i=i+2){
            count += nums[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Problem561 problem561 = new Problem561();
        int[] nums = new int[]{3,4,1,2};
        System.out.println(problem561.arrayPairSum(nums));
    }
}
