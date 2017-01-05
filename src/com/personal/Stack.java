package com.personal;/*
 * This computer program is the confidential information and proprietary trade
 * secret of Anuta Networks, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and
 * Anuta Networks, Inc., and receipt or possession does not convey any rights
 * to divulge, reproduce, or allow others to use this program without specific
 * written authorization of Anuta Networks, Inc.
 * 
 * Copyright (c) 2011-2012 Anuta Networks, Inc. All Rights Reserved.
 */

import java.util.Arrays;

/**
 * Created by Aakash on 23-Jul-16.
 */
public class Stack<E> {
   E[] arr;
   int top = -1;

   public Stack(int len) {
      arr = (E[]) new Object[len];
   }
   
   void push(E elem) {
      if(top == arr.length - 1){
         throw new RuntimeException("Stack size exceeded");
      }
      
      arr[++top] = elem;
   }
   
   E pop(){
      if(top == -1){
         throw new RuntimeException("Stack is empty");
      }
      return arr[top--];
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("Stack{");
      sb.append("arr=").append(Arrays.toString(arr));
      sb.append(", top=").append(top);
      sb.append('}');
      return sb.toString();
   }

   public static void main(String[] args) {

      Stack<String> stack = new Stack<String>(11);
      stack.push("hello");
      stack.push("world");

      System.out.println(stack);
      stack.pop();
      System.out.println(stack);

      stack.pop();
      System.out.println(stack);
   }
   
}
