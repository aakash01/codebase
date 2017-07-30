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
package com.aakash.practice.leetcode;

/**
 * Created by Aakash on 30-Aug-16.
 */
public class Problem35 {

   public static void main(String[] args) {
      Problem35 prob = new Problem35();
      System.out.println(prob.searchInsert(new int[]{1,3,7,8,10},8));
   }
   public int searchInsert(int[] nums, int target) {
      int L=0,R=nums.length-1;
      while(L <= R){
         int M = L + (R-L)/2;
         if(nums[M] == target){
            return M;
         } else if(nums[M]>target){
            R = M-1;
         } else {
            L = M+1;
         }
      }
      return L;
   }
}
