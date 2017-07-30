package com.aakash.practice.interviewbit_may2017.math;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/1/17.
 */
public class ExcelColumnTitle {

    public String convertToTitle(int a) {

        StringBuilder sb = new StringBuilder();
        while(a > 0){
            int d = a % 26;
            boolean t = false;
            if(d == 0){
                d = 25;
                t = true;
            }else {
                d = d-1;
            }
            sb.append((char) ('A' + d));
            a /= 26;
            if(t) {
                a--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle excelColumnTitle = new ExcelColumnTitle();
        System.out.println(excelColumnTitle.convertToTitle(943566));
    }
}
