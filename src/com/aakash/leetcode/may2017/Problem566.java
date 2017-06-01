package com.aakash.leetcode.may2017;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/4/17.
 */
public class Problem566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int or = nums.length;
        int oc = nums[0].length;

        if(or*oc == r*c){
            int[][] newMat = new int[r][c];
            int oi=0;
            int oj=0;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    newMat[i][j] = nums[oi][oj];
                    oj++;
                    if(oj == oc){
                        oj=0;
                        oi++;
                    }
                }
            }
            return newMat;
        } else{
            return nums;
        }
    }

    private static void printMatrix(int[][] mat){
        int r = mat.length;
        int c = mat[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Problem566 problem566 = new Problem566();
        int[][] nums = new int[][]{{1,2},{3, 4}};
        printMatrix(problem566.matrixReshape(nums, 1, 4));
    }
}
