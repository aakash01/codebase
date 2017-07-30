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
public class StrStr {

   public int strStr(final String haystack, final String needle) {
      if(needle == null || needle.length() == 0 || haystack == null || haystack.length() == 0){
         return -1;
      }
      
      for(int i=0;i<=haystack.length()-needle.length();i++){
         int temp = i,j=0;
         while(j < needle.length() && haystack.charAt(temp) == needle.charAt(j)){
            j++;
            temp++;
         }
         if(j == needle.length()){
            return i;
         }
      }
      return -1;
   }
}
