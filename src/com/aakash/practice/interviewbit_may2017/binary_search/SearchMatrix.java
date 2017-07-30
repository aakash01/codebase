package com.aakash.practice.interviewbit_may2017.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class SearchMatrix {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int n = a.size();
        if(n == 0){
            return 0;
        }
        int m = a.get(0).size();
        int l=0, r = n-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(a.get(mid).get(m-1) == b){
                return 1;
            } else if(a.get(mid).get(m-1) < b){
                l = mid +1;
            } else {
                r = mid-1;
            }
        }

        if(l >= n){
            return 0;
        }
        int l1 = 0, r1 = m-1;
        while(l1 <= r1){
            int m1 = l1 +(r1-l1)/2;
            if(a.get(l).get(m1) == b){
                return 1;
            } else if(a.get(l).get(m1) <= b){
                l1 = m1 +1;
            } else {
                r1 = m1 -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> r1 = new ArrayList<>(Arrays.asList(new Integer[] {1, 3, 5, 7}));
        ArrayList<Integer> r2 = new ArrayList<>(Arrays.asList(new Integer[] {10, 11, 16, 20}));
        ArrayList<Integer> r3 = new ArrayList<>(Arrays.asList(new Integer[] {23, 30, 34, 50}));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(r1);
        a.add(r2);
        a.add(r3);
        System.out.println(new SearchMatrix().searchMatrix(a, 9));
    }
}
