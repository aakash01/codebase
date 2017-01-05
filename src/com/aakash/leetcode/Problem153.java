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
public class Problem153 {

   public static void main(String[] args) {
      Problem153 prob = new Problem153();
      System.out.println(prob.findMin(new int[]{6,1,2,3,4,5}));
   }

   public int findMin(int[] nums) {
      int L= 0, R = nums.length-1;
      while(nums[L]>nums[R]){
         int M = L + (R-L)/2;
         if(nums[M] > nums[R]){
            L = M+1;
         } else {
            R = M;
         }
      }
      return nums[L];
   }
}
