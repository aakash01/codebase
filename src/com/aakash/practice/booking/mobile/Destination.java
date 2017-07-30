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
package com.aakash.practice.booking.mobile;

import java.util.Scanner;

/**
 * Created by Aakash on 10-Aug-16.
 */
public class Destination {

   public static void main(String[] args) {
      Scanner a = new Scanner(System.in);
      int n = a.nextInt();
      int m = a.nextInt();
      int c = a.nextInt();
      
      long cmbns = 1;
      int uniqueCities = n+m-c;
      for(int i=2;i<uniqueCities;i++){
         cmbns *= i;
      }
      System.out.println(cmbns);
      
   }
   
}
