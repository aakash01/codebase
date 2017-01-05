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

/**
 * Created by Aakash on 17-Aug-16.
 */
public class UniquePaths {

   public int uniquePaths(int a, int b) {
      if(a==1 || b==1){
         return 1;
      }
      return uniquePaths(a-1, b) + uniquePaths(a, b-1);
   }

   public static void main(String[] args) {
      UniquePaths up =new UniquePaths();
      System.out.println(up.uniquePaths(15, 15));
   }
}
