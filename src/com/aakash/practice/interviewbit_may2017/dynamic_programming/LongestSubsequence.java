package com.aakash.practice.interviewbit_may2017.dynamic_programming;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/29/17.
 */
@AwesomeQuestion
public class LongestSubsequence {

    /**
     * Logic : Create two arrays incSeq and decSeq.
     * incSeq[i] will store the longest increasing seq till i
     * decSeq[i] will store the longest decreasing deq from i
     * @param A
     * @return
     */
    public int longestSubsequenceLength(final List<Integer> A) {

        int l = A.size();
        int[] incSeq = new int[l];
        int[] decSeq = new int[l];

        incSeq[0] = 1;
        for(int i=1;i<l;i++){
            int j = i-1;
            int currMax = 0;
            while(j>=0){
                if(A.get(j) < A.get(i) && incSeq[j] > currMax){
                    currMax = incSeq[j];
                }
                j--;
            }
            incSeq[i] = currMax + 1;
        }
        decSeq[l-1] = 1;
        for(int i=l-2;i>=0;i--){
            int j = i+1;
            int currMax = 0;
            while(j<l){
                if(A.get(j) < A.get(i) && decSeq[j] > currMax){
                    currMax = decSeq[j];
                }
                j++;
            }
            decSeq[i] = currMax + 1;
        }

        int max = 0;
        for(int i=0;i<l;i++){
            int curr =incSeq[i] + decSeq[i] - 1;
            if( curr > max){
                max = curr;
            }
        }
        return max;
    }


    public int longestSubsequenceLengthRec(final List<Integer> A){
        if(A.size() == 0){
            return 0;
        }

        //included
        int incS = 1 + lSLRecHelper(A, 1, true, A.get(0));
        int decS = 1 + lSLRecHelper(A, 1, false, A.get(0));
        //not included

        int nIncS = lSLRecHelper(A, 1, true, Integer.MIN_VALUE);
        int nDncS = lSLRecHelper(A, 1, false, Integer.MAX_VALUE);
        return Math.max(incS, Math.max(decS, Math.max(nIncS, nDncS)));
    }

    public int lSLRecHelper(final List<Integer> A, int s, boolean inc, int prev){
        if(s == A.size()-1){
            if(inc){
                if(A.get(s) > prev){
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if(A.get(s) < prev){
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        //included
        int incS = 1+ lSLRecHelper(A, s+1, inc, A.get(s));
        int decS = 1 + lSLRecHelper(A, s+1, !inc, A.get(s));
        //not included

        int nIncS = lSLRecHelper(A, s+1, inc, prev);
        int nDncS = lSLRecHelper(A, s+1, !inc, prev);
        return Math.max(incS, Math.max(decS, Math.max(nIncS, nDncS)));
    }

    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        List<Integer> A = new ArrayList<>(Arrays.asList(new Integer[]{1, 11, 2, 10, 4, 5, 2, 1}));
        System.out.println(longestSubsequence.longestSubsequenceLengthRec(A));
    }
}
