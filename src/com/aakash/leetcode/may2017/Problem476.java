package com.aakash.leetcode.may2017;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/8/17.
 */
public class Problem476 {

    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int bit = num & 1;
            sb.append(bit);
            num = num >> 1;
        }
        int complement = 0;
        int index = 0;
        for(char ch : sb.toString().toCharArray()){
            complement += Math.pow(2, index)*complement(ch - '0');
            index++;
        }
        return complement;
    }

    private int complement(int n){
        return n == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Problem476 problem476 = new Problem476();
        System.out.println(problem476.findComplement(7));
    }
}
