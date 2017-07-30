package com.aakash.practice.interviewbit_may2017.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class EvaluateExpression {
    public int evalRPN(ArrayList<String> a) {
        Stack<Integer> stack = new Stack<>();
        int result;
        for(String s:a){
            if(isOperator(s)){
                int i2 = stack.pop();
                int i1 = stack.pop();
                result = performOperation(s, i1, i2);
                stack.push(result);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }

    private boolean isOperator(String s){
        switch (s){
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:return false;
        }
    }

    private int performOperation(String operator, int a, int b){
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        return -1;
    }

    public static void main(String[] args) {
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        System.out.println(evaluateExpression.evalRPN(new ArrayList<>(Arrays.asList(new String[]{"4", "13", "5", "/", "+"}))));
    }
}
