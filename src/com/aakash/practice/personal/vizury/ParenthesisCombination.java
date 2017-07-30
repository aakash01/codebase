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
package com.aakash.practice.personal.vizury;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash on 20-Sep-16.
 */
public class ParenthesisCombination {

   public static void main(String[] args) {
      combinations(3, 0, 0, new ArrayList<Character>());
   }
   
   public static void combinations(int n, int open, int closed, List<Character> parenthesis){
      if(open == n && closed == n){
         System.out.println(Arrays.toString(parenthesis.toArray()));
      }
      
      if(open < n){
         parenthesis.add('(');
         combinations(n, open+1, closed, parenthesis);
         parenthesis.remove(parenthesis.size()-1);
      }

      if(closed < open){
         parenthesis.add(')');
         combinations(n, open, closed+1, parenthesis);
         parenthesis.remove(parenthesis.size()-1);
      }
   }
}
