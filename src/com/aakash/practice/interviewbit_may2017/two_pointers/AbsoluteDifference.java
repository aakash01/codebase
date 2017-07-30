package com.aakash.practice.interviewbit_may2017.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */
public class AbsoluteDifference {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i=0, j=0, k=0, minDiff=Integer.MAX_VALUE;
        while(i<A.size() && j < B.size() && k<C.size()){
            int p = A.get(i), q = B.get(j), r = C.get(k);
            int currMin = Math.abs(Math.max(p, Math.max(q, r)) - Math.min(p, Math.min(q, r)));
            if(currMin < minDiff){
                minDiff = currMin;
            }
            if(p < q){
                if (p<r){
                    i++;
                } else {
                    k++;
                }
            } else {
                if(q < r){
                    j++;
                } else {
                    k++;
                }
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(new Integer[]{1, 4, 5, 8, 10}));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(new Integer[]{6, 9, 15}));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(new Integer[]{2, 3, 6, 6}));

        AbsoluteDifference abs = new AbsoluteDifference();
        System.out.println(abs.solve(A, B, C));
    }
}
