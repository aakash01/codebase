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
package com.aakash.personal;

/**
 * Created by Aakash on 31-Aug-16.
 */
public class PascalTriangle {

   public static void main(String[] args) {
      pascalTriangle(1);
   }
   static void pascalTriangle(int k) {
      int[] a = new int[26];
      int temp = 0;
      for(int i=1;i<=k;i++){
         for(int j = 1;j <= i; j++){
            int temp2 = a[j-1];
            if(j == 1 || j == i){
               a[j-1] =  1;
            } else {
               a[j-1] = temp+a[j-1];
            }
            temp = temp2;
            
            System.out.print(a[j-1]);
         }
         System.out.println();
      }

   }
}
