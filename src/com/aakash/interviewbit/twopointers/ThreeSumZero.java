/*
 * This computer program is the confidential information and proprietary trade
 * secret of Anuta Networks, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and
 * Anuta Networks, Inc., and receipt or possession does not convey any rights
 * to divulge, reproduce, or allow others to use this program without specific
 * written authorization of Anuta Networks, Inc.
 * 
 * Copyright (c) 2011-2012 Anuta Networks, Inc. All Rights Reserved.
 */
package com.aakash.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class ThreeSumZero {

   public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
      Collections.sort(a);
      ArrayList<ArrayList<Integer>> output = new ArrayList<>();
      for(int i=0;i<a.size()-2;i++){
         if(i > 0 && a.get(i).equals(a.get(i-1))){
            continue;
         }
         int  l = i+1;
         int r = a.size()-1;
         int req = 0 - a.get(i);
         while(l < r){
            if(a.get(l) + a.get(r) == req){
               output.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{a.get(i), a.get(l),a.get(r)})));
               l++;
               r--;
               while(l < a.size() && a.get(l-1) == a.get(l)) {
                  l++;
               }
               while(r >= 0 && a.get(r+1) == a.get(r)) {
                  r--;
               }
            } else if(a.get(l) + a.get(r) > req){
               r--;
            } else {
               l++;
            }
         }
      }
      return output;
   }
}
