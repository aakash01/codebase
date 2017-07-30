package com.aakash.practice.hackerrank.woc30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by a0n007d on 15/03/17.
 */
public class MelodiousPassword {

    private static String[] varr = new String[]{"a","e","i","o","u"};
    private static String[] carr = new String[]{"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","u","v","w", "x","z"};

    public static List<String> printPassword(int n, boolean vowel){
        if (n == 1) {
            if(vowel){
                return new ArrayList<>(Arrays.asList(varr));
            } else{
                return new ArrayList<>(Arrays.asList(carr));
            }
        } else{
            if(vowel){
                List<String> passwds = printPassword(n-1, false);
                List<String> newPasswds = new ArrayList<>();
                for(String c:varr){
                    for(String s : passwds){
                        newPasswds.add(c+s);
                    }
                }
                return newPasswds;
            } else{
                List<String> passwds = printPassword(n-1, true);
                List<String> newPasswds = new ArrayList<>();
                for(String c:carr){
                    for(String s : passwds){
                        newPasswds.add(c+s);
                    }
                }
                return newPasswds;
            }
        }
    }

    public static void main(String[] args) {
        int n=6;
        for(String s : printPassword(n, true)){
            System.out.println(s);
        }
        for(String s : printPassword(n, false)){
            System.out.println(s);
        }
    }
}
