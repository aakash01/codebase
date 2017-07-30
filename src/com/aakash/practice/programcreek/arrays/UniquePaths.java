package com.aakash.practice.programcreek.arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            dp[i][n-1] = 1;
        }

        for(int i=0;i<n;i++){
            dp[m-1][i] = 1;
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 3));
    }
}
