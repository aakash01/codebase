package com.aakash.leetcode.may2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/8/17.
 */
public class Problem500 {

    private Map<Character, Integer> kbRowMap = new HashMap<>();
    public String[] findWords(String[] words) {
        initializekbRowMap();
        List<String> output = new ArrayList<>();
        for(String w : words){
            if(isSingleRow(w)){
                output.add(w);
            }
        }
        return output.toArray(new String[]{});
    }

    private void initializekbRowMap(){

        kbRowMap.put('q',1);
        kbRowMap.put('w',1);
        kbRowMap.put('e',1);
        kbRowMap.put('r',1);
        kbRowMap.put('t',1);
        kbRowMap.put('y',1);
        kbRowMap.put('u',1);
        kbRowMap.put('i',1);
        kbRowMap.put('o',1);
        kbRowMap.put('p',1);

        kbRowMap.put('a',2);
        kbRowMap.put('s',2);
        kbRowMap.put('d',2);
        kbRowMap.put('f',2);
        kbRowMap.put('g',2);
        kbRowMap.put('h',2);
        kbRowMap.put('j',2);
        kbRowMap.put('k',2);
        kbRowMap.put('l',2);

        kbRowMap.put('z',3);
        kbRowMap.put('x',3);
        kbRowMap.put('c',3);
        kbRowMap.put('v',3);
        kbRowMap.put('b',3);
        kbRowMap.put('n',3);
        kbRowMap.put('m',3);
    }

    private boolean isSingleRow(String w){
        if(null != w && w.length() > 0){
            w = w.toLowerCase();
            int row = kbRowMap.get(w.charAt(0));
            for(int i=1;i<w.length();i++){
                if(row != kbRowMap.get(w.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem500 problem500 = new Problem500();
        String[] output = problem500.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for(String s : output){
            System.out.println(s);
        }
    }
}
