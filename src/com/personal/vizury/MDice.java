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
package com.personal.vizury;

/**
 * Created by Aakash on 20-Sep-16.
 */
public class MDice {

   public static void main(String[] args) {
      System.out.println(getCombinations(3, 6, 1));
   }
   
   public static int getCombinations(int m, int n, int min){
      if(m == 0){
         return 0;
      }
      if(m == 1){
         if(n >= min && n <= n){
            return 1;
         }
         return 0;
      }
      
      int count = 0;
      for(int i=min;i<=6;i++){
         count += getCombinations(m-1, n-i, i);
      }
      return count;
   }
}
