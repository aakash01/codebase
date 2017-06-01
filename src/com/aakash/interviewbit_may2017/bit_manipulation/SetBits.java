package com.aakash.interviewbit_may2017.bit_manipulation;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class SetBits {
    public int numSetBits(long a) {
        int count = 0;
        while(a != 0){
            a = a&a-1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        SetBits setBits = new SetBits();
        System.out.println(setBits.numSetBits(1243948593));
    }
}
