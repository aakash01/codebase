package com.aakash.practice.programcreek.arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class UniquePaths2 {

    public int uniquePaths(int[][] obstacleGrid) {
        int m  =obstacleGrid.length;
        if(m == 0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = obstacleGrid[m-1][n-1] == 1 ? 0 : 1;
        for(int i=m-2;i>=0;i--){
            dp[i][n-1] = obstacleGrid[i][n-1]  == 1 ? 0 : dp[i+1][n-1];
        }

        for(int i=n-2;i>=0;i--){
            dp[m-1][i] = obstacleGrid[m-1][i]  == 1 ? 0 : dp[m-1][i+1];
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        UniquePaths2 uniquePaths = new UniquePaths2();
        int[][] grid = new int[][]{{1,0}};
        System.out.println(uniquePaths.uniquePaths(grid));
    }
}
