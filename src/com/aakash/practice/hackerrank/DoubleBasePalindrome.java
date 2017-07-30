package com.aakash.practice.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/26/17.
 */
public class DoubleBasePalindrome {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int i = a.nextInt();
        Set<Integer> triange = new HashSet<>();
        for(int k=1;k<33;k++){
            int n = k * (k+1)/2;
            triange.add(n);
        }
        while(i-- > 0){
            int k = a.nextInt();
            System.out.println(isBase10Palindrome(k) && isBase2Palindrome(k));
        }
    }

    private static boolean isBase10Palindrome(int a){
        String s = String.valueOf(a);
        int i=0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    private static boolean isBase2Palindrome(int a){
        String s = Integer.toBinaryString(a);
        int i=0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
