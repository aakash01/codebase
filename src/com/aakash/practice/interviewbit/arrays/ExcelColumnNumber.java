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
public class ExcelColumnNumber {
   public int titleToNumber(String a) {
      int num = 0;
     for(char ch : a.toCharArray()){
        num = num*26 + (ch -'A' +1);
     }
      return num;
   }

   public static void main(String[] args) {
      ExcelColumnNumber ecn = new ExcelColumnNumber();
      System.out.println(ecn.titleToNumber("ABCD"));
   }
}
