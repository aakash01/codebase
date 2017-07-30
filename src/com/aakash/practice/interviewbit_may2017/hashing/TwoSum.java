package com.aakash.practice.interviewbit_may2017.hashing;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */
public class TwoSum {

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        Map<Integer, Integer> map =new HashMap<>();
        for(int i=0;i<a.size();i++){
            int req = b - a.get(i);
            if(map.containsKey(req)){
                return new ArrayList<>(Arrays.asList(new Integer[]{map.get(req)+1, i+1}));
            } else if(!map.containsKey(a.get(i))){
                map.put(a.get(i), i);
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(new ArrayList<>(Arrays.asList(new Integer[]{5, 5, 3, 3, 15})), 118));
    }
}
