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
package com.hackerrank.booking.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aakash on 10-Aug-16.
 */
public class Memories {
   public static void main(String[] args) {
      Scanner a = new Scanner(System.in);
      int x = a.nextInt();
      for(int i=0;i<x;i++){
         int n = a.nextInt();
         a.nextLine();
         List<String> excursions = new ArrayList<>();
         for(int j=0;j<n;j++){
            excursions.add(a.nextLine());
         }
         System.out.println(validateOrder(excursions));
      }
   }
   
   private static String validateOrder(List<String> excursions){
      Map<String, Set<String>> orderMap = new HashMap<>();
      for(String excursion : excursions){
         String[] attractions = excursion.split(",");
         int i=0;
         for(String attraction : attractions){
            i++;
            for(int j=i;j<attractions.length;j++){
               String nextAtr = attractions[j];
               if(orderMap.containsKey(nextAtr) && orderMap.get(nextAtr).contains(attraction)){
                  return "ORDER VIOLATION";
               } else {
                  Set<String> currOrder = orderMap.containsKey(attraction) ? orderMap.get(attraction) : new HashSet<String>();
                  currOrder.add(nextAtr);
                  orderMap.put(attraction, currOrder);
               }
            }
         }
      }
      return "ORDER EXISTS";
   }
}
