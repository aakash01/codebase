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
public class KthRowPascal {
   public ArrayList<Integer> getRow(int a) {
      ArrayList<Integer> result = new ArrayList<>(a);
      int p1 = 0, p2;
      for(int i=1;i<=a+1;i++){
         result.add(0);
         for(int j=1;j<=i;j++){
            if(j == 1 || j == i){
               p1 = 1;
               result.set(j-1, 1);
            } else {
               p2 = result.get(j-1);
               result.set(j-1, p1 + result.get(j-1));
               p1 = p2;
            }
         }
      }
      return result;
   }

   public static void main(String[] args) {
      KthRowPascal pascal = new KthRowPascal();
      System.out.println(pascal.getRow(6));
   }
}
