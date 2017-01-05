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
 * Created by Aakash on 01-Sep-16.
 */
public class Problem8 {

   public static void main(String[] args) {
      Problem8 prob = new Problem8();
      System.out.println(prob.myAtoi("2147483649"));
   }

   public int myAtoi(String str) {
      long n = 0;
      int signed = 1;
      boolean charFound = false;
      for(char ch : str.toCharArray()){
         if(ch >= '0' && ch <= '9'){
            n *= 10;
            n += ch - '0';
         } else {
            if(charFound){
               break;
            } else if(ch == ' '){
               continue;
            }
            signed = ch == '-'? -1 : 1;
            charFound = true;
         }
      }
      if(n > Integer.MAX_VALUE){
         return Integer.MAX_VALUE;
      } else if (n < Integer.MIN_VALUE){
         return Integer.MIN_VALUE;
      }
      return  (int) n * signed;
   }
}
