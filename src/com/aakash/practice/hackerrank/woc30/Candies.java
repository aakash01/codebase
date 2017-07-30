package com.aakash.practice.hackerrank.woc30;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Created by a0n007d on 14/03/17.
 */
public class Candies {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] c = new int[t];
        for(int c_i=0; c_i < t; c_i++){
            c[c_i] = in.nextInt();
        }
        // your code goes here
        int total=0, curr=n;
        for(int i=1;i<t;i++){
            curr = curr - c[i-1];
            if(curr < 5){
                total += (n - curr);
                curr = n;
            }
        }
        System.out.println(total);
    }
}

