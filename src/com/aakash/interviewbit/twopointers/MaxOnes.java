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
package com.aakash.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class MaxOnes {
   
   public static void main(String[] args) {
      MaxOnes mo = new MaxOnes();
      System.out.println(mo.maxone(new ArrayList<Integer>(Arrays.asList(new Integer[]{ 0, 1, 1, 1})), 10));
   }

   public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
      
      int maxSum = Integer.MIN_VALUE, maxStart = -1, maxEnd = -1;
      
      List<Integer> zeroList = new ArrayList<>();
      for(int i=0;i<a.size();i++){
         if(a.get(i) == 0){
            zeroList.add(i);
         }
      }
      if(b > zeroList.size()){
         b = zeroList.size();
      }
      zeroList.add(0, -1);
      zeroList.add(a.size());
      
      for(int i=1;i<zeroList.size() && (i+b) < zeroList.size();i++){
         int start  = zeroList.get(i-1) + 1;
         int end = zeroList.get(i+b) -1;
         
         if(end - start > maxSum){
            maxSum = end - start;
            maxStart = start;
            maxEnd = end;
         }
      }
      
      ArrayList<Integer> output = new ArrayList<>();
      if(maxStart != -1) {
         for (int i = maxStart; i <= maxEnd; i++) {
            output.add(i);
         }
      }
      return output;
   }
}
