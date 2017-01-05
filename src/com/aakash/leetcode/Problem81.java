/*
 * This computer program is the confidential information and proprietary trade
 * secret of Anuta Networks, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and
 * Anuta Networks, Inc., and receipt or possession does not convey any rights
 * to divulge, reproduce, or allow others to use this program without specific
 * written authorization of Anuta Networks, Inc.
 * 
 * Copyright (c) 2011-2012 Anuta Networks, Inc. All Rights Reserved.
 */
package com.aakash.leetcode;

/**
 * Created by Aakash on 31-Aug-16.
 */

/**
 * Sample test cases
 * 
 * [1,1,3,1] 3
 * [3,1,1] 3
 */
public class Problem81 {

   public static void main(String[] args) {
      Problem81 prob = new Problem81();
      System.out.println(prob.search(new int[]{3,1,3,3,3}, 1));
   }

   public boolean search(int[] nums, int target) {
      int L = 0, R = nums.length-1;
      while(L<=R){
         int M = L + (R-L)/2;
         if(nums[M] == target){
            return true;
         } else if(nums[M] == nums[R] && nums[M] == nums[L]){
            L++;
            R--;
         } else if(nums[M] <= nums[R]){
            if(target > nums[M] && target <= nums[R]){
               L = M+1;
            } else {
               R = M-1;
            }
         } else {
            if(target < nums[M] && target >= nums[L]){
               R = M-1;
            } else {
               L = M+1;
            }
         }
      }
      return false;
   }
}
