package com.aakash.practice.leetcode.may2017;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/4/17.
 */
public class Problem461 {

    public int hammingDistance(int x, int y) {
        int distance = 0;
        while(x!=0 && y!=0){
            distance += (x&1)^(y&1);
            x = x >> 1;
            y = y >> 1;
        }
        while(x != 0){
            distance++;
            x = x & x-1;
        }
        while(y != 0){
            distance++;
            y = y & y-1;
        }
        return distance;
    }

    public static void main(String[] args) {
        Problem461 problem461 = new Problem461();
        System.out.println(problem461.hammingDistance(8, 7));
    }
}
