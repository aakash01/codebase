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
package com.personal;

/**
 * Created by Aakash on 24-Aug-16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 Arrange given numbers to form the biggest number

 Given an array of numbers, arrange them in a way that yields the largest value. 
 For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. 
 And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 */
public class MakeBiggestNumber {

   public static void main(String[] args) {
      Integer[] arr = new Integer[]{54, 546, 548, 60};
      System.out.println(new ArrayList<>(Arrays.asList(arr)));
      Arrays.sort(arr, new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
            Integer i1 = Integer.parseInt(o1+""+o2);
            Integer i2 = Integer.parseInt(o2+""+o1);
            return i2.compareTo(i1);
         }
      });
      System.out.println(new ArrayList<>(Arrays.asList(arr)));

      IntegerHolder ir = new IntegerHolder(120);
      System.out.println(ir.getValue());
      new MakeBiggestNumber().update(ir);
      System.out.println(ir.getValue());
   }
   
   public void update(IntegerHolder ir){
      ir.setValue(100);
   }
   
   void sort(Object obj){
      System.out.println("Sort of obj");
   }

   void sort(String obj){
      System.out.println("Sort of string");
   }

   void sort(Integer obj){
      System.out.println("Sort of int");
   }
   
   static class IntegerHolder{
      int value;

      public IntegerHolder(int value) {
         this.value = value;
      }

      public int getValue() {
         return value;
      }

      public void setValue(int value) {
         this.value = value;
      }
   }
}
