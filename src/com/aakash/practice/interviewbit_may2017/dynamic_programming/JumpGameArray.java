package com.aakash.practice.interviewbit_may2017.dynamic_programming;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/30/17.
 */
@GoodQuestion
public class JumpGameArray {

    public int canJump(ArrayList<Integer> a) {
        int[] canJump = new int[a.size()];
        int dest = a.size()-1;
        canJump[dest] = 1;
        for(int i=a.size()-1; i>=0 ;i--){
            int t = a.get(i);
            if(t >= dest-i){
                canJump[i] = 1;
            } else {
                for(int j=1;j<=t;j++){
                    if(canJump[j+i] == 1){
                        canJump[i] = 1;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }

    private int canJumpHelper(ArrayList<Integer> a, int[] visited, int i) {
        if(i == a.size() -1){
            return 1;
        } else if(i<0 || i >= a.size() || visited[i] == -1){
            return 0;
        }
        visited[i] = -1;
        int left = canJumpHelper(a, visited, i - a.get(i));
        int right = canJumpHelper(a, visited, i + a.get(i));
        return left | right;
    }

    public static void main(String[] args) {
        JumpGameArray jumpGameArray = new JumpGameArray();
        System.out.println(jumpGameArray.canJump(new ArrayList<>(Arrays.asList(new Integer[]{3, 2, 1, 0, 1}))));
    }
}
