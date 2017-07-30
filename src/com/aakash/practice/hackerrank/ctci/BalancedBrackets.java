package com.aakash.practice.hackerrank.ctci;

import java.util.Scanner;

/**
 * Created by a0n007d on 28/02/17.
 */
public class BalancedBrackets {
    public static boolean isBalanced(String expression) {
        if(expression == null){
            return false;
        }
        int i = 0, j = expression.length() - 1;

        while(i<j){
            if(expression.charAt(i) != getMatchingBracket(expression.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return i != j;
    }

    private static char getMatchingBracket(char br){
        if(br == '}'){
            return '{';
        } else if(br == ')'){
            return '(';
        } else if(br == ']'){
            return '[';
        }
        return ' ';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
