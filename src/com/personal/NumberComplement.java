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
package com.personal;

import java.util.Scanner;

/**
 * Created by Aakash on 31-Aug-16.
 */

public class NumberComplement {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int res;
      int _n;
      _n = Integer.parseInt(in.nextLine());

      res = getIntegerComplement(_n);
      System.out.println(res);

   }
   
   static int getIntegerComplement(int n) {
      String s  = Integer.toBinaryString(n);
      StringBuilder sb = new StringBuilder();
      for(char ch : s.toCharArray()){
         sb.append(ch == '1' ? "0" : "1");
      }
      return Integer.parseInt(sb.toString(), 2);
   }
}
