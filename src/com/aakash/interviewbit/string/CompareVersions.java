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
 * Created by Aakash on 13-Sep-16.
 */
public class CompareVersions {

   public int compareVersion(String a, String b) {
      String[] s1 = a.split("\\.");
      String[] s2 = b.split("\\.");
      int i=0;
      while(i<s1.length && i < s2.length){
         String a1 = s1[i];
         String a2 = s2[i];
         
         int l1 = a1.length();
         int l2 = a2.length();
         int j=0,k=0;
         while(j<a1.length() && a1.charAt(j) == '0'){
            j++;
            l1--;
         }
         while(k<a2.length() && a2.charAt(k) == '0'){
            k++;
            l2--;
         }
         
         if(l1 != l2){
            return l1 > l2 ? 1 : -1;
         }
         while(j < l1){
            if(a1.charAt(j) != a2.charAt(j)){
               return a1.charAt(j) > a2.charAt(j) ? 1 : -1;
            }
            j++;
         }
         i++;
      }
      if(i != s1.length){
         for(char ch : s1[i].toCharArray()){
            if(ch!='0'){
               return 1;
            }
         }
      }
      else if(i != s2.length){
         for(char ch : s2[i].toCharArray()){
            if(ch!='0'){
               return -1;
            }
         }
      }
      
      return 0;
   }

   public int compareVersion2(String a, String b) {
      
      int i=0,j=0;
      while(i < a.length() || j < b.length()){
         int n1 = 0, n2 = 0;
         
         while(i < a.length() && a.charAt(i) != '.'){
            n1 = n1*10 + (a.charAt(i) - '0');
            i++;
         }

         while(j < b.length() && b.charAt(j) != '.'){
            n2 = n2*10 + (b.charAt(j) - '0');
            j++;
         }
         
         if(n1 != n2){
            return n1>n2 ? 1 : -1;
         }
         i++;
         j++;
      }
      return 0;
   }
}
