package com.aakash.interviewbit_may2017.bit_manipulation;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class ReverseBits {

    public long reverse(long a) {
        long rev = 0;
        int count = 0;
        while(a > 0){
            long bit = a & 1;
            rev = (rev << 1) | bit;
            a = a>>1;
            count++;
        }
        rev = rev << (32-count);
        return rev;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverse(0));
    }
}
