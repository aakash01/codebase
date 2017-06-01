package com.aakash.interviewbit_may2017.backtracking;

import com.aakash.common.AwesomeQuestion;

import java.util.ArrayList;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
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
