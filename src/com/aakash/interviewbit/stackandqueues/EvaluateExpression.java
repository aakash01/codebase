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

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class EvaluateExpression {

   public int evalRPN(ArrayList<String> a) {

      Stack<Integer> stack = new Stack<>();
      for(String s: a){
         if(isOperator(s)){
            int op2 = stack.pop();
            int op1 = stack.pop();
            int val = getValue(op1, op2, s);
            stack.push(val);
         } else {
            stack.push(Integer.parseInt(s));
         }
      }
      
      return stack.pop();
   }

   private boolean isOperator(String s) {
      return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
   }
   
   private int getValue(int op1, int op2, String operator){
      switch (operator){
      case "+":
         return op1 + op2;
      case "-":
         return op1 - op2;
      case "/":
         return op1 / op2;
      case "*":
         return op1 * op2;
      }
      return 0;
   }
}
