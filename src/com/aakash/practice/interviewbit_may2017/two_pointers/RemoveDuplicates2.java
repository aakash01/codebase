package com.aakash.practice.interviewbit_may2017.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/26/17.
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(ArrayList<Integer> a) {
        int i=0,j=0;
        int len = a.size();
        while(j<len){
            int t = a.get(j);
            int count = 0;
            while(j<len && a.get(j) == t){
                j++;
                count++;
            }
            a.set(i++, t);
            if(count > 1){
                a.set(i++, t);
            }
        }
        return i;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1, 2, 2, 2, 3, 3, 4}));
        RemoveDuplicates2 removeDuplicates = new RemoveDuplicates2();
        System.out.println(a);
        System.out.println(removeDuplicates.removeDuplicates(a));
        System.out.println(a);

    }
}
