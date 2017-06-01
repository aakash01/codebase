package com.aakash.interviewbit_may2017.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> a) {

        if(a.isEmpty()){
            return "";
        }

        String initString = a.get(0);

        for(int i=0;i<initString.length();i++){
            char ch = initString.charAt(i);
            for(int j = 1;j<a.size();j++){
                String s = a.get(j);
                if(i >= s.length() || s.charAt(i) != ch){
                    return initString.substring(0, i);
                }
            }
        }
        return initString;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new ArrayList<>(Arrays.asList(new String[] {"aakash",

                "rahul",

                "hina"}))));
    }
}
