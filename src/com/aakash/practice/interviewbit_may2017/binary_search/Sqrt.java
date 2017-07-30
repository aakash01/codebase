package com.aakash.practice.interviewbit_may2017.binary_search;

import com.aakash.practice.common.GoodQuestion;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/20/17.
 */
@GoodQuestion
public class Sqrt {

    public int squareRoot(int n){
        int lo = 0, hi = n;
        while(lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (m > 0 && m >= n / m) {
                hi = m;
            } else {
                lo = m + 1;
            }
        }
        if((double)lo * lo  > n){
            lo--;
        }
        return lo;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.squareRoot(1));
    }
}
