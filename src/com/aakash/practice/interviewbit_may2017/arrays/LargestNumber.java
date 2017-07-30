package com.aakash.practice.interviewbit_may2017.arrays;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/18/17.
 */
public class LargestNumber {
    public String largestNumber(final List<Integer> a) {
        Collections.sort(a, (o1, o2) -> {
            if(Long.parseLong(String.valueOf(o1) + String.valueOf(o2)) <
                    Long.parseLong(String.valueOf(o2) + String.valueOf(o1)))
                return 1;
            else return -1;
        });
        String num = "";
        // remove leading 0
        boolean numFound = false;
        for(Integer i : a){
            if(!numFound && i == 0){
                num = "0";
                continue;
            }
            numFound = true;
            num += i;
        }
        return num;
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new ArrayList<>(Arrays.asList(new Integer[]{602434609, 7750768}))));
    }
}
