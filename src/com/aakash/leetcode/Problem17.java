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
package com.aakash.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aakash on 02-Sep-16.
 */
public class Problem17 {
   private static Map<Character, List<String>> map = new HashMap<>();
   
   static  {
      map.put('2',new ArrayList<String>(Arrays.asList(new String[]{"a","b","c"})));
      map.put('3',new ArrayList<String>(Arrays.asList(new String[]{"d","e","f"})));
      map.put('4',new ArrayList<String>(Arrays.asList(new String[]{"g","h","i"})));
      map.put('5',new ArrayList<String>(Arrays.asList(new String[]{"j","k","l"})));
      map.put('6',new ArrayList<String>(Arrays.asList(new String[]{"m","n","o"})));
      map.put('7',new ArrayList<String>(Arrays.asList(new String[]{"p","q","r","s"})));
      map.put('8',new ArrayList<String>(Arrays.asList(new String[]{"t","u","v"})));
      map.put('8',new ArrayList<String>(Arrays.asList(new String[]{"w","x","y","z"})));
   }
   public List<String> letterCombinations(String digits) {
      if(digits == null || digits.length() == 0){
         return new ArrayList<>();
      } else if(digits.length() == 1){
         return map.containsKey(digits.charAt(0))? map.get(digits.charAt(0)) : new ArrayList<String>();
      } else {
         List<String> output = new ArrayList<>();
         List<String> subList = letterCombinations(digits.substring(1));
         if(subList != null && subList.size() >0 && map.containsKey(digits.charAt(0))){
            for(String character : map.get(digits.charAt(0))){
               for(String srt : subList) {
                  output.add(character+""+srt);
               }
            }
         }
         return output;
      }
   }

   public static void main(String[] args) {
      Problem17 prob = new Problem17();
      System.out.println(prob.letterCombinations("123"));
   }
}
