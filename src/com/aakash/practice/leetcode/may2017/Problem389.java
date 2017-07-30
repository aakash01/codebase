package com.aakash.practice.leetcode.may2017;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/9/17.
 */
public class Problem389 {

    public char findTheDifference(String s, String t) {
        int i = 0;
        for(char ch : s.toCharArray()){
            i ^= (ch - 'a');
        }
        for(char ch : t.toCharArray()){
            i ^= (ch - 'a');
        }
        return (char) ('a' + i);
    }

    public static void main(String[] args) {
        Problem389 problem389 = new Problem389();
        System.out.println(problem389.findTheDifference("aabd", "dbaza"));
    }
}
