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

import java.util.Stack;

/**
 * Created by Aakash on 02-Sep-16.
 */
public class Problem20 {

   private Character matchingChar;

   public static void main(String[] args) {
      Problem20 prob = new Problem20();
      System.out.println(prob.isValid("([)]"));
      for(String s : braces(new String[] {"{}[]()", "{[}]}","","]}","{[[","{[()]}"})){
         System.out.println(s);
      }
   }

   public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      int a = 0, b = 0, c = 0;
      for (char ch : s.toCharArray()) {
         if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
         } else {
            if (stack.isEmpty() || !getMatchingChar(ch).equals(stack.pop())) {
               return false;
            }
         }
      }
      return stack.isEmpty();
   }

   static String[] braces(String[] values) {
      String[] output = new String[values.length];
      int i=0;
      for(String str : values){
         Stack<Character> stack = new Stack<>();
         boolean found = false;
         for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
               stack.push(ch);
            } else {
               if (stack.isEmpty() || !getMatchingChar(ch).equals(stack.pop())) {
                  output[i] = "NO";
                  found = true;
                  break;
               }
            }
         }
         if(!found){
            if(stack.isEmpty()){
               output[i] = "YES";
            } else {
               output[i] = "NO";
            }
         }
         i++;
      }
      return output;
   }


   static Character getMatchingChar(char ch) {
      switch (ch){
      case '}': return '{';
      case ']' : return '[';
      case ')' : return '(';
      }
      return null;
   }
}
