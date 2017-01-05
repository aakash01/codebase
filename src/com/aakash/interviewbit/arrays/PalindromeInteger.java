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
package com.aakash.interviewbit.arrays;

/**
 * Created by Aakash on 17-Aug-16.
 */
public class PalindromeInteger {

   public boolean isPalindrome(int a) {
      int n = 0;
      int temp = a;
      while(temp != 0){
         n = n*10 + temp%10;
         temp /=10;
      }
      return n == a;
   }

   public static void main(String[] args) {
      PalindromeInteger pi = new PalindromeInteger();
      System.out.println(pi.isPalindrome(123));
   }
}
