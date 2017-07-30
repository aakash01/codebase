package com.aakash.practice.interviewbit_may2017.binary_search;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/20/17.
 */
@GoodQuestion
public class SearchRange {

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int lo = 0, hi = a.size()-1;
        while(lo < hi){
            int m = lo + (hi - lo)/2;
            if(a.get(m) >= b){
                hi = m;
            } else {
                lo = m + 1;
            }
        }
        if(a.get(lo) != b){
            lo = -1;
        }
        result.add(lo);
        lo = 0;
        hi = a.size() - 1;

        while(lo < hi){
            int m = lo + (hi - lo + 1)/2;
            if(a.get(m) <= b){
                lo = m;
            } else {
                hi = m - 1;
            }
        }
        if(a.get(lo) != b){
            lo = -1;
        }
        result.add(lo);

        return result;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{8,8,8, 8, 8, 18}));
        System.out.println(searchRange.searchRange(list, 18));
    }
}
