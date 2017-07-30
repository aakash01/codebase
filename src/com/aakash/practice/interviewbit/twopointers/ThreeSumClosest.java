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
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Aakash on 10-Sep-16.
 */
public class ThreeSumClosest {
   static AtomicInteger count = new AtomicInteger(0);
   static ThreeSumClosest[] instances = new ThreeSumClosest[3];
   public static ThreeSumClosest getInstance(){
      count.incrementAndGet();
      return instances[count.get()%3];
   }

   public static void main(String[] args) {
      ThreeSumClosest tsc = new ThreeSumClosest();
      System.out.println(tsc.threeSumClosest(new ArrayList<Integer>(Arrays.asList(new Integer[]{10, -6, 3, 4, -8, -5 })), 3));
   }

   public int threeSumClosest(ArrayList<Integer> a, int b) {
      int sum = Integer.MAX_VALUE;
      Collections.sort(a);
      for(int i = 0;i<a.size()-2;i++){
         int minSum = Integer.MAX_VALUE;
         int maxSum = Integer.MAX_VALUE;
         int reqSum = b - a.get(i);
         for(int j=i+1, z = a.size()-1;j<a.size()&& z>i && j<z;){
            int tempSum = a.get(j)+a.get(z);
            if(tempSum == reqSum){
               return b;
            } else if(tempSum > reqSum){
               z--;
               maxSum = tempSum;
            } else {
               minSum = tempSum;
               j++;
            }
         }
         int tempMin;
         if(maxSum == Integer.MAX_VALUE){
            tempMin = minSum + a.get(i);
         } else if(minSum == Integer.MAX_VALUE){
            tempMin = maxSum + a.get(i);
         } else {
            minSum += a.get(i);
            maxSum += a.get(i);
            tempMin = Math.abs(maxSum - b) > Math.abs(minSum - b) ? minSum : maxSum;
         }
         if(sum == Integer.MAX_VALUE){
            sum = tempMin;
         } else {
            sum = Math.abs(sum - b) > Math.abs(tempMin - b) ? tempMin : sum;
         }
      }
      return sum;
   }
}
