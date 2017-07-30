package com.aakash.practice.interviewbit_may2017.math;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/22/17.
 */
public class ExcelColumnNumber {

    public int titleToNumber(String a) {
        int n = 0;
        for(char ch : a.toCharArray()){
            n = n*26 + (ch - 'A' + 1);
        }

        return n;
    }

    public static void main(String[] args) {
        ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
        System.out.println(excelColumnNumber.titleToNumber("AZ"));
    }
}
