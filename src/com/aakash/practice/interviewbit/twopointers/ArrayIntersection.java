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
package com.aakash.practice.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class ArrayIntersection {

   public static void main(String[] args) {
      ArrayIntersection si = new ArrayIntersection();
      System.out.println(si.intersect(Arrays.asList(new Integer[]{10000000 }), Arrays.asList(new Integer[]{10000000 })));
   }

   public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
      ArrayList<Integer> output = new ArrayList<>();
      
      for(int i=0,j=0;i<a.size() && j<b.size();){
         if(a.get(i).equals(b.get(j))){
            output.add(a.get(i));
            i++;
            j++;
         }
         else if(a.get(i) < b.get(j)){
            i++;
         }
         else if(a.get(i) > b.get(j)){
            j++;
         }
      }
      return output;
   }
}
