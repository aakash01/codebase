package com.aakash.practice.interviewbit_may2017.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/29/17.
 */
public class MiceToHoles {
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        int time = 0;
        for(int i=0;i<a.size();i++){
            time = Math.max(Math.abs(a.get(i) - b.get(i)), time);
        }
        return time;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(new Integer[]{4, -4, 2}));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(new Integer[]{4, 0, 5}));
        MiceToHoles miceToHoles = new MiceToHoles();
        System.out.println(miceToHoles.mice(a, b));
    }
}
