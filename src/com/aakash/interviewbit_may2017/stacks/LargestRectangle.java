package com.aakash.interviewbit_may2017.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class LargestRectangle {

    public int largestRectangleArea(ArrayList<Integer> a) {
        Stack<Integer> s = new Stack<>();
        int max = 0, count = 0;
        for(Integer i : a){
            count = 0;
            while(!s.isEmpty() && s.peek() > i){
                count++;
                int k = s.pop();
                if(k*count > max){
                    max =  k*count;
                }
            }
            while(count > 0){
                s.push(i);
                count--;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            count++;
            int k = s.pop();
            if(k*count > max){
                max =  k*count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangle largestRectangle = new LargestRectangle();
        System.out.println(largestRectangle.largestRectangleArea(new ArrayList<>(Arrays.asList(new Integer[]{2}))));
    }
}
