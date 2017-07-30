package com.aakash.practice.interviewbit_may2017.two_pointers;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/25/17.
 */
@GoodQuestion
public class MaxContinuousOne {

    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {

        int i=0, maxStart = -1, maxCount = -1, currStart = 0, currCount = 0;
        int avZ = b;
        while(i<a.size()){
            if(a.get(i) == 0){
                if(avZ == 0){
                    if(currCount > maxCount){
                        maxStart = currStart;
                        maxCount = currCount;
                    }
                    while(currStart < i && a.get(currStart) != 0){
                        currStart++;
                        currCount--;
                    }
                    currStart++;
                    currCount--;
                    if(currCount < 0){
                        currCount = 0;
                    }
                    if(b != 0){
                        currCount++;
                    }
                } else {
                    currCount++;
                    avZ--;
                }
            } else {
                currCount++;
            }
            i++;
        }
        if(currCount > maxCount){
            maxStart = currStart;
            maxCount = currCount;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while(maxCount != 0){
            result.add(maxStart);
            maxStart++;
            maxCount--;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(new Integer[]{0,0,1,0,1,1,1,0,1,1}));
        MaxContinuousOne maxContinuousOne = new MaxContinuousOne();
        System.out.println(maxContinuousOne.maxone(a, 1));
    }
}
