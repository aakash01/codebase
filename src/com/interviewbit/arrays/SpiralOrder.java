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
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Aakash on 15-Aug-16.
 */
public class SpiralOrder {

   public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      // Populate result;
      if(a == null || a.size() ==0 ) return null;
      int m = a.size();
      int n = a.get(0).size();

      int x = 0;int y=0;

      while(m > 0 && n > 0){
         //single row
         if(m == 1){
            for(int i=0;i<=n-1;i++){
               result.add(a.get(x).get(y));
               y++;
            }
            break;
         } else if(n == 1){
            for(int i=0;i<=m-1;i++){
               result.add(a.get(x).get(y));
               x++;
            }
            break;
         }

         for(int i=0;i<n-1;i++){
            result.add(a.get(x).get(y));
            y++;
         }
         for(int i=0;i<m-1;i++){
            result.add(a.get(x).get(y));
            x++;
         }
         for(int i=0;i<n-1;i++){
            result.add(a.get(x).get(y));
            y--;
         }
         for(int i=0;i<m-1;i++){
            result.add(a.get(x).get(y));
            x--;
         }
         x++;
         y++;
         n -=2;
         m -=2;

      }

      return result;
   }

   public ArrayList<Integer> allFactors(int a) {
      Set<Integer> factors = new TreeSet<>();
      for(int i=1;i<=Math.sqrt(a);i++){
         if(a%i == 0){
            factors.add(i);
            factors.add(a/i);
         }
      }
      
      return new ArrayList<>(factors);
   }
   
   public StringBuilder change(StringBuilder sb){
      sb.append("new");
      return sb;
   }

   public static void main(String[] args) {
      SpiralOrder so = new SpiralOrder();
      
      ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(new Integer[]{1}));
      ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(new Integer[]{3}));
      ArrayList<Integer> l3 = new ArrayList<>(Arrays.asList(new Integer[]{5}));
      
      List<ArrayList<Integer>> list = new ArrayList<>();
      list.add(l1);
      list.add(l2);
      list.add(l3);
      System.out.println(so.spiralOrder(list));
      StringBuilder sb = new StringBuilder();
      sb.append("old");
      System.out.println(sb);
      so.change(sb);
      System.out.println(sb);
   }
}
