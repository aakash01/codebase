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
public class ReverseString {

   public static void main(String[] args) {
      ReverseString reverseString = new ReverseString();
      System.out.println(reverseString.reverseString("d"));
   }
   
   public String reverseString(String a){

      Stack<Character> stack = new Stack<>();
      for(char ch : a.toCharArray()){
         stack.push(ch);
      }
      
      StringBuilder sb  = new StringBuilder();
      while(!stack.isEmpty()){
         sb.append(stack.pop());
      }
      return sb.toString();
   }
}
