package com.aakash.practice.interviewbit_may2017.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class LetterCombination {

    ArrayList<ArrayList<String>> map = new ArrayList<>();
    public LetterCombination(){
        init();
    }

    private void init(){
        map.add(new ArrayList<>(Arrays.asList(new String[]{"0"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"1"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"a", "b", "c"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"d", "e", "f"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"g", "h", "i"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"j", "k", "l"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"m", "n", "o"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"p", "q", "r", "s"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"t", "u", "v"})));
        map.add(new ArrayList<>(Arrays.asList(new String[]{"w", "x", "y", "z"})));
    }

    public ArrayList<String> letterCombinations(String a) {
        if(a.length() == 0){
            return new ArrayList<>();
        } else if(a.length() == 1){
            int k = Integer.parseInt(a);
            return map.get(k);
        } else {
            String s1 = a.substring(0, 1);
            String s2 = a.substring(1);
            int k = Integer.parseInt(s1);
            ArrayList<String> comb = map.get(k);
            ArrayList<String> subResult = letterCombinations(s2);
            ArrayList<String> result = new ArrayList<>();
            for(String c : comb){
                for(String subR : subResult){
                    result.add(c+subR);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        System.out.println(letterCombination.letterCombinations("2"));
    }
}
