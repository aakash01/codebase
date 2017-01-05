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

import java.util.Stack;

/**
 * Created by Aakash on 21-Aug-16.
 */
public class Bomber {
   public static void main(String[] args) {
      Bomber bb = new Bomber();
      System.out.println(bb.bomber("abcdeeeddcbfg"));
   }

   public String bomber(String str) {
      if(str.length() == 0){
         return str;
      }
      Stack<Character> stack = new Stack<>();
      stack.push(str.charAt(0));
      
      for(int i=1;i<str.length();i++){
         if(stack.isEmpty()){
            stack.push(str.charAt(i));
         } else {
            Character top = stack.peek();
            if (top.equals(str.charAt(i))) {
               while (i < str.length() && top.equals(str.charAt(i))) {
                  i++;
               }
               stack.pop();
               i--;
            } else {
               stack.push(str.charAt(i));
            }
         }
      }
      
      StringBuilder sb = new StringBuilder();
      while(!stack.isEmpty()){
         sb.append(stack.pop());
      }
      sb.reverse();
      return sb.toString();
   }
}
