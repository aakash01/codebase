package com.aakash.practice.interviewbit_may2017.string;

import com.aakash.practice.common.GoodQuestion;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */

/**
 *

 The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...

 1 is read off as one 1 or 11.
 11 is read off as two 1s or 21.

 21 is read off as one 2, then one 1 or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 Example:

 if n = 2,
 the sequence is 11.

 */
@GoodQuestion
public class CountAndSay {

    public String countAndSay(int a) {
        String s = "1";
        for(int i=1;i<a;i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char ch = s.charAt(0);
            for(int j=1;j<s.length();j++){
                char ch1 = s.charAt(j);
                if(ch1 == ch){
                    count++;
                } else {
                    sb.append(count);
                    sb.append(ch);
                    count = 1;
                    ch = ch1;
                }
            }
            sb.append(count);
            sb.append(ch);
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
        System.out.println(countAndSay.countAndSay(6));
        System.out.println(countAndSay.countAndSay(7));
        System.out.println(countAndSay.countAndSay(50));
    }
}
