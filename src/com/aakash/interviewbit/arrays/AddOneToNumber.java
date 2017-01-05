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
package com.aakash.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Aakash on 16-Aug-16.
 */
public class AddOneToNumber {

   public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
      int carry = 1;
      for(int i=a.size()-1;i>=0 && carry > 0;i--){
         int num = a.get(i) + carry;
         a.set(i, num%10);
         carry = num / 10;
      }
      if(carry > 0){
         a.add(0, carry);
      }
      Iterator it = a.iterator();
      boolean remove = true;
      while (it.hasNext() && remove){
         if(it.next().equals(0)){
            it.remove();
         } else {
            remove = false;
         }
      }
      return a;
   }

   public static void main(String[] args) {
      AddOneToNumber an = new AddOneToNumber();
      ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{0,0, 0, 1, 2, 3}));
      System.out.println(an.plusOne(list));
   }
}
