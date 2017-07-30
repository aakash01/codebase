package com.aakash.practice.programcreek.arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/15/17.
 */
public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int i, int j){
        if(j < p.length() && p.charAt(j) == '*') {
            while (j < p.length() && p.charAt(j) == '*') {
                j++;
            }
            j--;
        }
        if(j == p.length() - 1 && '*' == p.charAt(j)){
            return true;
        }
        if((i == s.length() && j == p.length())){
            return true;
        } else if(i >= s.length() || j >= p.length()){
            return false;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return helper(s, p, i+1, j+1);
        } else if(p.charAt(j) == '*'){
            return helper(s, p, i+1, j) || helper(s, p, i, j+1);
        }
        return false;
    }

    public static void main(String[] args) {
        WildCardMatching wildCardMatching = new WildCardMatching();
        System.out.println(wildCardMatching.isMatch("ho"
                ,"ho**"));
    }
}
