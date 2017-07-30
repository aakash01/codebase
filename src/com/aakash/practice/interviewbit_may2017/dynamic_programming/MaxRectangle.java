package com.aakash.practice.interviewbit_may2017.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/3/17.
 */
public class MaxRectangle {

    public int maximalRectangle2(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] right = new int[m][n];
        int[][] bottom = new int[m][n];
        right[m-1][n-1] = a.get(m-1).get(n-1);
        bottom[m-1][n-1] = a.get(m-1).get(n-1);
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1){
                    bottom[i][j] = a.get(i).get(j);
                } else {
                    bottom[i][j] = a.get(i).get(j) == 0 ? 0 : a.get(i).get(j) + bottom[i+1][j];
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(j == n-1){
                    right[i][j] = a.get(i).get(j);
                } else {
                    right[i][j] = a.get(i).get(j) == 0 ? 0 : a.get(i).get(j) + right[i][j+1];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int maxDown = bottom[i][j];
                int min = Integer.MAX_VALUE;
                for(int k=1;k<=maxDown;k++){
                    int currMin = right[i+k-1][j];
                    if(currMin < min){
                        min = currMin;
                    }
                }
                if(min*maxDown > max){
                    max = min*maxDown;
                }
            }
        }

        return max;

    }

    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (i == 0) {
                    dp[i][j] = a.get(i).get(j);
                } else {
                    dp[i][j] = a.get(i).get(j) == 0 ? 0 : a.get(i).get(j) + dp[i-1][j];
                }
            }
        }
        int max = -1;
        for(int i=0;i<m;i++){
            int currMax = getMaxRectangleInHist(dp[i]);
            if(currMax > max){
                max = currMax;
            }
        }
        return max;
    }

    private int getMaxRectangleInHist(int[] a){
        int max = -1;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<a.length;i++){
            int count = 1;
            while(!s.isEmpty() && s.peek() > a[i]){
                int t = s.pop();
                if(t*count > max){
                    max = t*count;
                }
                count++;
            }
            for(int j=1;j<=count;j++){
                s.push(a[i]);
            }
        }
        int count = 1;
        while(!s.isEmpty()){
            int t = s.pop();
            if(t*count > max){
                max = t*count;
            }
            count++;
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}));
        ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        ArrayList<Integer> l4 = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}));
        ArrayList<Integer> l5 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1}));
        ArrayList<Integer> l6 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        ArrayList<Integer> l7 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1}));
        ArrayList<Integer> l8 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0}));
        ArrayList<Integer> l9 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1}));
        ArrayList<Integer> l10 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1}));
        ArrayList<Integer> l11 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        ArrayList<Integer> l12 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        ArrayList<Integer> l13 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1}));
        ArrayList<Integer> l14 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}));
        ArrayList<Integer> l15 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}));
        a.add(l1);
        a.add(l2);
        a.add(l3);
        a.add(l4);
        a.add(l5);
        a.add(l6);
        a.add(l7);
        a.add(l8);
        a.add(l9);
        a.add(l10);
        a.add(l11);
        a.add(l12);
        a.add(l13);
        a.add(l14);
        a.add(l15);
        MaxRectangle maxRectangle = new MaxRectangle();
        System.out.println(maxRectangle.maximalRectangle2(a));
    }
}
