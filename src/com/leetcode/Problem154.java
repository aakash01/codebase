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
package com.leetcode;

/**
 * Created by Aakash on 31-Aug-16.
 */
public class Problem154 {

   public static void main(String[] args) {
      Problem154 prob = new Problem154();
      System.out.println(prob.findMin(new int[]{1,1}));
   }

   public int findMin(int[] nums) {
      int L= 0, R = nums.length-1;
      while(nums[L]>=nums[R] && L < R){
         int M = L + (R-L)/2;
         if(nums[M] == nums[R] && nums[M] == nums[L]){
            L++;
            R--;
         }
         else if(nums[M] > nums[R]){
            L = M+1;
         } else {
            R = M;
         }
      }
      return nums[L];
   }
}
