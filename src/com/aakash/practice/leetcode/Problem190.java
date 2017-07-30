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
public class Problem190 {

   public static void main(String[] args) {
      Problem190 prob = new Problem190();
      System.out.println(prob.reverseBits(1));
   }

   public int reverseBits(int n) {
      String binary = Integer.toBinaryString(n);
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<32-binary.length();i++){
         sb.append("0");
      }
      sb.append(binary);
      
      sb = sb.reverse();
      return (int) Long.parseLong(sb.toString(), 2);
   }
   
}
