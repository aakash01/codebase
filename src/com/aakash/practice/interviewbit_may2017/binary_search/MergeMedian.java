package com.aakash.practice.interviewbit_may2017.binary_search;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/20/17.
 */
@AwesomeQuestion
public class MergeMedian {

        public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
            int s1 = a.size();
            int s2 = b.size();
            int k = (s1 + s2 + 1)/2;
            boolean isEven = (s1 + s2) % 2 == 0;
            int  l1 = 0, l2 = 0, h1 = s1-1, h2 = s2-1;
            while(l1 <= h1 && l2 <= h2){
                if(k == 1 || k ==0 ){
                    if(isEven){
                        if(a.get(l1) < b.get(l2)){
                            if(l1 == h1 || a.get(l1+1) > b.get(l2)){
                                return (a.get(l1) + b.get(l2))/(double)2;
                            } else {
                                return (a.get(l1) + a.get(l1+1))/(double) 2;
                            }
                        } else {
                            if(l2 == h2 || b.get(l2+1) > a.get(l1)){
                                return (a.get(l1) + b.get(l2))/(double)2;
                            } else {
                                return (b.get(l2) + b.get(l2+1))/(double) 2;
                            }
                        }
                    } else {
                        return Math.min(a.get(l1), b.get(l2));
                    }
                } else {
                    int m1 = l1 + k/2;
                    int m2 = l2 + k/2;
                     int mid1 = m1 < a.size() ? a.get(m1) : Integer.MAX_VALUE;
                     int mid2= m2 < b.size() ? b.get(m2) : Integer.MAX_VALUE;
                    if(mid1 > mid2){
                        k = k - k/2;
                        l2 = m2 + 1;
                    } else {
                        k = k - k/2;
                        l1 = m1 + 1;
                    }
                }
            }
            if(l1 <= h1){
                if(isEven){
                    return (a.get(l1+k) + a.get(l1+k-1)) / (double)2;
                } else {
                    return a.get(l1+k-1);
                }
            }
            if(l2 <= h2){
                if(isEven){
                    return (b.get(l2+k) + b.get(l2+k-1)) / (double)2;
                } else {
                    return b.get(l2+k-1);
                }
            }
            return -1;
        }



    public static void main(String[] args) {
        MergeMedian mergeMedian = new MergeMedian();
        List<Integer> a= new ArrayList<>(Arrays.asList(new Integer[]{-37, 4, 7, 13, 29, 49, 50}));
        List<Integer> b= new ArrayList<>(Arrays.asList(new Integer[]{-50, -12}));
        System.out.println(mergeMedian.findMedianSortedArrays(a, b));
    }
}
