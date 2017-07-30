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
 * Created by Aakash on 01-Sep-16.
 */
public class Problem6 {

   public static void main(String[] args) {
      Problem6 prob = new Problem6();
      System.out.println(prob.convert("PAYPALISHIRING", 1));
   }
   
   //PAHNAPLSIIGYIR
   //PAHNAPLSIIGYIR
   public String convert(String s, int numRows) {
      char[] chArray  =new char[s.length()];
      int n = 2*numRows - 2;
      if(n == 0){
         n = 1;
      }
      int j= 0;
      for(int i=0;i<numRows;i++){
         int k = i;
         while(k<s.length()){
            if(j == s.length()){
               break;
            }
            chArray[j++] = s.charAt(k);
            int next = k+ 2*(numRows - 1 - i);
            if(i!= 0 && i!=numRows-1 && next < s.length()){
               chArray[j++] = s.charAt(next);
            }
            k+=n;
         }
      }
      return String.copyValueOf(chArray);
   }
}
