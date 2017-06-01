package com.aakash.interviewbit_may2017.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);
        return helper(a);
    }

    private ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> a){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(a.isEmpty()){
            return result;
        }
        if(a.size() == 1){
            result.add(a);
            return result;
        }
        int k = a.remove(0);
        ArrayList<ArrayList<Integer>> subLists = subsets(a);
        for(ArrayList<Integer> subList : subLists){
            ArrayList<Integer> clone = (ArrayList<Integer>) subList.clone();
            clone.add(0, k);
            result.add(clone);

        }
        for(ArrayList<Integer> subList : subLists){
            if(subList.size() > 0) {
                result.add(subList);
            }

        }

        return result;
    }


    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new ArrayList<>(Arrays.asList(new Integer[]{}))));
    }
}
