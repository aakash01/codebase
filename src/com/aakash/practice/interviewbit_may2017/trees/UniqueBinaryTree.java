package com.aakash.practice.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/6/17.
 */
public class UniqueBinaryTree {

    public int numBinaryTree(int n, int[] dp){
        if(n <= 0){
            return 0;
        }
        if(dp[n] > 0){
            return dp[n];
        }
        int count = 0;
        for(int i=1;i<=n;i++){
            int curr_count = 1;
            int count_left = numBinaryTree(i-1, dp);
            if(count_left > 0){
                curr_count *= count_left;
            }
            int count_right = numBinaryTree(n-i, dp);
            if(count_right > 0){
                curr_count *= count_right;
            }
            count += curr_count;
        }
        dp[n] = count;
        return count;
    }

    public int numTrees(int n) {
        int[] dp  =new int[n+1];
        if(n == 0){
            return 0;
        }
        dp[0] = 1; dp[1] = 1;
        for(int i=2;i<=n;i++){
            int count = 0;
            for(int j=1;j<=i;j++){
                count += dp[j-1] * dp[i-j];
            }
            dp[i] = count;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinaryTree uniqueBinaryTree = new UniqueBinaryTree();
        int n = 3;
        int[] dp = new int[n+1];
        dp[1] = 1;
        System.out.println(uniqueBinaryTree.numBinaryTree(n, dp));
    }
}
