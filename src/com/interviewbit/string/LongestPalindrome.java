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
package com.interviewbit.string;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class LongestPalindrome {
   
   public String longestPalindrome(String s){
      int startIndex  = -1;
      int maxLen = 0;
      for(int i=0;i<s.length();i++){
         int p=i,q=i,currLen = 0;
         while(p>=0 && q<s.length() && s.charAt(p) == s.charAt(q)){
            p--;
            q++;
         }
         currLen = q-p-1;
         if(currLen > maxLen){
            startIndex = p+1;
            maxLen = currLen;
         }
         p=i;
         q=i+1;
         while(p>=0 && q<s.length() && s.charAt(p) == s.charAt(q)){
            p--;
            q++;
         }
         currLen = q-p-1;
         if(currLen > maxLen){
            startIndex = p+1;
            maxLen = currLen;
         }
      }
      return s.substring(startIndex, startIndex + maxLen);
   }
}
