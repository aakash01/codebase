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
 * Created by Aakash on 10-Sep-16.
 */
public class SquareRoot {

   public static void main(String[] args) {
      SquareRoot sr = new SquareRoot();
      System.out.println(sr.sqrt(2147483615));
   }

   public int sqrt(int a) {
      if(a == 1 || a == 2){
         return 1;
      }
      if(a == 0){
         return 0;
      }
      int l = 1, r = Integer.MAX_VALUE;
      do{
         int temp;
         if(r == Integer.MAX_VALUE){
            temp = l * 2;
         }else {
            temp = l + (r - l)/2;
         }
         if(temp > 46340){
            r = temp;
            temp = 46340;
         }
         int sqTemp = temp * temp;
         if(sqTemp == a){
            return temp;
         } else if(sqTemp < a){
            l = temp;
         } else {
            r = temp;
         }
      }while(r - l > 1);
      return l;
   }
}
