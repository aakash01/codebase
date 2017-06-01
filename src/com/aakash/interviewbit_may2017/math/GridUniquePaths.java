package com.aakash.interviewbit_may2017.math;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class GridUniquePaths {
    public int uniquePaths(int a, int b) {
        if(a == 0 && b == 0){
            return 0;
        }
        int[][] grid = new int[a][b];
        for(int i=0;i<a;i++){
            grid[i][b-1] = 1;
        }
        for(int j=0;j<b;j++){
            grid[a-1][j] = 1;
        }
        for(int i=a-2;i>=0;i--){
            for(int j=b-2;j>=0;j--){
                grid[i][j] = grid[i+1][j] + grid[i][j+1];
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        System.out.println(gridUniquePaths.uniquePaths(3, 3));
    }
}
