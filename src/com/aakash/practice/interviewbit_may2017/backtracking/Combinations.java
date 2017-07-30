package com.aakash.practice.interviewbit_may2017.backtracking;

import java.util.ArrayList;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/28/17.
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        return combine(n, k, 1);
    }

    private ArrayList<ArrayList<Integer>> combine(int n, int k, int s) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(k == 0 ||  k > (n-s+1) || s > n){
            return result;
        }

        ArrayList<ArrayList<Integer>> included = combine(n, k-1, s+1);
        if(included.size() == 0){
            included.add(new ArrayList<>());
        }
        for(ArrayList<Integer> a : included){
            a.add(0, s);
            result.add(a);
        }

        ArrayList<ArrayList<Integer>> excluded = combine(n, k, s+1);
        for(ArrayList<Integer> a : excluded){
            result.add(a);
        }
        return result;
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
