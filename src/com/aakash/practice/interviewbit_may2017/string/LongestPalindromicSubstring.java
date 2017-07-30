package com.aakash.practice.interviewbit_may2017.string;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String a) {
        int len = a.length();
        if(len == 0){
            return "";
        }
        int maxStart = -1, maxEnd = -1;

        // odd palindrome
        for(int  p=0;p<a.length();p++){
            int i = p-1, j=p+1;
            while(i>=0 && j<len && a.charAt(i) == a.charAt(j)){
                i--;j++;
            }
            if(j-i-1 > (maxEnd - maxStart)){
                maxStart = i+1;
                maxEnd = j;
            }
        }

        //even palindrome
        for(int  p=0;p<a.length()-1;p++){
            int i = p-1, j=p+2;
            if(a.charAt(p) == a.charAt(p+1)) {
                while (i >= 0 && j < len && a.charAt(i) == a.charAt(j)) {
                    i--;
                    j++;
                }
                if (j - i - 1 > (maxEnd - maxStart)) {
                    maxStart = i + 1;
                    maxEnd = j;
                }
            }
        }
        return a.substring(maxStart, maxEnd);

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("aaaabaaa"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("aaaaaaa"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("abb"));
    }
}
