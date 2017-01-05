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

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash on 05-Sep-16.
 */
public class CountElements {

   public static void main(String[] args) {
      CountElements ce = new CountElements();
      System.out.println(ce.findCount(Arrays.asList(new Integer[]{5, 7, 10}), 8));
   }

   public int findCount(final List<Integer> a, int b) {
      int left = findFirstIndex(a, b);
      int right = findLastIndex(a, b);
      if(left != -1 && right != -1){
         return right - left +1;
      }
      return -1;
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
