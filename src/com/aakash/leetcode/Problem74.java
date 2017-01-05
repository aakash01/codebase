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
package com.aakash.leetcode;

import java.util.Arrays;

/**
 * Created by Aakash on 30-Aug-16.
 */
public class Problem74 {

   public static void main(String[] args) {
      Problem74 prob = new Problem74();
      int[][] matrix = new int[][]{
                     new int[]{1,   3,  5,  7},
                     new int[]{10, 11, 16, 20},
                     new int[]{23, 30, 34, 50}};
      System.out.println(prob.searchMatrix(matrix, -2));
   }
   public boolean searchMatrix(int[][] matrix, int target) {
      if(matrix.length == 0){
         return false;
      }
      int L = 0, R = matrix.length-1;
      int columnMax = matrix[0].length-1;
      int index = -1;
      while(L <= R) {
         int mid = L + (R-L)/2;
         if(matrix[mid][columnMax] == target){
            index = mid;
            break;
         } else if(matrix[mid][columnMax] > target){
            R = mid-1;
         } else {
            L = mid +1;
         }
      }
      if(index == -1){
         index = L;
      }
      if(index >= matrix.length){
         return false;
      }
      int output = Arrays.binarySearch(matrix[index], target);
      return output >= 0;
   }
}
