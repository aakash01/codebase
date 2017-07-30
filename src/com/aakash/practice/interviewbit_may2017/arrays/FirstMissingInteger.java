package com.aakash.practice.interviewbit_may2017.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/24/17.
 */
public class FirstMissingInteger {

    public int firstMissingPositive(ArrayList<Integer> a) {
        int n = a.size();
        for(int i=0;i<n;i++){
            if(a.get(i) < 0){
                a.set(i, 0);
            }
        }

        for(int i=0;i<n;i++){
            int num = Math.abs(a.get(i));
            if(num == 0 || num > a.size()){
                continue;
            }
            int k = a.get(num-1);
            if(k == 0){
                k = num;
            }
            a.set(num-1, -1 * k);
        }

        for(int i=0;i<n;i++){
            if(a.get(i) >= 0){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
        System.out.println(firstMissingInteger.firstMissingPositive(new ArrayList<>(Arrays.asList(new Integer[]{2, 1, 3}))));
    }
}
