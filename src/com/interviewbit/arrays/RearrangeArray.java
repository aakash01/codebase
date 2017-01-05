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
package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash on 17-Aug-16.
 */
public class RearrangeArray {

   public void arrange(ArrayList<Integer> a) {
      boolean zeroProcessed = false;
      for(int i=0;i<a.size();i++){
         int temp  =a.get(i);
         if(temp < 0 || (temp == 0 && !zeroProcessed)){
            continue;
         }
         if(temp == 0){
            zeroProcessed = true;
         }
         a.set(i, -1 * a.get(a.get(i)));
         for(int j=i+1;j<a.size();j++){
            if(a.get(j) == i){
               a.set(j, -1 * temp);
               break;
            }
         }
      }

      for(int i=0;i<a.size();i++){
         if(a.get(i)<0){
            a.set(i, -1 * a.get(i));
         }
      }
   }

   public void arrange2(ArrayList<Integer> a) {

      boolean zeroProcessed = false;
      for(int k=0;k<a.size();k++){
         int i = k;
         int temp  = a.get(i);
         if(temp < 0  || (temp == 0 && !zeroProcessed)){
            continue;
         }
         if(temp == 0){
            zeroProcessed = true;
         }
         int val = a.get(a.get(i));
         while(temp >= 0) {
            a.set(i, -1 * val);
            boolean found = false;
            for (int j = k + 1; j < a.size(); j++) {
               if (a.get(j) == i) {
                  found = true;
                  val = temp;
                  temp = a.get(j);
                  i = j;
                  break;
               }
            }
            if(!found){
               break;
            }
         }
      }

      for(int i=0;i<a.size();i++){
         if(a.get(i)<0){
            a.set(i, -1 * a.get(i));
         }
      }
   }

   public static void main(String[] args) {
      RearrangeArray arr = new RearrangeArray();
      ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 0, 2}));
      arr.arrange2(list);
      System.out.println(list);
   }
}
