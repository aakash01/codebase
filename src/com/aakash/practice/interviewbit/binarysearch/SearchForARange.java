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
package com.aakash.practice.interviewbit.binarysearch;

/**
 * Created by Aakash on 05-Sep-16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm’s runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].
 */
public class SearchForARange {

   public static void main(String[] args) {
      SearchForARange sr = new SearchForARange();
      System.out.println(sr.searchRange(Arrays.asList(new Integer[]{5, 7, 7, 8, 8, 10}), 5));
   }

   public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
      
         int left = findFirstIndex(a, b);
         int right = findLastIndex(a, b);
         return new ArrayList<>(Arrays.asList(new Integer[]{left, right}));
      }
   public int findFirstIndex(final List<Integer> a, int b){
      int left = 0, right = a.size() - 1;
      while(left <= right){
         int mid = left + (right - left)/2;
         if(a.get(mid) == b){
            if(mid == left || a.get(mid -1 ) < b)
               return mid;
            else {
               right = mid -1;
            }
         } else if(a.get(mid) > b){
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }
      return -1;
   }

   public int findLastIndex(final List<Integer> a, int b){
      int left = 0, right = a.size() - 1;
      while(left <= right){
         int mid = left + (right - left)/2;
         if(a.get(mid) == b){
            if(mid == right || a.get(mid +1  ) > b)
               return mid;
            else {
               left = mid + 1;
            }
         } else if(a.get(mid) > b){
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }
      return -1;
   }
}
