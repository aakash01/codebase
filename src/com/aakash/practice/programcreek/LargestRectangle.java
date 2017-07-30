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
package com.aakash.practice.programcreek;

import java.util.Stack;

/**
 * Created by Aakash on 23-Aug-16.
 */
public class LargestRectangle {

   /**
    * Bruteforce. Time complexity of O(n2)
    * @param arr
    * @return
    */
   public int largestRectangle(int[] arr){
      int max = arr[0];
      
      for(int i=1;i<arr.length;i++){
         int minH = arr[i];
         for(int j=i;j>=0;j--){
            if(arr[j] < minH){
               minH = arr[j];
            }
            int area = (i-j +1)*minH;
            if(area > max){
               max = area;
            }
         }
      }
      return max;
   }

   /**
    * Maintaining a non decreasing stack. 
    * @param arr
    */
   
   public int largestRectangleStack(int[] arr){
      int max = -1;
      Stack<Integer> stack  = new Stack<>();
      for(int i=0;i<arr.length;i++){
         int count = 0;
         while(!stack.isEmpty() && stack.peek() > arr[i]){
            count++;
            int h = stack.pop();
            if(max < h * count){
               max = h * count;
            }
         }
         
         for(int j=0;j<=count;j++){
            stack.push(arr[i]);
         }
      }
      int count = 0;
      while(!stack.isEmpty()){
         count++;
         int  h = stack.pop();
         if(max < h * count){
            max = h*count;
         }
      }
      return max;
   }

   public static void main(String[] args) {
      LargestRectangle lr = new LargestRectangle();
      System.out.println(lr.largestRectangle(new int[]{2,3,3,4,5}));
      System.out.println(lr.largestRectangleStack(new int[]{2,3,3,4,5}));
   }
}
