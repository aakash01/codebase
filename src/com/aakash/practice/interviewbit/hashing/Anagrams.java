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
package com.aakash.practice.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class Anagrams {
   
   public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
      ArrayList<ArrayList<Integer>> output = new ArrayList<>();

      HashMap<String, ArrayList<Integer>> map = new LinkedHashMap<>();
      for(int j=1;j<=a.size();j++){
         String s = a.get(j-1);
         char[] chars = new char[26];
         for(int i=0; i<s.length(); i++){
            chars[s.charAt(i)-'a']++;
         }
         String key  =  new String(chars);
         
         if(map.containsKey(key)){
            map.get(key).add(j);
         } else {
            map.put(key, new ArrayList<Integer>());
            map.get(key).add(j);
         }
      }
      output.addAll(map.values());
      return output;
   }
   
}
