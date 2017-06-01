package com.aakash.leetcode.may2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/8/17.
 */
public class Problem496 {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> ngeMap = preprocess(nums);
        int[] output = new int[findNums.length];
        for(int i=0;i<findNums.length;i++){
            int ngeI = ngeMap.get(findNums[i]);
            output[i] = ngeI == -1 ? -1 : nums[ngeI];
        }
        return output;
    }

    private Map<Integer, Integer> preprocess(int[] nums) {
        Map<Integer, Integer> ngeMap = new HashMap<>();

        if(nums != null && nums.length > 1) {
            int len = nums.length ;
            ngeMap.put(nums[len - 1], -1);
            for (int i = len - 2; i >= 0; i--) {
                int n = nums[i];
                int ni = i + 1;
                while (ni != -1 && nums[ni] < n) {
                    ni = ngeMap.get(nums[ni]);
                }
                ngeMap.put(n, ni);
            }
        }
        return ngeMap;
    }

    public static void main(String[] args) {
        Problem496 problem496 = new Problem496();
        System.out.println(Arrays.toString(problem496.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }

}
