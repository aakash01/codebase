package com.aakash.practice.leetcode.may2017;

import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/9/17.
 */
public class Problem492 {

    public int[] constructRectangle(int area) {
        int[] output = new int[2];
        StringBuilder sb = new StringBuilder();
        int l = (int) Math.ceil(Math.sqrt(area));
        for(int i=l; i>=1;i--){
            if(area%i == 0 && area/i *i == area){
                if(i>area/i){
                    output[0] = i;
                    output[1] = area/i;
                } else {
                    output[0] = area/i;
                    output[1] = i;
                }
                break;

            }
        }
        return output;

    }

    public static void main(String[] args) {
        Problem492 problem492 = new Problem492();
        System.out.println(Arrays.toString(problem492.constructRectangle(21)));
    }
}
