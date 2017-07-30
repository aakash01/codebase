package com.aakash.practice.interviewbit_may2017.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class NearestSmallestElement {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(Integer i : arr){
            while(!stack.isEmpty() && stack.peek() >= i){
                stack.pop();
            }
            if(stack.isEmpty()){
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        NearestSmallestElement nearestSmallestElement = new NearestSmallestElement();
        System.out.println(nearestSmallestElement.prevSmaller(new ArrayList<>(Arrays.asList(new Integer[]{3, 1, 4, 2}))));
    }
}
