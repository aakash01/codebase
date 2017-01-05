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
package com.interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by Aakash on 17-Aug-16.
 */
public class SievePrime {
   public ArrayList<Integer> sieve(int a) {
      ArrayList<Integer> list = new ArrayList<>();
      boolean[] arr = new boolean[a+1];
      for(int i=2;i<=a;i++){
         arr[i] = true;
      }
      for(int i=2;i<=Math.sqrt(a);i++){
         if(arr[i] == true){
            for(int j = i*i;j<=a;j+=i){
               arr[j] = false;
            }
         }
      }
      for(int i=2;i<=a;i++){
         if(arr[i] == true){
            list.add(i);
         }
      }
      return list;
   }

   public static void main(String[] args) {
      SievePrime sp = new SievePrime();
      System.out.println(sp.sieve(100));
   }
}
