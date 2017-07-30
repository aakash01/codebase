package com.aakash.practice.interviewbit_may2017.greedy;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/29/17.
 */

@AwesomeQuestion
public class DistributeCandy {

    public int candy(ArrayList<Integer> ratings) {
        int[] candies = new int[ratings.size()];

        candies[0] = 1;

        //from let to right
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings.get(i) > ratings.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            } else {
                // if not ascending, assign 1
                candies[i] = 1;
            }
        }

        int result = candies[ratings.size() - 1];

        //from right to left
        for (int i = ratings.size() - 2; i >= 0; i--) {
            int cur = 1;
            if (ratings.get(i) > ratings.get(i + 1)) {
                cur = candies[i + 1] + 1;
            }

            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }
        return result;
    }

    public static void main(String[] args) {
        DistributeCandy distributeCandy = new DistributeCandy();
        ArrayList<Integer> ratings = new ArrayList<>(Arrays.asList(new Integer[]{4, 5, 6, 1, 2}));
        System.out.println(distributeCandy.candy(ratings));
    }
}
