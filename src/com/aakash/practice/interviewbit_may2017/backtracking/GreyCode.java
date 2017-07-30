package com.aakash.practice.interviewbit_may2017.backtracking;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */

/**
 *

 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2

 There might be multiple gray code sequences possible for a given n.
 Return any such sequence.

 */

@AwesomeQuestion
public class GreyCode {

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result  = new ArrayList<>();
        if(a == 0){
            return result;
        } else if(a == 1){
            result.add(0);
            result.add(1);
            return result;
        }
        ArrayList<Integer> subResult = grayCode(a-1);
        for(Integer i : subResult){
            result.add(i);
        }
        for(int k = subResult.size()-1 ; k>=0 ; k--){
            int i = subResult.get(k);
            i = i | (1 << (a-1));
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        GreyCode greyCode = new GreyCode();
        ArrayList<Integer> res =greyCode.grayCode(4);
        System.out.println(res);
        System.out.println();
        for(Integer i : res){
            System.out.print(Integer.toBinaryString(i)+", ");
        }

    }
}
