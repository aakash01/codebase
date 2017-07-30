package com.aakash.practice.interviewbit_may2017.dynamic_programming;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/2/17.
 */
@AwesomeQuestion
public class MinJumpArray {

    public int jump(ArrayList<Integer> a){
        if(a.size() == 1){
            return 0;
        }
        int maxIndex = 0;
        int jump = 0;
        int prevMaxIndex = -1;
        for(int i=0;i<a.size() && i<=maxIndex;i++){
            if(a.get(i) + i > maxIndex){
                if(i>prevMaxIndex){
                    jump++;

                    prevMaxIndex = maxIndex;
                }
                maxIndex = a.get(i)+ i;
            }
            if(maxIndex >= a.size()-1){
                return jump;
            }
        }
        if(maxIndex >= a.size()-1){
            return jump;
        }
        return -1;
    }

    public int jump2(ArrayList<Integer> a) {
        int n = a.size();
        int[] minJump = new int[n];
        minJump[n-1] = 0;
        for(int i = n-2; i>= 0;i--){
            int maxJumps = a.get(i);
            int currMin = Integer.MAX_VALUE;
            for(int k = 1;k<=maxJumps && k+i < n;k++){
                if(minJump[k+i] != -1 && currMin>minJump[k+i]){
                    currMin = minJump[k+i];
                }
            }
            if(currMin == Integer.MAX_VALUE){
                currMin = -1;
            } else{
                currMin += 1;
            }
            minJump[i] = currMin;
        }
        return minJump[0];
    }

    public static void main(String[] args) {
        MinJumpArray minJumpArray = new MinJumpArray();
        System.out.println(minJumpArray.jump(new ArrayList<>(Arrays.asList(new Integer[]{33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28}))));
    }
}
