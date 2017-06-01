package com.aakash.interviewbit_may2017.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        Collections.sort(a);
        return helper(a);
    }

    private ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a.isEmpty()){
            return result;
        } else if(a.size() == 1){
            result.add((ArrayList<Integer>) a.clone());
            return result;
        }
        int len = a.size();
        for(int i=0;i<len;i++){
            int k = a.remove(i);
            ArrayList<ArrayList<Integer>> subLists = helper(a);
            for(ArrayList<Integer> subList : subLists){
                subList.add(0, k);
                result.add(subList);
            }
            a.add(i, k);
        }
        return result;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new ArrayList<>(Arrays.asList(new Integer[]{2}))));
    }
}
