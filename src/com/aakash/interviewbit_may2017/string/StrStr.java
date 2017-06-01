package com.aakash.interviewbit_may2017.string;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class StrStr {

    public int strStr(final String haystack, final String needle) {
        if(null == needle || needle.length() == 0){
            return -1;
        }
        int l1 = haystack.length();
        int l2 = needle.length();
        int i = 0;
        while(i<=(l1-l2)){
            int j =i, k=0;
            while(k<l2){
                if(haystack.charAt(j) != needle.charAt(k)){
                    break;
                }
                j++;k++;
            }
            if(k == l2){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("", "kk"));
    }
}
