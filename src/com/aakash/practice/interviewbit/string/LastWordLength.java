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
package com.aakash.practice.interviewbit.string;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class LastWordLength {

   public int lengthOfLastWord(final String a) {
      
      int l = 0;
      boolean wordStarted = false;
      
      char[] str = a.toCharArray();
      for(int i=str.length-1;i>=0;i--){
         if(str[i] == ' '){
            if(wordStarted) {
               return l;
            }
         } else {
            wordStarted = true;
            l++;
         }
      }
      return l;
   }
}
