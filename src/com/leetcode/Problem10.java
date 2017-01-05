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
package com.leetcode;

/**
 * Created by Aakash on 02-Sep-16.
 */
public class Problem10 {

   public static void main(String[] args) {
      Problem10 prob = new Problem10();
      System.out.println(prob.isMatch("", ".*"));
   }

   public boolean isMatch(String s, String p) {
      System.out.println("Matching "+s+" "+p);
      if(isEmpty(s) && isEmpty(p)){
         return true;
      } else if(isEmpty(p)){
         return false;
      } else if(s.equals(p)){
         return true;
      } 
      if(p.length() > 1){
         boolean sub = false;
         if(s.length() > 0){
            sub = (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')&& isMatch(s.substring(1), p.charAt(1) == '*' ? p : p.substring(1));
         }
         if(p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || sub;
         }
         return sub;
      }
      
      return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') ;
   }
   
   private boolean isEmpty(String s){
      return s == null || s.equals("");
   }
}
