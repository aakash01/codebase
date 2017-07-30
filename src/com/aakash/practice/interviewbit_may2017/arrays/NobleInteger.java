package com.aakash.practice.interviewbit_may2017.arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/18/17.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Problem Link : https://www.interviewbit.com/problems/noble-integer/
 */
public class NobleInteger {

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        System.out.println(A);
        int len = A.size();
        for(int i=0; i<len; i++){
            while(i < len -1 && A.get(i).equals(A.get(i+1))){
                i++;
            }
            if(A.get(i) == len - i -1){
                return A.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NobleInteger nobleInteger = new NobleInteger();
        System.out.println(nobleInteger.solve(new ArrayList<>(Arrays.asList(6, -6, -7, 0, -7, 0, 9, 2, -5, -6, 0, -5, 9, 4, -4, -1, -8, -8, -6, 7, -3, 5, -6, -2, 1, -8, -2, 9, -7, -4, -2, -10, -8, 1, 0, -5, -9, -9, 0, 8, -5, -10, 6, -6, -4, -8, -5, -2, 6, -8, 8, -6, 7, -8, -6, -10, 6, 2, 9, 9, 0, -2, 1, 3, 1, -9, 0, 3, 4, -10, -7, 9, -9, 9, 6, 9, 3, 3, -2, 0, 5, -4, -4, -6, -10, 0, -6, 6, -8, 6, -3, -5, 6, 9, 8, -3, 2, -2, 2, 9, -1, 6, 0, -8, -3, -4, -9, 3, 2, -9, 5, 9, 9, -9, -6, 9, 1, -10))));
    }
}
