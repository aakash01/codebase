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
package com.aakash.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash on 16-Aug-16.
 */
public class MaxSumContiguousSubArray {

   public int maxSubArray(final List<Integer> a) {
      
      int maxSum = a.get(0);
      int currSum = a.get(0);
      
      for(int i=1;i<a.size();i++){
         if(currSum < 0 ){
            currSum = 0;
         }
         currSum += a.get(i);
         if(currSum > maxSum){
            maxSum = currSum;
         }
      }
      return maxSum;
   }

   public static void main(String[] args) {
      MaxSumContiguousSubArray sa = new MaxSumContiguousSubArray();
      List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{-1, -2, -3, -3}));
      System.out.println(sa.maxSubArray(list));
   }
}
