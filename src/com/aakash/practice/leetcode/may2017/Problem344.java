package com.aakash.practice.leetcode.may2017;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/8/17.
 */
public class Problem344 {

    public String reverseString(String s){
        if(null != s){
            char[] cArr = s.toCharArray();
            int i = 0, j=cArr.length-1;
            while(i<j){
                char t = cArr[i];
                cArr[i] = cArr[j];
                cArr[j] = t;
                i++;
                j--;
            }
            return new String(cArr);
        }
        return s;
    }

    public static void main(String[] args) {
        Problem344 problem344 = new Problem344();
        System.out.println(problem344.reverseString("ABCD"));
    }
}
