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
import java.util.Iterator;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class RemoveDuplicateSortedArray {

   public int removeDuplicates(ArrayList<Integer> a) {
      
      int l = 0;
      
      for(int i=0;i<a.size();i++){
         a.set(l, a.get(i));
         l++;
         while(i<a.size()-1 && a.get(i).equals(a.get(i+1))){
            i++;
         }
      }
      
      return l;
   }

   public int removeDuplicatesArrayChange(ArrayList<Integer> a) {

      int l = 0;

      Iterator<Integer> it  = a.iterator();
      
      Integer prev = null, curr;
      
      while(it.hasNext()){
         curr = it.next();
         if(curr.equals(prev)){
            it.remove();
         } else {
            prev = curr;
         }
      }

      return a.size();
   }
}
