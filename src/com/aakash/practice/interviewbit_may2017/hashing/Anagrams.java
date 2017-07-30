package com.aakash.practice.interviewbit_may2017.hashing;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */
public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int i=1;
        for(String s : a){
            char[] schar = s.toCharArray();
            Arrays.sort(schar);
            String sorted = new String(schar);
            ArrayList<Integer> l1;
            if(map.containsKey(sorted)){
                l1 = map.get(sorted);
            } else {
                l1 = new ArrayList<>();
            }
            l1.add(i);
            map.put(sorted, l1);
            i++;
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.anagrams(new ArrayList<String>(Arrays.asList(new String[]{"god", "cat", "dog", "god","tca","ogd"}))));
    }
}
