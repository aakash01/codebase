package com.aakash.practice.interviewbit_may2017.string;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class PalindromeString {

    public int isPalindrome(String a) {
        int i=0, j = a.length()-1;
        int n = a.length();
        char[] carr = a.toCharArray();
        while(i<j){
            while(i<n && !isAlphaNumeric(carr[i])){
                i++;
            }
            while(j<n && !isAlphaNumeric(carr[j])){
                j--;
            }
            if(Character.toLowerCase(carr[i]) != Character.toLowerCase(carr[j])){
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }

    private boolean isAlphaNumeric(char ch){
        if(ch >= 'a' && ch <= 'z'){
            return true;
        } else if(ch >= 'A' && ch <= 'Z'){
            return true;
        }else if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PalindromeString palindromeString = new PalindromeString();
        System.out.println(palindromeString.isPalindrome("race a car"));
    }
}
