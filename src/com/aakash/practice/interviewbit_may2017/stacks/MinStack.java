package com.aakash.practice.interviewbit_may2017.stacks;

import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            int i =stack.pop();
            if(minStack.peek() == i){
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

    void print(){
        System.out.println(stack.toString());
        System.out.println(minStack.toString());
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(1);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.print();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
