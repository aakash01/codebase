package com.aakash.interviewbit_may2017.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */
public class LongestNonRepeatString {
    public int lengthOfLongestSubstring(String a) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        char[] cArr = a.toCharArray();
        for(int i=0;i<cArr.length;i++){
            char ch  = cArr[i];
            if(map.containsKey(ch) && map.get(ch) >= start){
                int currMax = i - start;
                if(currMax > max){
                    max = currMax;
                }
                start = map.get(ch) + 1;
            }
            map.put(ch, i);
        }
        int currMax = a.length() - start;
        if(currMax > max){
            max = currMax;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestNonRepeatString longestNonRepeatString = new LongestNonRepeatString();
        System.out.println(longestNonRepeatString.lengthOfLongestSubstring("abcde"));
    }
}
