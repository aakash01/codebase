package com.aakash.practice.interviewbit_may2017.dynamic_programming;

import com.aakash.practice.common.GoodQuestion;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/3/17.
 */
@GoodQuestion
public class DistinctSubsequence {

    public int distinctSubsequence1(String s, String t){
        if(s == null || t==null){
            return 0;
        }
        if(s.equals(t)){
            return 1;
        }
        char ch1 = s.charAt(0);
        char ch2 = t.charAt(0);
        if(ch1 == ch2){
            if(s.length() == 1){
                return 1;
            }
            return distinctSubsequence1(s.substring(1), t.substring(1)) + distinctSubsequence1(s.substring(1), t);
        } else {
            if(s.length() == 1){
                return 0;
            }
            return distinctSubsequence1(s.substring(1), t);
        }
    }

    public int distinctSubsequence2(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length();i++){
            dp[i][0] = 1; // empty t means delete all s == 1
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequence distinctSubsequence = new DistinctSubsequence();
        System.out.println(distinctSubsequence.distinctSubsequence1("AABB", "AB"));
    }
}
