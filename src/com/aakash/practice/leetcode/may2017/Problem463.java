package com.aakash.practice.leetcode.may2017;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/9/17.
 */
public class Problem463 {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int p = 0;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1){
                    int p1 = 0;
                    if(i == 0 || grid[i-1][j] == 0){
                        p1++;
                    }
                    if(j == 0 || grid[i][j-1] == 0){
                        p1++;
                    }
                    if(i == m-1 || grid[i+1][j] == 0){
                        p1++;
                    }
                    if(j == n-1 || grid[i][j+1] == 0){
                        p1++;
                    }
                    p += p1;
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Problem463 problem463 = new Problem463();
        int[][] grid = new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0},
                {1,1,0,0}
        };
        System.out.println(problem463.islandPerimeter(grid));
    }
}
