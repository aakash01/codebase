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
package com.aakash.practice.personal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Aakash on 16-Sep-16.
 */
public class EmployeeTest {

   public static void main(String[] args) {
      List<Employee> emps = new ArrayList<>();
      Employee employee1 = new Employee("Aakash", "Nagar");
      Employee employee2 = new Employee("Abhishek", "Nagar");
      Employee employee3 = new Employee("Rahul", "Nagar");
      Employee employee4 = new Employee("Rahul", "Sharma");
      Employee employee5 = new Employee("Rahul", "Verma");
      
      emps.add(employee3);
      emps.add(employee4);
      emps.add(employee2);
      emps.add(employee5);
      emps.add(employee1);

      System.out.println(emps);
      Collections.sort(emps, new Comparator<Employee>() {
         @Override
         public int compare(Employee o1, Employee o2) {
            
            if(o1.lname.equals(o2.lname)){
               return o1.fname.compareTo(o2.fname);
            }
            
            return o1.lname.compareTo(o2.lname);
            
         }
      });

      System.out.println(emps);
      System.out.println(someFunc());
      
      List<Integer> integerList = new ArrayList<>();
      
      integerList.add(10);
      integerList.add(20);
      
      List someList = integerList;
      someList.add("String");
      
      for(Object obj : someList){
         System.out.println("Some Object");
      }
      System.out.println(10f == 10.0);
      System.out.println(10L == 10.0);
      System.out.println(10 == 10.0);
   }
   
   private static int someFunc(){
      
      try{
         return 0;
      }finally {
         return 1;
      }
   }
   
   static class Employee {
      String fname;
      String lname;

      public Employee(String fname, String lname) {
         this.fname = fname;
         this.lname = lname;
      }

      @Override
      public String toString() {
         final StringBuilder sb = new StringBuilder("Employee{");
         sb.append("fname='").append(fname).append('\'');
         sb.append(", lname='").append(lname).append('\'');
         sb.append('}');
         return sb.toString();
      }
   }
}
