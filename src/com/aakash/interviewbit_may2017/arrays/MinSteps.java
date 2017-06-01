package com.aakash.interviewbit_may2017.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/18/17.
 */

// Min Steps in infinite grid
public class MinSteps {

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if(X == null || X.size() == 0){
            return 0;
        }
        int n = X.size();
        int step = 0;
        int i = X.get(0), j = Y.get(0);
        for(int k=1;k<n;k++){
            int i1 = X.get(k), j1 = Y.get(k);
            int diffI = Math.abs(i1-i);
            int diffJ = Math.abs(j1-j);
            if(diffI < diffJ){
                step += diffI;
                step += Math.abs(diffJ-diffI);
            } else {
                step += diffJ;
                step += Math.abs(diffJ-diffI);
            }
            i = i1;
            j = j1;
        }
        return step;
    }

    public static void main(String[] args) {
        MinSteps minSteps = new MinSteps();
        System.out.println(minSteps.coverPoints(new ArrayList<>(Arrays.asList(-7, -13)), new ArrayList<>(Arrays.asList(1,-5))));
    }

}
