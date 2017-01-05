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
package com.aakash.personal;

/**
 * Created by Aakash on 01-Sep-16.
 */

/**
 * Replace all occurrence of the given pattern to ‘X’.
 For example, given that the pattern=”abc”, replace “abcdeffdfegabcabc” with “XdeffdfegX”. 
 Note that multiple occurrences of abc’s that are contiguous will be replaced with only one ‘X’.
 */
public class StringReplacement {

   public static void main(String[] args) {
      System.out.println(replacedString("abcxyzabfgabcabc", "abc"));
   }
   private static String replacedString(String origStr, String pattern){
      char[] s = origStr.toCharArray();
      int sp = 0;
      for(int i=0;i<s.length;){
         int j=0, temp = i;
         while(j < pattern.length() && temp < s.length && pattern.charAt(j) == s[temp]){
            j++;
            temp++;
         }
         if(j == pattern.length()){
            if(sp == 0 || s[sp-1] != 'X'){
               s[sp] = 'X';
               sp++;
            }
            i = temp;
         } 
         else {
            s[sp] = s[i];
            i++;
            sp++;
         }
      }
      return String.copyValueOf(s, 0, sp);
   }
}
