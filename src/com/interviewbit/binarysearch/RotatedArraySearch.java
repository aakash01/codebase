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
 * Created by Aakash on 10-Sep-16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

 You are given a target value to search. If found in the array, return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Input : [4 5 6 7 0 1 2] and target = 4
 Output : 0

 */
public class RotatedArraySearch {

   public static void main(String[] args) {
      RotatedArraySearch rs = new RotatedArraySearch();
      System.out.println(rs.search(new ArrayList<Integer>(Arrays.asList(new Integer[]{4,5, 6, 7, 0, 1, 2})), 2));
   }

   public int search(final List<Integer> a, int b) {
      int l = 0, r = a.size() - 1;
      while(l <= r){
         int m = l + (r - l)/2;
         if(a.get(m) == b){
            return m;
         } else if(a.get(m) > a.get(l)){
            if(a.get(l)<=b && a.get(m) > b){
               r = m-1;
            } else {
               l = m+1;
            }
         } else {
            if(a.get(r) >= b  && a.get(m) < b){
               l = m+1;
            } else {
               r = m-1;
            }
         }
      }
      return -1;
   }
}
