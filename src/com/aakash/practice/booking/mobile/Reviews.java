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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Aakash on 11-Aug-16.
 */
public class Reviews {

   public static void main(String[] args) {

      long start = 1465992000;
      long end = 1468584000;
      Scanner a = new Scanner(System.in);
      int n = a.nextInt();
      int m = a.nextInt();
      a.nextLine();
      List<String> passions = new ArrayList<>();
      for(int i=0;i<n;i++){
         passions.add(a.nextLine().toLowerCase());
      }
      Map<Integer, Reviewer> rmap = new HashMap<>();
      for(int i=0;i<m;i++){
         int id = a.nextInt();
         Reviewer reviewer = rmap.containsKey(id) ? rmap.get(id) : new Reviewer(id);
         rmap.put(id, reviewer);
         long ts;
         try {
            ts = Long.valueOf(a.next());
         } catch(NumberFormatException nf){
            ts = 0;
         }
         a.nextLine();
         String body = a.nextLine().toLowerCase();
         int currScore = (ts >= start && ts<= end) ? 20 : 10;
         currScore += body.replaceAll(" ","").length() >=100 ? 20 : 10;
         for(String passion : passions){
            Pattern pattern = Pattern.compile(".*\\b"+passion+"\\b.*");
            if(pattern.matcher(body).matches()){
               reviewer.addPassion(passion, currScore);
            }
         }
      }

      for(String passion : passions){
         int id = -1;
         long max = -1;
         for(Reviewer reviewer : rmap.values()){
            if(reviewer.passions.containsKey(passion)) {
               if (reviewer.passions.get(passion) == max && reviewer.id < id) {
                  id = reviewer.id;
               } else if (reviewer.passions.get(passion) > max) {
                  id = reviewer.id;
                  max = reviewer.passions.get(passion);
               }
            }
         }
         System.out.println(id);
      }
   }

   static class Reviewer {
      int id;
      Map<String, Long> passions = new HashMap<>();

      public Reviewer(int id) {
         this.id = id;
      }
      void addPassion(String passion, int currentScore){
         long score = currentScore;
         if(passions.containsKey(passion)){
            score += passions.get(passion);
         }
         passions.put(passion, score);
      }
   }
}