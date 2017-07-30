package com.aakash.practice.interviewbit_may2017.string;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */
public class ZigZagString {

    public String convert(String a, int b) {
        int l = a.length();
        char[] s = new char[l];
        if(b >= l || b ==1){
            return a;
        }
        int k=0;
        for(int i=1;i<=b;i++){
            int t = i-1;
            s[k++] = a.charAt(t);
            while(t < l){
                if(i != b) {
                    int p = (b - i) * 2;
                    t = t + p;
                    if (t < l) {
                        s[k++] = a.charAt(t);
                    }
                }
                if(i != 1){
                    int p = (i - 1) * 2;
                    t = t + p;
                    if (t < l) {
                        s[k++] = a.charAt(t);
                    }
                }
            }
        }
        return new String(s);
    }

    public static void main(String[] args) {
        ZigZagString zigZagString = new ZigZagString();
        System.out.println(zigZagString.convert("PAYPALISHIRING", 1));
    }
}
