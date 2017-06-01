package com.aakash.interviewbit_may2017.bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class MinXORValue {

    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<A.size();i++){
            int currMin = A.get(i-1)^A.get(i);
            if(currMin < min){
                min = currMin;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinXORValue minXORValue = new MinXORValue();
        System.out.println(minXORValue.findMinXor(new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 4, 7, 9 }))));
    }
}
