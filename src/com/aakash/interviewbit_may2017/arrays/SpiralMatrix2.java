package com.aakash.interviewbit_may2017.arrays;

import java.util.ArrayList;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/21/17.
 */
public class SpiralMatrix2 {

    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        int[][] a = new int[n][];
        for(int i=0;i<n;i++){
            a[i] = new int[n];
        }
        int x=0,y=0,k=1;
        while(n>0){
            if(n == 1){
                for(int i=1;i<=n;i++){
                    a[x][y++] = k++;
                }
                break;
            }
            for(int i=1;i<n;i++){
                a[x][y++] = k++;
            }
            for(int i=1;i<n;i++){
                a[x++][y] = k++;
            }for(int i=1;i<n;i++){
                a[x][y--] = k++;
            }for(int i=1;i<n;i++){
                a[x--][y] = k++;
            }
            n = n-2;
            x++;y++;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int[] arr : a){
            ArrayList<Integer> subResult = new ArrayList<>();
            for(int i : arr){
                subResult.add(i);
            }
            result.add(subResult);
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        System.out.println(spiralMatrix2.generateMatrix(0));
    }
}
