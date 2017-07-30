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
 * Created by Aakash on 02-Sep-16.
 */
public class Problem12 {
   private int[] intArr = {1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
   private String[] romanArr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
   public String intToRoman(int num) {
      StringBuilder sb = new StringBuilder();
      int i=0;
      while(num > 0){
         if(intArr[i] <= num){
            sb.append(romanArr[i]);
            num = num - intArr[i];
         } else {
            i++;
         }
      }
      return sb.toString();
   }

   public static void main(String[] args) {
      Problem12 prob = new Problem12();
      System.out.println(prob.intToRoman(3899));
   }
}
