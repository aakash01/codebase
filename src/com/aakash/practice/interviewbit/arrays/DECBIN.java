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
package com.aakash.practice.interviewbit.arrays;

/**
 * Created by Aakash on 17-Aug-16.
 */
public class DECBIN {
   public String findDigitsInBinary(int a) {
      if(a==0){
         return "0";
      }
      StringBuilder sb = new StringBuilder();
      while(a > 0){
         sb.append(a%2);
         a /=2;
      }
      sb.reverse();
      return sb.toString();
   }

   public static void main(String[] args) {
      DECBIN sb = new DECBIN();
      Integer n = 0;
      System.out.println(sb.findDigitsInBinary(n).equals(Integer.toBinaryString(n)));
      
      
   }
}
