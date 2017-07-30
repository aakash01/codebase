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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash on 03-Sep-16.
 */
public class Problem78 {

   public static void main(String[] args) {
      Problem78 prob = new Problem78();
      System.out.println(prob.subsets(new int[]{1, 2, 3}));
      System.out.println(prob.subsetsRecursive(new int[]{1,2,3}, 0 ));
   }

   public List<List<Integer>> subsetsRecursive(int[] nums, int start){
      List<List<Integer>> output = new ArrayList<>();
      if(start == nums.length){
         output.add(new ArrayList<Integer>());
         return output;
      }
      List<List<Integer>> subs = subsetsRecursive(nums, start +1);
      output.addAll(subs);
      for(List<Integer> sub : subs ) {
         List<Integer> l1 = new ArrayList<>();
         for(int i : sub){
            l1.add(i);
         }
         l1.add(nums[start]);
         output.add(l1);
      }
      return output;
   }

   public List<List<Integer>> subsets(int[] nums) {
      double numOfCombinations = Math.pow(2, nums.length);
      List<List<Integer>> output = new ArrayList<>();
      for(int i=0;i<numOfCombinations;i++){
         output.add(getSubset(nums, i));
      }
      return output;
   }

   private List<Integer> getSubset(int[] nums, int k) {
      List<Integer> output = new ArrayList<>();
      for(int i=0;i<nums.length;i++){
         if((k & (1 << i)) != 0){
            output.add(nums[i]);
         }
      }
      return output;
   }
}
