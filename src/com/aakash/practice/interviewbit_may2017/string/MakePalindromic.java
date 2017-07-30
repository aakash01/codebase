package com.aakash.practice.interviewbit_may2017.string;

import com.aakash.practice.common.GoodQuestion;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */

@GoodQuestion
public class MakePalindromic {

    public int solve(String A) {
        int odd = oddPalindrome(A, (A.length() -1 )/2);
        int even =evenPalindrome(A, (A.length() -1)/2);
        System.out.println("String "+A+" odd "+ odd +" even "+even);
        return Math.min(odd, even );
    }

    private int oddPalindrome(String A, int pivot){
        if(pivot == 0){
            return A.length() - 1;
        }
        int i = pivot -1, j = pivot+1;
        while(i >= 0 && A.charAt(i) == A.charAt(j)){
            i--; j++;
        }
        if(i<0){
            return A.length() - j;
        }
        return oddPalindrome(A, pivot-1);
    }

    private int evenPalindrome(String A, int pivot){
        if(A.length() == 1 || pivot < 0){
            return A.length();
        }
        if(A.charAt(pivot) == A.charAt(pivot+1)) {
            int i = pivot - 1, j = pivot + 2;
            while (i >= 0 && j < A.length() && A.charAt(i) == A.charAt(j)) {
                i--;
                j++;
            }
            if (i < 0) {
                return A.length() - j;
            }
        }
        return evenPalindrome(A, pivot-1);
    }

    public static void main(String[] args) {
        MakePalindromic makePalindromic = new MakePalindromic();
        System.out.println(makePalindromic.solve("AAAAA"));
        System.out.println(makePalindromic.solve("AACD"));
        System.out.println(makePalindromic.solve("AACECAAAA"));
        System.out.println(makePalindromic.solve("ABCBAC"));
        System.out.println(makePalindromic.solve("AAAAAA"));
        System.out.println(makePalindromic.solve("ABCBA"));
        System.out.println(makePalindromic.solve("ABAABAC"));
    }
}
