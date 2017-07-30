package com.aakash.practice.programcreek;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/26/17.
 */
public class MaximumSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(i ==0 || j==0){
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    if(matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    }
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        /*for(int[] a:dp){
            System.out.println(Arrays.toString(a));
        }*/
        return max;
    }

    public static void main(String[] args) {

        MaximumSquare maximumSquare = new MaximumSquare();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximumSquare.maximalSquare(matrix));
    }
}
