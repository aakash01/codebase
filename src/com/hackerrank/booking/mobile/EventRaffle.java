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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Aakash on 11-Aug-16.
 */
public class EventRaffle {

   public static void main(String[] args) {
      Scanner a = new Scanner(System.in);
      int n = a.nextInt();
      List<Person> persons = new ArrayList<>();
      for(int i=0;i<n;i++){
         Person person  = new Person(i+1);
         int eventAssigned = a.nextInt();
         int p = a.nextInt();
         for(int j=0;j<p;j++){
            person.addPassion(a.next());
         }
         persons.add(person);
      }
      List<Event> events = new ArrayList<>();
      for(int i=0;i<n;i++){
         Event event = new Event(i+1);
         int e = a.nextInt();
         for(int j=0;j<e;j++){
            event.addPassion(a.next());
         }
         events.add(event);
      }

      int count = 0;
      for(Person p : persons){
         if(canAttend(events, p, new HashSet<Event>())){
            count++;
         }
      }
      System.out.println(count);
   }

   private static boolean canAttend(List<Event> events, Person p, Set<Event> processed) {
      for(Event event : events){
         if(!processed.contains(event) && ! Collections.disjoint(event.passions, p.passions)) {
            processed.add(event);
            if(event.person == null || canAttend(events, event.person, processed)){
               event.person = p;
               return true;
            }
         }
      }

      return false;
   }

   static class Person {
      int id;
      Set<String> passions = new HashSet<>();

      public Person(int id) {
         this.id = id;
      }

      void addPassion(String passion){
         passions.add(passion);
      }
   }

   static class Event {
      int id;
      Set<String> passions = new HashSet<>();
      Person person;

      public Event(int id) {
         this.id = id;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o)
            return true;
         if (o == null || getClass() != o.getClass())
            return false;

         Event event = (Event) o;

         return id == event.id;

      }

      @Override
      public int hashCode() {
         return id;
      }

      public void addPassion(String passion) {
         passions.add(passion);
      }
   }
}
