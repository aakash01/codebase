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
 * Created by Aakash on 03-Oct-16.
 */
public class Test {

   public static void main(String[] args) {
      int count = 0;
      for(int i=1;i<=100;i++){
         int factors = 0;
         for(int j=1;j<=i;j++){
            if(i%j == 0){
               factors++;
            }
         }
         if(factors%2 !=0){
            System.out.print(i+" ");
            count++;
         }
      }
      System.out.println(count);
   }
}
