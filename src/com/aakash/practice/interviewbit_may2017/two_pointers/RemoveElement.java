package com.aakash.practice.interviewbit_may2017.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/26/17.
 */
public class RemoveElement {


    public int removeElement(ArrayList<Integer> a, int b) {

        int i=0, k=-1;
        while(i<a.size()){
            if(a.get(i)!= b){
                a.set(++k, a.get(i));
            }
            i++;
        }
        return k+1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(new Integer[]{3, 2, 3, 3}));
        RemoveElement removeElement = new RemoveElement();
        System.out.println(a);
        System.out.println(removeElement.removeElement(a, 3));
        System.out.println(a);

    }
}
