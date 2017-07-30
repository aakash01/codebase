package com.aakash.practice.interviewbit_may2017.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/2/17.
 */
public class ShortestCommonSuperString {
    /**
     * Solve using Greedy. Forf all string find the max common prefix/suffix. Merge those two strings
     * and continue it.
     */

    public int solve(ArrayList<String> A) {
        int l = A.size();
        while(l>1){
            int currMax = Integer.MIN_VALUE;
            String finalStr = null;
            int p = -1, q= -1;
            for(int j=0;j<l;j++){
                for(int k=j+1;k<l;k++){
                    String a = A.get(j);
                    String b = A.get(k);
                    if(a.contains(b)){
                        if(b.length() > currMax){
                            finalStr = a;
                            currMax = b.length();
                            p = j;
                            q = k;
                        }
                    } else if(b.contains(a)){
                        if(a.length() > currMax){
                            finalStr = b;
                            currMax = a.length();
                            p = j;
                            q = k;
                        }
                    } else {
                        // find max common prefix and suffix
                        int maxPrefixMatch = getMaxPrefixLength(a, b);
                        if (maxPrefixMatch > currMax) {
                            finalStr = a + b.substring(maxPrefixMatch);
                            currMax = maxPrefixMatch;
                            p = j;
                            q = k;
                        }
                        int maxSuffixMatch = getMaxPrefixLength(b, a);
                        if (maxSuffixMatch > currMax) {
                            finalStr = b + a.substring(maxSuffixMatch);
                            currMax = maxSuffixMatch;
                            p = j;
                            q = k;
                        }
                    }
                }
            }
            l--;
            A.set(p, finalStr);
            A.set(q, A.get(l));
        }
        System.out.println(A.get(0));
        return A.get(0).length();
    }

    private int getMaxPrefixLength(String a, String b){
        int max = 0;
        for(int i=0;i<b.length();i++){
            String prefix = b.substring(0, i+1);
            if(a.endsWith(prefix)){
                max = i+1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /** Giving Wrong Ans: Required 38 Giving 39
         * Should we consider all permutations?
         **/

        ArrayList<String> list = new ArrayList<>(Arrays.asList(new String[]{"fevlutui", "ilxfntf", "whiade", "idehwakceipb", "lkgvxeb"}));
        ShortestCommonSuperString shortestCommonSuperString = new ShortestCommonSuperString();
        System.out.println(shortestCommonSuperString.solve(list));
    }
}
