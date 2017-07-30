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
package com.aakash.practice.interviewbit.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class ColorfulHashing {

   public int colorful(int a) {
      
      String s = ""+a;

      Set<Integer> product = new HashSet<>();
      for(int i=1;i<=s.length();i++){
         for(int j=0;j<=s.length() - i;j++){
            String s1 = s.substring(j, j+i);
            int pr  = getProduct(s1);
            if(product.contains(pr)){
               return 0;
            }
            product.add(pr);
         }
      }
      return 1;
   }
   
   private int getProduct(String s){
      int product = 1;
      int i = Integer.parseInt(s);
      while(i>0){
         product *= (i%10);
         i = i/10;
      }
      return product;
   }

   public int colorful2(int a) {
      int len = numLength(a);
      int nC = (int) (Math.pow(2, len) -1);

      Set<Integer> product = new HashSet<>();
      for(int i=1;i<=nC; i++){
         int pr  = getProduct(a, i);
         if(product.contains(pr)){
            return 0;
         }
         product.add(pr);
      }
      return 1;
   }
   
   private int getProduct(int a, int i){
      int product = 1;
      while(i > 0){
         int set = i & 1;
         int d = a%10;
         if(set == 1){
            product *= d;
         }
         i >>=1;
         a /=10;
      }
      return product;
   }
   
   private int numLength(int a){
      int count = 0;
      while(a > 0){
         a = a/10;
         count++;
      }
      return count;
   }
}
