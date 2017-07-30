package com.aakash.practice.interviewbit_may2017.dynamic_programming;

import com.aakash.practice.common.AwesomeQuestion;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/2/17.
 */
@AwesomeQuestion
public class EditDistance {

    public int minDistance(String a, String b) {
        if(a != null && a.equals(b)){
            return 0;
        }
        int[][] dp = new int[a.length()][b.length()];
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                dp[i][j] = -1;
            }
        }
        helper(a, b, 0, 0, dp);
        return dp[0][0];
    }

    private int helper(String a, String b, int i, int j, int[][] dp){
        if(a.length() == i){
            return b.length()-j;
        } else if(b.length() == j){
            return a.length()-i;
        } else if(a.substring(i).equals(b.substring(j))){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        char ch1 = a.charAt(i);
        char ch2 = b.charAt(j);
        if(ch1 == ch2){
            dp[i][j] = helper(a, b, i+1, j+1, dp);
        } else {
            int p = 1 + helper(a, b, i, j+1, dp); // insert
            int q = 1 + helper(a, b, i+1, j, dp); // delete
            int r = 1 + helper(a, b, i+1, j+1, dp); //replace
            dp[i][j] = Math.min(p, Math.min(q, r));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("ORANGE", "MANGO"));
    }
}
