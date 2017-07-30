package com.aakash.practice.interviewbit_may2017.string;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */
public class BinarySum {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i=a.length() - 1, j=b.length() - 1;
        int carry = 0;
        while(i>=0 && j>=0){
            int t = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            sb.append(t % 2);
            carry = t/2;
            i--;
            j--;
        }
        while(i >= 0){
            int t = a.charAt(i) - '0' + carry;
            sb.append(t % 2);
            carry = t/2;
            i--;
        }
        while(j >= 0){
            int t = b.charAt(j) - '0' + carry;
            sb.append(t % 2);
            carry = t/2;
            j--;
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        BinarySum binarySum = new BinarySum();
        System.out.println(binarySum.addBinary("1010110111001101101000", "1000011011000000111100110"));
    }
}
