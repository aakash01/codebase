package com.aakash.practice.interviewbit_may2017.string;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */
public class CompareVersion {

    public int compareVersion(String a, String b) {
        String[] s1 = a.split("\\.");
        String[] s2 = b.split("\\.");
        int i = 0;
        int j = 0;
        while(i<s1.length && j<s2.length){
            long n = Long.parseLong(s1[i]);
            long m = Long.parseLong(s2[j]);
            if(n != m){
                return (n > m) ? 1 : -1;
            }
            i++;
            j++;
        }
        while(i<s1.length){
            long n = Long.parseLong(s1[i]);
            if(n > 0){
                return 1;
            }
            i--;
        }
        while(j<s2.length){
            long m = Long.parseLong(s2[j]);
            if(m > 0){
                return -1;
            }
            j--;
        }

        return 0;
    }

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion("1.1","1.2"));
        System.out.println(compareVersion.compareVersion("1.1","1.13"));
        System.out.println(compareVersion.compareVersion("1.13.4","1.13"));
        System.out.println(compareVersion.compareVersion("4444371174137455","1.1"));
    }
}
