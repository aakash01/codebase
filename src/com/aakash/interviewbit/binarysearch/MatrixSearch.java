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
package com.aakash.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash on 05-Sep-16.
 */
public class MatrixSearch {
   
   public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
      int len = a.get(0).size();
      int findRow = -1;
      int left = 0, right = a.size() -1;
      while(left <= right){
         int mid= left + (right - left)/2;
         if(a.get(mid).get(len - 1) == b){
            findRow = mid;
            break;
         } else if(a.get(mid).get(len - 1) > b){
            right = mid -1;
         } else {
            left = mid +1;
         }
      }
      if(findRow == -1 && left < a.size()){
         findRow = left;
      }
      if(findRow == -1){
         return -1;
      }
      return Arrays.binarySearch(a.get(findRow).toArray(), b);
   }
   
}
