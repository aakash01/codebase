package com.aakash.practice.interviewbit_may2017.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/21/17.
 */
public class RotateMatrix {

    public void rotate(ArrayList<ArrayList<Integer>> a) {

        int n = a.size();
        int x = 0, y=0;
        int k = n/2;
        for(int i=1;i<=k;i++){
            int r0 = x, c0= y, rn=n+x-1, cn = n+y-1;
            for(int p=0;p<n-1; p++){
                int t = a.get(r0).get(c0+p);
                a.get(r0).set(c0 + p,a.get(rn-p).get(c0));
                a.get(rn-p).set(c0, a.get(rn).get(cn-p));
                a.get(rn).set(cn-p, a.get(r0+p).get(cn));
                a.get(r0+p).set(cn, t);

            }
            x++;y++;
            n = n-2;
        }
    }

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        ArrayList<Integer> r1 = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        ArrayList<Integer> r2 = new ArrayList<>(Arrays.asList(new Integer[] {6, 7, 8, 9, 10}));
        ArrayList<Integer> r3 = new ArrayList<>(Arrays.asList(new Integer[] {11,12,13,14,15}));
        ArrayList<Integer> r4 = new ArrayList<>(Arrays.asList(new Integer[] {16,17,18,19,20}));
        ArrayList<Integer> r5 = new ArrayList<>(Arrays.asList(new Integer[] {21,22,23,24,25}));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(r1);
        a.add(r2);
        a.add(r3);
        a.add(r4);
        a.add(r5);
        rotateMatrix.rotate(a);
        System.out.println(a);
    }
}
