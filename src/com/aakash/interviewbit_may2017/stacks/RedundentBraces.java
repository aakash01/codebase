package com.aakash.interviewbit_may2017.stacks;

import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class RedundentBraces {

    public int braces(String a) {
        Stack<Character> st = new Stack<>();
        for(char ch : a.toCharArray()){
            if(isOperator(ch)){
                st.push(ch);
            } else if(ch == '('){
                st.push(ch);
            } else if(ch == ')'){
                int count = 0;
                while(!st.isEmpty() && st.peek() != '('){
                    count++;
                    st.pop();
                }
                st.pop();
                if(count == 0){
                    return 1;
                }
            }
        }
        return 0;
    }

    private boolean isOperator(Character s){
        switch (s){
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:return false;
        }
    }

    public static void main(String[] args) {
        RedundentBraces redundentBraces = new RedundentBraces();
        System.out.println(redundentBraces.braces("((a + b))"));
    }
}
