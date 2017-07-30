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

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.
 */
public class SortedInsertPosition {

   public static void main(String[] args) {
      SortedInsertPosition sip = new SortedInsertPosition();
      System.out.println(sip.searchInsert(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,3,5,6})), 0));
   }

   public int searchInsert(ArrayList<Integer> a, int b) {
      int left = 0, right = a.size()-1;
      while(left <= right){
         int mid = left + (right- left)/2;
         if(a.get(mid) == b){
            return mid;
         } else if(a.get(mid) > b){
            right = mid -1;
         } else {
            left = mid +1;
         }
      }
      return left;
   }
   
   
}
