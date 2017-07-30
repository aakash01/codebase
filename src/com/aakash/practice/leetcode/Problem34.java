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
package com.aakash.practice.leetcode;

/**
 * Created by Aakash on 30-Aug-16.
 */

/**
 * Problem Statement : 
 * 
 *  Search for a Range : 
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 */
public class Problem34 {

   public static void main(String[] args) {
      Problem34 prob = new Problem34();
      int[] result = prob.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11);
      System.out.println(result[0]+", "+result[1]);
   }

   public int[] searchRange(int[] nums, int target) {
      int[] arr = new int[2];
      arr[0] = searchForRangeLeft(nums, target);
      arr[1] = searchForRangeRight(nums, target);
      return arr;
   }
   
   int searchForRangeLeft(int[] nums, int target){
      int L=0,R=nums.length-1;
      while(L <= R){
         int M = L + (R-L)/2;
         if(nums[M] == target){
            if(M ==0 || nums[M-1] < target){
               return M;
            } else {
               R = M-1;
            }
         } else if(nums[M] < target) {
            L = M+1;
         } else {
            R = M-1;
         }
      }
      return -1;
   }

   int searchForRangeRight(int[] nums, int target){
      int L=0,R=nums.length-1;
      while(L <= R){
         int M = L + (R-L)/2;
         if(nums[M] == target){
            if(M == nums.length-1 || nums[M+1] > target){
               return M;
            } else {
               L = M+1;
            }
         } else if(nums[M] < target) {
            L = M+1;
         } else {
            R = M-1;
         }
      }
      return -1;
   }
}
