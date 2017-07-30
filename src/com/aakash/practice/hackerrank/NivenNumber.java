package com.aakash.practice.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/26/17.
 */
public class NivenNumber {

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
            System.out.println(isPrime(k) && isStrongNivenNumber(k/10) && isRightTruncatableNiven(k/10));
        }
    }

    private static int getDigitSum(int n){
        int sum = 0;
        int t = n;
        while(t > 0){
            sum += t%10;
            t = t/10;
        }
        return sum;
    }

    private static boolean isNivenNumber(int n){
        int sum = getDigitSum(n);
        return n%sum == 0;
    }

    private static boolean isStrongNivenNumber(int n){
        int sum = getDigitSum(n);
        int k = n/sum;
        return isPrime(k) &&  n%sum == 0;
    }

    private static boolean isRightTruncatableNiven(int n){
        if(n == 0){
            return true;
        }
        return isNivenNumber(n) && isRightTruncatableNiven(n/10);
    }

    private static boolean isPrime(int n){
        if(n == 2){
            return true;
        }
        if(n %2 == 0){
            return false;
        }
        for(int i=3;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }


}
