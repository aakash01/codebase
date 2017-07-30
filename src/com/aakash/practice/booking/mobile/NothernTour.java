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

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aakash on 11-Aug-16.
 */
public class NothernTour {

   static Set<City> itinerary = new LinkedHashSet<>();
   public static void main(String[] args) {
      Scanner a = new Scanner(System.in);
      int n = a.nextInt();
      a.nextLine();
      Map<String, City> cities  = new HashMap<>();
      for(int i=0;i<n;i++){
         City city = new City(a.nextLine());
         cities.put(city.name, city);
      }
      City city = new City("Bevagna",0);
      cities.put(city.name, city);
      int e = a.nextInt();
      a.nextLine();
      for(int i=0;i<e;i++){
         String[] connection = a.nextLine().split(",");
         City city1 = cities.get(connection[0]);
         City city2 =  cities.get(connection[1]);
         int time = Integer.parseInt(connection[2]);
         city1.addNeighbour(city2, time);
         city2.addNeighbour(city1, time);
      }
      Set<City> visited = new LinkedHashSet<>();
      visited.add(city);
      dfs(city, visited, 8);
      itinerary.remove(city);
      for(City c : itinerary){
            System.out.println(c.name);
      }
      if(itinerary.isEmpty()){
         System.out.println("NONE");
      }
   }
   
   static void dfs(City city, Set<City> visited, int totalTime){
      if(visited.size() > itinerary.size()){
         itinerary = new LinkedHashSet<>();
         itinerary.addAll(visited);
      }
         if(totalTime > 144){
            return;
         }
         // we start at 8 in morning if time is between 12-8
         if(totalTime % 24 < 8){
            totalTime += 8 - totalTime%24;
         }
      int start = totalTime;
      for(Map.Entry<City, Integer> entry : city.neighbourCities.entrySet()) {
         City nc = entry.getKey();
         totalTime = start;
         if(!visited.contains(nc)) {
            int timeRemainingForDay = 24 - totalTime % 24;
            Integer travelTime = entry.getValue();
            if (timeRemainingForDay < travelTime) {
               if (timeRemainingForDay == 16 || travelTime > 16) {
                  continue;
               } else {
                  totalTime += timeRemainingForDay + 8; // start next morning. 
                  timeRemainingForDay = 16;
               }
            }
            
            totalTime += travelTime;
            timeRemainingForDay -= travelTime;
            int stayTime = nc.stayTime;
            while(stayTime > 0){
               if(timeRemainingForDay >= stayTime){
                  totalTime += stayTime;
                  break;
               } else {
                  totalTime += timeRemainingForDay + 8;
                  stayTime -= timeRemainingForDay;
                  timeRemainingForDay = 16;
               }
            }
            if (totalTime > 144) {
               continue;
            }
           //System.out.println(visited+" ---> "+nc.name+ " Time Taken "+(totalTime - start));
            visited.add(nc);
            dfs(nc, visited, totalTime);
            visited.remove(nc);
         }
      }
   }
   
   static class City {
      String name;
      int stayTime;
      Map<City, Integer> neighbourCities = new HashMap<>();

      public City(String name, int stayTime) {
         this.name = name;
         this.stayTime = stayTime;
      }
      
      public City(String nameTimePair){
         String[] pair = nameTimePair.split(",");
         this.name = pair[0];
         this.stayTime = Integer.parseInt(pair[1]);
      }
      
      void addNeighbour(City city, int time){
         neighbourCities.put(city, time);
      }

      @Override
      public boolean equals(Object o) {
         if (this == o)
            return true;
         if (o == null || getClass() != o.getClass())
            return false;

         City city = (City) o;

         return name.equals(city.name);

      }

      @Override
      public int hashCode() {
         return name.hashCode();
      }

      @Override
      public String toString() {
         final StringBuilder sb = new StringBuilder();
         sb.append(name);
         return sb.toString();
      }
   }
}
