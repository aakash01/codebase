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
package com.aakash.practice.personal;

/**
 * Created by Aakash on 18-Sep-16.
 */
public class SortBinary {

   public static void main(String[] args) {
      System.out.println(sortBinarySwaps("011001"));
      System.out.println(sortBinarySwaps("1111"));
      System.out.println(sortBinarySwaps("0000"));
      System.out.println(sortBinarySwaps("1111000"));
      System.out.println(sortBinarySwaps("0000111"));
   }
   
   static int sortBinarySwaps(String s){
      int i=0,j=s.length()-1;
      int count = 0;
      while(i<j){
         while(i<j && s.charAt(i) == '0'){
            i++;
         }
         while(i<j && s.charAt(j) == '1'){
            j--;
         }
         
         if(i<j){
            count++;
            i++;
            j--;
         }
      }
      return count;
   }
}
