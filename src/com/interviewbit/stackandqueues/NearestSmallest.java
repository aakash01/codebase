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
package com.interviewbit.stackandqueues;

import java.util.ArrayList;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class NearestSmallest {

   public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
      ArrayList<Integer> output = new ArrayList<>();
      output.add(-1);
      for(int i=1;i<arr.size();i++){
         if(arr.get(i) > arr.get(i-1)){
            output.add(i-1);
         } else {
            int t = output.get(i-1);
            while(t!=-1 && arr.get(t) >= arr.get(i)){
               t = output.get(t);
            }
            output.add(t);
         }
      }
      
      for(int i=1;i<output.size();i++){
         if(output.get(i) != -1){
            output.set(i, arr.get(output.get(i)));
         }
      }
      return output;
   }
}
