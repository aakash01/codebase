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

/**
 * Created by Aakash on 17-Aug-16.
 */
public class Flip {

   public ArrayList<Integer> flip(String A) {
      ArrayList<Integer> result = new ArrayList<>();
      int maxSum = (A.charAt(0) - '0')*-1;
      int currSum = maxSum;
      int ms=-1,cs=0,me = 0;

      for(int i=0;i<A.length();i++){
         if(currSum < 0 ){
            currSum = 0;
            cs =i;
         }
         currSum += (A.charAt(i) == '0' ? 1:-1);
         if(currSum > maxSum){
            maxSum = currSum;
            ms = cs;
            me=i;
         }
      }
      if(ms != -1){
         result.add(ms+1);
         result.add(me+1);
      }
      return result;
   }
   
   private int getZeroOrOne(String A, int start, int end, boolean isOne){
      int count = 0;
      for(int i=start;i<=end;i++){
         if(A.charAt(i) == '1' && isOne){
            count++;
         } else if(A.charAt(i) == '0' && !isOne){
            count++;
         }
      }
      return count;
   }

   public static void main(String[] args) {
      Flip flip = new Flip();
      System.out.println(flip.flip("010"));
   }
}
