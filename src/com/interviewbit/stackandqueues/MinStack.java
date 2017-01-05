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
package com.interviewbit.stackandqueues;

import java.util.Stack;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class MinStack {
   
   Stack<Integer> stack = new Stack<>();
   Stack<Integer> minStack = new Stack<>();
   

   public void push(int x) {
      if(minStack.isEmpty() || minStack.peek() >= x){
         minStack.push(x);
      }
      stack.push(x);
   }

   public void pop() {
      if(!stack.isEmpty()){
         int x = stack.pop();
         if(minStack.peek() == x){
            minStack.pop();
         }
      }
   }

   public int top() {
      if(!stack.isEmpty()){
         return stack.peek();
      }
      return -1;
   }

   public int getMin() {
      if(!minStack.isEmpty()){
         return minStack.peek();
      }
      return -1;
   }
   
}
