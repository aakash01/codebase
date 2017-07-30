package com.aakash.practice.interviewbit_may2017.binary_search;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/17/17.
 */

/**
 * Binary Search Invariant.
 * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-search/
 *
 * Solve predicate using a binary search.
 *
 * Partition in such a way that the max sum is minimum.
 *
 */

@AwesomeQuestion
public class PaintersPartition {
    public int paint(int a, int b, ArrayList<Integer> c) {
        if(c.size() == 0){
            return 0;
        }
        int L = getMax(c);
        int R = getSum(c);
        while(L<R){
            int M = L + (R-L)/2;
            int k = getRequiredPainters(c, M);
            if(k<=b){
                R = M;
            } else {
                L = M+1;
            }
        }
        int result = 0;
        for(int i = 1;i<=a;i++){
            result = (result + L)%10000003;
        }
        return result;
    }

    private int getRequiredPainters(ArrayList<Integer> c, int M){
        int count = 0;
        int total = 0;
        for(int i=0;i<c.size();i++){
            total += c.get(i);
            if(total > M){
                count++;
                total = c.get(i);
            }
        }
        return count;
    }

    private int getMax(ArrayList<Integer> c){
        int max = Integer.MIN_VALUE;
        for(Integer i : c){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    private int getSum(ArrayList<Integer> c){
        int sum = 0;
        for(int i : c){
            sum += i;
        }
        return sum;
    }
}
