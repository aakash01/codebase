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
package com.aakash.interviewbit.stackandqueues;

import java.util.Stack;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class ValidateParenthesis {

   public int isValid(String a) {
      Stack<Character> stack = new Stack<>();
      for(char ch : a.toCharArray()){
         if(isOpeningBracket(ch)){
            stack.push(ch);
         } else {
            if(stack.isEmpty()){
               return 0;
            }
            char c  = stack.pop();
            if(c != getMatchingOpeningBrace(ch)){
               return 0;
            }
         }
      }
      return stack.isEmpty() ? 1 : 0;
   }
   
   private boolean isOpeningBracket(char ch){
      return ch == '{' || ch == '(' || ch == '[';
   }

   private char getMatchingOpeningBrace(char ch){
      if(ch == '}'){
         return '{';
      } else if(ch == ')'){
         return '(';
      } 
      return '[';
   }
   
   
}
