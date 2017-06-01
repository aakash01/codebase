package com.aakash.interviewbit_may2017.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */

public class PalindromePartition {

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(a.length() == 0){
            return result;
        }
        for(int i=1;i<=a.length();i++){
            String s1 = a.substring(0, i);
            if(isPalindrome(s1)){
                String rest = a.substring(i);
                ArrayList<ArrayList<String>> subResult = partition(rest);
                if(subResult.isEmpty()){
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(s1);
                    result.add(t);
                } else {
                    for (ArrayList<String> subR : subResult) {
                        subR.add(0, s1);
                        result.add(subR);
                    }
                }
            }
        }
        Collections.sort(result, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                for(int i=0, j=0;i<o1.size() && j<o2.size();i++,j++){
                    if(o1.get(i).length() == o2.get(j).length()){
                        continue;
                    } else{
                        return o1.get(i).length() - o2.get(j).length();
                    }
                }
                return 0;
            }
        });

        return result;

    }

    private boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        int i=0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition palindromePartition = new PalindromePartition();
        System.out.println(palindromePartition.partition("a"));
    }
}
