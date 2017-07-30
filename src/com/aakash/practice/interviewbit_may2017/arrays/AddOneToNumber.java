package com.aakash.practice.interviewbit_may2017.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/21/17.
 */
public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        int carry = 1;
        int i = a.size()-1;
        while(i>=0 && carry > 0){
            int n = a.get(i);
            int num = n + carry;
            carry = num/10;
            num = num %10;
            a.set(i, num);
            i--;
        }
        boolean isTrailZero = true;
        ArrayList<Integer> result = new ArrayList<>();
        if(carry > 0){
            result.add(carry);
            result.addAll(a);
        } else {
            for(int n : a){
                if(n == 0 && isTrailZero){
                    continue;
                }
                isTrailZero = false;
                result.add(n);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        AddOneToNumber addOneToNumber = new AddOneToNumber();
        System.out.println(addOneToNumber.plusOne(new ArrayList<>(Arrays.asList(new Integer[]{1, 0,0}))));
    }
}
