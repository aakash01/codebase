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
 * Created by Aakash on 03-Sep-16.
 */

/**
 * 169. Majority Element
 */
public class Problem169 {

   public static void main(String[] args) {
      Problem169 prob = new Problem169();
      System.out.println(prob.majorityElement(new int[] { 1, 1, 3, 3, 3 }));
   }

   public int majorityElement(int[] nums) {
      int count = 0;
      int currMax = 0;
      for (int num : nums) {
         if (count == 0) {
            currMax = num;
         }
         if (currMax != num) {
            count--;
         } else {
            count++;
         }
      }
      return currMax;
   }
}
