package com.aakash.practice.interviewbit_may2017.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/28/17.
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        a = new ArrayList<>(new HashSet<>(a));
        Collections.sort(a);
        return combine(a, b, 0);
    }

    private ArrayList<ArrayList<Integer>> combine(ArrayList<Integer> a, int k, int s) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(k <= 0 || s>=a.size() || k < a.get(0)){
            return result;
        }
        int i = a.get(s);
        if(k == i){
            ArrayList<Integer> temp  =new ArrayList<>();
            temp.add(i);
            result.add(temp);
            return result;
        }
        ArrayList<ArrayList<Integer>> included = combine(a, k-i, s);
        for(ArrayList<Integer> t : included){
            t.add(0, i);
            result.add(t);
        }

        ArrayList<ArrayList<Integer>> excluded = combine(a, k, s+1);
        for(ArrayList<Integer> t : excluded){
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new ArrayList<>(Arrays.asList(new Integer[]{8, 10, 6, 11, 1, 16, 8})), 28));
    }
}
