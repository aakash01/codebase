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
 * Created by Aakash on 02-Sep-16.
 */
public class Problem13 {
   private int[] intArr = {1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
   private String[] romanArr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

   public int romanToInt(String s) {
      int n=0;
      int i=0;
      while(s != null && s.length() > 0){
         if(s.startsWith(romanArr[i])){
            s = s.replaceFirst(romanArr[i],"");
            n += intArr[i];
         } else {
            i++;
         }
      }
      return n;
   }
   public static void main(String[] args) {
      Problem13 prob = new Problem13();
      System.out.println(prob.romanToInt("CIX"));
   }
}
