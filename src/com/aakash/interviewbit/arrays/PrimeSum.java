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
package com.aakash.interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by Aakash on 17-Aug-16.
 */
public class PrimeSum {

   public ArrayList<Integer> primesum(int a) {
      ArrayList<Integer> output = new ArrayList<>();
      ArrayList<Integer> primes = sieve(a);
      int i=0,j=primes.size()-1;
      while (primes.get(i) <= a/2 && primes.get(j) >= a/2){
         int sum = primes.get(i) + primes.get(j);
         if(sum == a){
            output.add(primes.get(i));
            output.add(primes.get(j));
            break;
         }
         if(sum < a){
            i++;
         } else {
            j--;
         }
      }
      return output;
   }

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
      PrimeSum sum = new PrimeSum();
      System.out.println(sum.primesum(6));
   }
   
}
