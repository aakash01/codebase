package com.aakash.practice.interviewbit_may2017.binary_search;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/20/17.
 */
@GoodQuestion
public class SortedInsertPosition {

    public int sortedInsert(ArrayList<Integer> a,int n){
        int lo = 0, hi = a.size()-1;
        while(lo < hi){
            int m = lo + (hi - lo)/2;
            if(a.get(m) == n){
                return m;
            } else if(a.get(m) > n){
                hi = m;
            } else {
                lo = m +1;
            }
        }
        if(a.get(lo) < n){
            lo++;
        }
        return lo;
    }

    public static void main(String[] args) {
        SortedInsertPosition sortedInsertPosition = new SortedInsertPosition();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{2, 4, 6, 8, 10}));
        System.out.println(sortedInsertPosition.sortedInsert(list, 8));
        System.out.println(sortedInsertPosition.sortedInsert(list, 12));
        System.out.println(sortedInsertPosition.sortedInsert(list, 10));
        System.out.println(sortedInsertPosition.sortedInsert(list, 1));
        System.out.println(sortedInsertPosition.sortedInsert(list, 5));
        System.out.println(sortedInsertPosition.sortedInsert(list, 9));
    }
}
