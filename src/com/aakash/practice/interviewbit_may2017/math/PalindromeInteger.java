package com.aakash.practice.interviewbit_may2017.math;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/17/17.
 */
public class PalindromeInteger {

    public boolean isPalindrome(int a){
        int r = 0;
        if(a < 0){
            return false;
        }
        while(a > 0 && a != r){
            int t = a%10;
            a = a/10;
            if(a == r){
                return true;
            }
            r = r*10 + t;
            if(r == 0){
                return false;
            }
        }
        return a == r;
    }

    public static void main(String[] args){
        PalindromeInteger pi = new PalindromeInteger();
        System.out.println(pi.isPalindrome(1234599999));
    }
}
