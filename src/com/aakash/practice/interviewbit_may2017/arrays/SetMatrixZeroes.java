package com.aakash.practice.interviewbit_may2017.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/21/17.
 */
public class SetMatrixZeroes {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size(), n=0;
        if(a.size() > 0){
            n = a.get(0).size();
        }
        boolean isFR = false, isFC = false;
        for(int i=0;i<n;i++){
            if(a.get(0).get(i) == 0){
                isFR  =true;
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(a.get(i).get(0) == 0){
                isFC  =true;
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a.get(i).get(j) == 0){
                    a.get(0).set(j, 0);
                    a.get(i).set(0, 0);
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a.get(i).get(0) == 0 || a.get(0).get(j) == 0){
                    a.get(i).set(j, 0);
                }
            }
        }
        if(isFR){
            for(int i=0;i<n;i++){
                a.get(0).set(i, 0);
            }
        }
        if(isFC){
            for(int i=0;i<m;i++){
                a.get(i).set(0, 0);
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        ArrayList<Integer> r1 = new ArrayList<>(Arrays.asList(new Integer[] {0, 1, 1, 1, 1}));
        ArrayList<Integer> r2 = new ArrayList<>(Arrays.asList(new Integer[] {1, 1, 1, 1, 0}));
        ArrayList<Integer> r3 = new ArrayList<>(Arrays.asList(new Integer[] {1,1,1,1,1}));
        ArrayList<Integer> r4 = new ArrayList<>(Arrays.asList(new Integer[] {0,1,1,1,1}));
        ArrayList<Integer> r5 = new ArrayList<>(Arrays.asList(new Integer[] {1,0,1,1,1}));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        a.add(r1);
        a.add(r2);
        a.add(r3);
        a.add(r4);
        a.add(r5);
        setMatrixZeroes.setZeroes(a);
        System.out.println(a);
    }
}
