package com.aakash.practice.programcreek.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums.length == 0){
            return null;
        }
        int[] result = new int[nums.length -k +1];
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        int i=0;
        while(i<k){
            q.add(i);
            i++;
        }
        int j=0;
        result[j++] = nums[q.peek()];
        while(i<nums.length){
            while(!q.isEmpty() && q.peek() <= i-k){
                q.poll();
            }
            q.add(i);
            result[j++] = nums[q.peek()];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        System.out.println(Arrays.toString(slidingWindowMax.maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}
