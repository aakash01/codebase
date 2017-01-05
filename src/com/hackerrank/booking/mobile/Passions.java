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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aakash on 10-Aug-16.
 */
public class Passions {

   public static void main(String[] args) {
      Scanner a = new Scanner(System.in);
      int n = a.nextInt();
      Set<String> requiredPassions = new HashSet<String>();
      for(int i=0;i<n;i++){
         int m = a.nextInt();
         for(int j=0;j<m;j++){
            requiredPassions.add(a.next());
         }
      }
      int y = a.nextInt();
      a.nextLine();
      List<Destination> destinations = new ArrayList<>();
      for(int i=0;i<y;i++){
         String name = a.next();
         Destination destination = new Destination(name);
         destination.location = new Point(a.nextDouble(), a.nextDouble());
         int pc = a.nextInt();
         for(int j=0;j<pc;j++){
            destination.addPassion(a.next());
         }
         destinations.add(destination);
      }
      
      int max = -1;
      Destination dest1 = null, dest2 = null;
      
      for(int i=0;i<y;i++){
         Destination d1 = destinations.get(i);
         for(int j=i+1;j<y;j++){
            Destination d2 = destinations.get(j);
            Set<String> matchedPassions = new HashSet<>();
            matchedPassions.addAll(d2.passions);
            matchedPassions.addAll(d1.passions);
            matchedPassions.retainAll(requiredPassions);
            if(matchedPassions.size() == max){
               double db1 = distanceBetween(d1.location, d2.location);
               double db2 = distanceBetween(dest1.location, dest2.location);
               if(db1 < db2){
                  dest1 = d1;
                  dest2 = d2;
               }
            } else if(matchedPassions.size() > max){
               max = matchedPassions.size();
               dest1 = d1;
               dest2 = d2;
            }
         }
      }
      
      if(dest1.name.compareTo(dest2.name) < 0){
         System.out.println(dest1.name + " "+ dest2.name);
      } else {
         System.out.println(dest2.name + " "+ dest1.name);
      }
      
   }

   static class Destination {
      String name;
      Point location;
      Set<String> passions = new HashSet<String>();

      public Destination(String name) {
         this.name = name;
      }
      
      void addPassion(String passion){
         passions.add(passion);
      }
   }



   private static double distanceBetween(Point p1, Point p2){
      int EARTH_RAD = 6371;
      double p1Lat = Math.toRadians(p1.latitude);
      double p2Lat = Math.toRadians(p2.latitude);
      double p1Long = Math.toRadians(p1.longitude);;
      double p2Long = Math.toRadians(p2.longitude);

      return Math.abs(Math.acos(Math.sin(p1Lat) * Math.sin(p2Lat) + Math.cos(p1Lat) * Math.cos(p2Lat) * Math.cos(p2Long - p1Long)) * EARTH_RAD);
   }


   static class Point {
      double latitude;
      double longitude;

      public Point(double latitude, double longitude) {
         this.latitude = latitude;
         this.longitude = longitude;
      }
      
   }
}
