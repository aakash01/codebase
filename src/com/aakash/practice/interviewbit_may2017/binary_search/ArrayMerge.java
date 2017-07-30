package com.aakash.practice.interviewbit_may2017.binary_search;

import com.aakash.practice.common.AwesomeQuestion;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */

/**
 *
 * 1. Find kth smallest element in merge of two arrays.
 * 2. Find median in merge of two array. k = m+n/2
 */
@AwesomeQuestion
public class ArrayMerge {


    private static int findKth(int[] a, int[] b, int s1, int s2, int k){
        if(s1 >= a.length){
            return b[s2+k-1];
        } else if(s2 >= b.length){
            return a[s1+k-1];
        }
        if(k == 1){
            return Math.min(a[s1], b[s2]);
        }
        int m1 = s1 + k/2 - 1;
        int m2 = s2 + k/2 - 1;

        int v1 = m1 < a.length ? a[m1] : Integer.MAX_VALUE;
        int v2 = m2 < b.length ? b[m2] : Integer.MAX_VALUE;

        if(v1 > v2){
            return findKth(a, b, s1, m2+1, k- k/2);
        } else {
            return findKth(a, b, m1+1, s2, k - k/2);
        }
    }

    public static int findKth(int[] a, int[] b, int k){
        return findKth(a, b, 0, 0, k);
    }

    public static double findMedian(int[] a, int[] b){
        int t=  a.length + b.length;
        if(t%2 == 0){
            return (findKth(a, b, t/2) + findKth(a, b, t/2+1))/2.0;
        } else {
            return findKth(a, b, t/2+1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-50, -41, -40, -19, 5, 21, 28 };
        int[] b=  new int[]{-50, -21, -10};
        System.out.println(findKth(a, b, 2));
        System.out.println(findMedian(a, b));
    }

}
