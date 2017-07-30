package com.aakash.practice.interviewbit_may2017.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/29/17.
 */
public class HighestProduct {

    public int maxp3(ArrayList<Integer> a) {
        Collections.sort(a);
        int n = a.size();
        int mxProduct = a.get(n-1) * a.get(n-2) * a.get(n-3);
        int mxProduct2 = a.get(n-1) * a.get(0) * a.get(1);
        return mxProduct > mxProduct2 ? mxProduct : mxProduct2;
    }

    public static void main(String[] args) {
        HighestProduct highestProduct = new HighestProduct();
        System.out.println(highestProduct.maxp3(new ArrayList<>(Arrays.asList(new Integer[]{-200, -100, 23, 0, 40, 50, 100}))));
    }
}
