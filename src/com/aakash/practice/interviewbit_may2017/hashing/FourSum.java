package com.aakash.practice.interviewbit_may2017.hashing;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/28/17.
 */
public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        Collections.sort(a);
        for(int i=0;i<a.size();i++){
            for(int j=i+1;j<a.size();j++){
                int reqSum = b - a.get(i) - a.get(j);
                int p = j+1, q = a.size()-1;
                while (p < q){
                    int s = a.get(p) + a.get(q);
                    if(s == reqSum){
                        if(!map.containsKey(getKey(a, i, j, p, q))) {
                            result.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{a.get(i), a.get(j), a.get(p), a.get(q)})));
                        }
                        map.put(getKey(a, i, j, p, q), true);
                        p++;q--;
                    } else if(s > reqSum){
                        q--;
                    }else {
                        p++;
                    }
                }
            }
        }
        return result;
    }

    private String getKey(ArrayList<Integer> a, int i, int j, int p, int q){
        return a.get(i)+"#"+a.get(j)+"#"+a.get(p)+"#"+a.get(q);
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new ArrayList<>(Arrays.asList(new Integer[]{1, 0, -1, 0, -2, 2})), 0));
    }
}
