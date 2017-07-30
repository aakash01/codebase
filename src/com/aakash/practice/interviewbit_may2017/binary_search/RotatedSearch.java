package com.aakash.practice.interviewbit_may2017.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/20/17.
 */
public class RotatedSearch {

    public int search(final List<Integer> a, int b) {
        int lo = 0, hi = a.size() - 1;
        while(lo <= hi){
            int m = lo + (hi - lo)/2;
            if(a.get(m) == b){
                return m;
            } else if(a.get(m) > a.get(lo)){
                if(b >= a.get(lo) && b < a.get(m)){
                    hi = m-1;
                } else {
                    lo = m +1;
                }
            } else {
                if(b <= a.get(hi) && b > a.get(m)){
                    lo = m+1;
                } else {
                    hi = m -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSearch rotatedSearch = new RotatedSearch();
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{6, 7, 8, 1, 2, 3, 4, 5}));
        System.out.println(rotatedSearch.search(list, 10));
    }
}
