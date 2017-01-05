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
package com.aakash.interviewbit.string;

/**
 * Created by Aakash on 10-Sep-16.
 */
public class Palindrome {

   public static void main(String[] args) {
      Palindrome palindrome = new Palindrome();
      System.out.println(palindrome.isPalindrome("1a1"));
   }

   public int isPalindrome(String a) {
      int l = 0, r = a.length()-1;
      a = a.toLowerCase();
      while(r > l){
         while(l<a.length() && !isAlphaNumeric(a.charAt(l))){
            l++;
         }
         while(r >=0 && !isAlphaNumeric(a.charAt(r))){
            r--;
         }
         if(l < a.length() && r >= 0) {
            if (a.charAt(l) != a.charAt(r)) {
               return 0;
            }
         }
         l++;
         r--;
      }
      return 1;
   }
   
   private boolean isAlphaNumeric(char ch){
      if(ch >= 'a' && ch <='z'){
         return true;
      } else if(ch >= 'A' && ch <='Z'){
         return true;
      } else if(ch >= '0' && ch <='9'){
         return true;
      }
      return false;
   }
}
