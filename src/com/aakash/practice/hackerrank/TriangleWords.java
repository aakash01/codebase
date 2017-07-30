package com.aakash.practice.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/26/17.
 */
public class TriangleWords {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int i = a.nextInt();
        Set<Integer> triange = new HashSet<>();
        for(int k=1;k<33;k++){
            int n = k * (k+1)/2;
            triange.add(n);
        }
        a.nextLine();
        while(i-- > 0){
            String s = a.nextLine();
            int sum = 0;
            for(char ch : s.toCharArray()){
                sum += (ch - 'A' + 1);
            }
            System.out.println(triange.contains(sum));
        }
    }
}
