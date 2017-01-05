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
public class Problem191 {

   public static void main(String[] args) {
      Problem191 prob = new Problem191();
      System.out.println(prob.hammingWeight(9));
   }

   public int hammingWeight(int n) {
      int count = 0;
      while(n != 0){
         count++;
         n &= n-1;
      }
      return count;
   }
   
}
