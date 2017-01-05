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
package com.interviewbit.binarysearch;

/**
 * Created by Aakash on 05-Sep-16.
 */

import java.util.Arrays;
import java.util.List;

/**
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.
 */
public class RotatedArray {

   public static void main(String[] args) {
      RotatedArray ra = new RotatedArray();
      System.out.println(ra.findMin(Arrays.asList(new Integer[] {4,5,1,2,3})));
   }

   public int findMin(final List<Integer> a) {
      int left = 0, right = a.size()-1;
      while(left < right){
         int mid = left + (right - left)/2;
         if(a.get(mid) > a.get(right)){
            left = mid+1;
         } else {
            right = mid;
         }
      }
      return a.get(left);
   }
}
