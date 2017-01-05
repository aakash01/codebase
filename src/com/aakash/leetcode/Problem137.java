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
 * Created by Aakash on 03-Sep-16.
 */
public class Problem137 {

   public static void main(String[] args) {
      Problem137 prob = new Problem137();
      System.out.println(prob.singleNumber(new int[]{1,2,4,4,5,5,5,2,2,1,1}));
   }

   public int singleNumber(int[] nums) {
      int ones = 0, twos = 0;
      for(int i=0;i< nums.length;i++){
         ones = (ones ^ nums[i]) & ~twos;
         twos = (twos ^ nums[i]) & ~ones;
      }
      return ones;
   }
}
