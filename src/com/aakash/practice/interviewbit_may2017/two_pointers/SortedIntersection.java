package com.aakash.practice.interviewbit_may2017.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/22/17.
 */
public class SortedIntersection {

    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while(i<a.size() && j<b.size()){
            int  p = a.get(i);
            int q = b.get(j);
            if(p == q){
                result.add(p);
                i++;
                j++;
            } else if(p > q){
                j++;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 3, 4, 5, 6}));
        List<Integer> b = new ArrayList<>(Arrays.asList(new Integer[]{9, 9, 10}));
        SortedIntersection sortedIntersection = new SortedIntersection();
        System.out.println(sortedIntersection.intersect(a, b));
    }
}
