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
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash on 31-Aug-16.
 */

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class Problem3 {

   public static void main(String[] args) {
      Problem3 prob = new Problem3();
      System.out.println(prob.lengthOfLongestSubstring(null));
   }
   
   public int lengthOfLongestSubstring(String s) {
      if(s == null){
         return 0;
      }
      int max = 0;
      int i=0,j=0;
      Map<Character, Integer> map = new HashMap<>();
      while(j<s.length()){
         if(map.containsKey(s.charAt(j))){
            if(j-i > max){
               max = j -i;
            }
            int prevIndex = map.get(s.charAt(j));
            while(i <= prevIndex){
               map.remove(s.charAt(i));
               i++;
            }
         }
         map.put(s.charAt(j),j);
         j++;
      }
      
      if(j - i > max){
         max = j-i;
      }
      return max;
   }
}
