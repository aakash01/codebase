package com.aakash.interviewbit_may2017.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/20/17.
 */
public class WaveArray {

    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for(int i=0; i+1<a.size(); i += 2){
            int t = a.get(i);
            a.remove(i);
            a.add(i+1, t);
        }
        return a;
    }

    public static void main(String[] args) {
        WaveArray waveArray = new WaveArray();
        System.out.println(waveArray.wave(new ArrayList<>(Arrays.asList(new Integer[]{1}))));
    }
}
