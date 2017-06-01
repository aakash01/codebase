package com.aakash.leetcode.may2017;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/4/17.
 */
public class Problem557 {

    public String reverseWords(String s){
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : sArr){
            sb.append(reverse(str)).append(" ");
        }
        String output = sb.toString();
        if(output.length() >= 1){
            output = output.substring(0, output.length()-1);
        }
        return output;
    }

    private String reverse(String s){
        char[] cArr = s.toCharArray();
        int i=0, j = cArr.length-1;
        while(i<j){
            char t = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = t;
            i++;
            j--;
        }
        return new String(cArr);
    }

    public static void main(String[] args) {
        Problem557 problem557 = new Problem557();
        System.out.println(problem557.reverseWords(""));
    }
}
