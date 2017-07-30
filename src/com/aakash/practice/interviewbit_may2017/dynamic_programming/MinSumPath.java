package com.aakash.practice.interviewbit_may2017.dynamic_programming;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/3/17.
 */
@AwesomeQuestion
public class MinSumPath {

    public int minPathSum(ArrayList<ArrayList<Integer>> a) {
        if(a.size() == 0){
            return 0;
        }
        int m = a.size();
        int n = a.get(0).size();
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = a.get(m-1).get(n-1);
        for(int i=m-2;i>=0;i--){
            dp[i][n-1] = a.get(i).get(n-1) + dp[i+1][n-1];
        }
        for(int j=n-2;j>=0;j--){
            dp[m-1][j] = a.get(m-1).get(j)  + dp[m-1][j+1];
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = a.get(i).get(j) + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 3, 2}));
        ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{4, 3, 1}));
        ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(new Integer[]{5, 6, 1}));
        a.add(l1);
        a.add(l2);
        a.add(l3);
        MinSumPath minSumPath = new MinSumPath();
        System.out.println(minSumPath.minPathSum(a));
    }
}
