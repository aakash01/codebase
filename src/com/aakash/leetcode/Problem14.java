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

/**
 * Created by Aakash on 02-Sep-16.
 */
public class Problem14 {

   public static void main(String[] args) {
      Problem14 prob = new Problem14();
      System.out.println(prob.longestCommonPrefix(new String[]{"abcdefg","abcd",null,"abcde"}));
   }

   public String longestCommonPrefix(String[] strs) {
      StringBuilder prefix = new StringBuilder();
      if(strs == null || strs.length == 0){
         return "";
      } 
      String s = strs[0];
      if(s != null) {
         for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            for (int i = 1; i < strs.length; i++) {
               if (strs[i] == null || strs[i].length() <= j || strs[i].charAt(j) != ch) {
                  return prefix.toString();
               }
            }
            prefix.append(ch);
         }
      }
      return prefix.toString();
   }
}
