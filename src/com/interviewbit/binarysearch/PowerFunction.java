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
package com.interviewbit.binarysearch;

/**
 * Created by Aakash on 05-Sep-16.
 */

/**
 * Implement pow(x, n) % d.

 In other words, given x, n and d,

 find (x^n % d)

 Note that remainders on division cannot be negative. 
 In other words, make sure the answer you return is non negative.
 */
public class PowerFunction {

   public static void main(String[] args) {
      PowerFunction pf = new PowerFunction();
      System.out.println(pf.pow(-1, 2, 20));
   }

   public int pow(int x, int n, int d) {
      long result = 1;
      long square = x;
      if(x == 0)
         return 0;
      if(n == 0)
         return 1;
      while(n != 0){
         if(n % 2 != 0){
            result = result *  square;
         }
         square = (square * square) % d;
         n = n/2;
         if(result > d)
            result = result % d;
      }
      if(result < 0){
         return (int) (result + d);
      }
      return (int) result;
   }
}
