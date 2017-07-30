package com.aakash.practice.programcreek.dynamic_programming;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/21/17.
 */
public class DistinctSubsequence {

    int distinct(String s, String t){
        if(s == null || t == null || s.length() < t.length()){
            return 0;
        }
        if(s.equals(t) || t.length() == 0){
            return 1;
        }
        char ch1 = s.charAt(0);
        char ch2 = t.charAt(0);
        if(ch1 == ch2){
            return distinct(s.substring(1), t.substring(1)) + distinct(s.substring(1), t);
        } else {
            return distinct(s.substring(1), t);
        }

    }

    int distinctDP(String s, String t){
        int S = s.length();
        int T = t.length();

        int[][] dp = new int[S+1][T+1];

        for(int i=0;i<=S;i++){
            dp[i][T] = 1;
        }

        dp[S][T] = 1;
        for(int i=S-1;i>=0;i--){
            for(int j=T-1;j>=0;j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        DistinctSubsequence distinctSubsequence = new DistinctSubsequence();
        System.out.println(distinctSubsequence.distinctDP("AAAA", "AA"));
    }
}
