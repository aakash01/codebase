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
package com.aakash.practice.personal;

import java.util.ArrayList;

/**
 * Created by Aakash on 03-Oct-16.
 */
public class Test {

   public static int braces(String a) {
      java.util.Stack<Character> stack = new java.util.Stack<>();
      for(char ch : a.toCharArray()){
         System.out.print(ch);
         if(ch == '('){
            System.out.print(" Inside if ");
            stack.push(ch);
         } else if(ch == '*' || ch == '-' || ch == '+' || ch == '/'){
            System.out.print(" Inside else if ");
            stack.push(ch);
         } else if(ch == ')'){
            System.out.print(" Inside else if 2 ");
            int count = 0;
            while(!stack.isEmpty()){
               Character c = stack.pop();
               System.out.print(c);
               if(c.equals('(')){
                  break;
               }
               count++;
            }
            if(count == 0){
               return 1;
            }
         }
      }
      return 0;
   }

   public static ArrayList<String> prettyJSON(String a) {
      ArrayList<String> result = new ArrayList<String>();
      String prefix = "";
      StringBuilder sb = new StringBuilder(prefix);
      for(char ch : a.toCharArray()){
         if(ch == '{' || ch == '['){
            result.add(sb.toString());
            result.add(prefix+ch);
            prefix += "\t";
            sb = new StringBuilder(prefix);
            continue;
         } else if(ch == '}' || ch == ']'){
            result.add(sb.toString());
            prefix = prefix.substring(0, prefix.length() - 2);
            result.add(prefix+ch);
            sb = new StringBuilder(prefix);
            continue;
         } else if(ch == ','){
            sb.append(ch);
            result.add(sb.toString());
            sb = new StringBuilder(prefix);
         } else {
            sb.append(ch);
         }
      }
      return result;
   }

   public static String getPalAtCenter(String a, int l, int r){
      int len = a.length();
      int count =  l == r ? -1 : 0;
      while(l >=0 && r<len && a.charAt(l) == a.charAt(r)){
         l--;
         r++;
         count +=2;
      }
      int start = l+1;
      return a.substring(start, start+count);

   }

   public static String longestPalindrome(String a) {
      int l = a.length();
      if(l == 0){
         return "";
      }
      String lp = a.substring(0,1);
      for(int i=0;i<l-1;i++){
         String p = getPalAtCenter(a, i, i);
         if(p.length() > lp.length()){
            lp = p;
         }
         p = getPalAtCenter(a, i, i+1);
         if(p.length() > lp.length()){
            lp = p;
         }
      }
      return lp;
   }

   public static void main(String[] args) {
      /*int count = 0;
      for(int i=1;i<=100;i++){
         int factors = 0;
         for(int j=1;j<=i;j++){
            if(i%j == 0){
               factors++;
            }
         }
         if(factors%2 !=0){
            System.out.print(i+" ");
            count++;
         }
      }*/
//      System.out.println(braces("((( a+b))"));
//
//      System.out.println("ans");
//      ArrayList<Integer> list = new ArrayList<>();
//      list.add(3);
//      ArrayList<Integer> sublist = new ArrayList<>(list.subList(0,1));
//      System.out.println(list);
//      System.out.println(sublist);
      System.out.println(longestPalindrome("caccbcbaabacabaccacaaccaccaaccbbcbcbbaacabccbcccbbacbbacbccaccaacaccbbcc"));

   }
}
