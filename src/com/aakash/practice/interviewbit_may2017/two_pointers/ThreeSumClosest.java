package com.aakash.practice.interviewbit_may2017.two_pointers;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/22/17.
 */
@GoodQuestion
public class ThreeSumClosest {

    public int threeSumClosest(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        System.out.println(a);
        // long because -ve can add
        long closestSum = Integer.MAX_VALUE;
        for(int i=0;i<a.size()-2;i++){
            int j = i+1, k = a.size()-1;
            int reqSum = b - a.get(i);
            while(j<k){
                int currSum = a.get(j) + a.get(k);
                if(currSum == reqSum){
                    return b;
                } else if(currSum > reqSum){
                    k--;
                }else {
                    j++;
                }
                if(Math.abs(currSum - reqSum) < Math.abs(closestSum-b)){
                    closestSum = currSum + a.get(i);
                }
            }
        }
        return (int)closestSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{2, 1, -9, -7, -8, 2, -8, 2, 3, -8}));
        System.out.println(new ThreeSumClosest().threeSumClosest(list, -1));
    }
}
