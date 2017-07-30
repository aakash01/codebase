package com.aakash.practice.interviewbit_may2017.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/25/17.
 */
public class RemoveDuplicates {

    public int removeDuplicates(ArrayList<Integer> a) {
        int i=0,j=0;
        int len = a.size();
        while(j<len){
            int t = a.get(j);
            while(j<len && a.get(j) == t){
                j++;
            }
            a.set(i, t);
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4}));
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(a);
        System.out.println(removeDuplicates.removeDuplicates(a));
        System.out.println(a);

    }
}
