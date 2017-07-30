package com.aakash.practice.interviewbit_may2017.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class ColorFulNumber {
    public int colorful(int a) {
        Map<Integer, Integer> map = new HashMap<>();
        String str = String.valueOf(a);
        for(int i=1;i<=str.length();i++){
            for(int j=0;j<=str.length()-i;j++){
                String s = str.substring(j, j+i);
                int p = getProduct(s);
                if(map.containsKey(p)){
                    return 0;
                }
                map.put(p, p);
            }
        }
        return 1;
    }

    private int getProduct(String s){
        int i = 1;
        for(char ch : s.toCharArray()){
            i *= (ch - '0');
        }
        return i;
    }

    public static void main(String[] args) {
        ColorFulNumber colorFulNumber = new ColorFulNumber();
        System.out.println(colorFulNumber.colorful(2345));
    }
}
