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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Aakash on 30-Aug-16.
 */

/*
Problem Statement

You run a one-man restaurant that's super popular in your area. However, given the limited number of hands and legs, you can serve only one customer at a time. Your customers like your food, but have limited patience.

n customers visit you on a day. The ith customer (Ci) has the following associated parameters:

Arrival time (ai). Time begins from 0.

Time that will be taken to process his/her order (oi)

Total time he/she is willing to wait to be served (si). So, if Ci arrives at ai, then he/she will leave at time ai + si with or without being served.

Whether the customer is a preferred customer p (0: not preferred, 1: preferred)

You need to write a program that will serve the maximum number of preferred customers from these n customers.

In case of conflicts, use the following rules in descending order of priority:

Serve the maximum number of total customers
Minimize the order processing time
Input

Line1: Whole number denoting the number of customers (n)

The next n lines will contain the parameters defined above separated by space

ai oi si p

Output

2 whole numbers separated by a space, where the first number denotes the number of preferred customers served, and the second number denotes the number of not preferred customers served.

Examples:

Input:

3

0 3 7 1

1 4 5 1

1 3 7 0

Output:

1 1

Explanation:

There is only one order to process at time 0, and requires 3 time units to process.

Only 1 preferred customer arrives at time 1 but has little patience and will not wait long enough for his order to be processed. Therefore, this customer cannot be served.

Therefore, only 2 of the 3 customers can be served, 1 preferred, the other not preferred.

Input:

4

3 6 7 0

2 3 14 1

0 4 4 0

2 13 15 1

Output:

1 2

Explanation:

Rearranging the customers in increasing order of arrival:

0 4 4 0

2 3 14 1

2 13 15 1

3 6 7 0

First customer is served at time 0.

At time 4, the following cases arise:

1. If you serve customer 2 13 15 1, you cannot serve any of the other customers. So the maximum number of preferred customers is 1.

2. If you serve customer 3 6 7 0 instead, you can also serve customer 2 3 14 1, thereby serving a maximum of 1 preferred customer.

 Constraints

0 < n < 100
 */
public class BiasedChef {

   public static void main(String[] args) {
      Scanner a = new Scanner(System.in);
      int n= a.nextInt();
      TreeSet<Customer> customers = new TreeSet<>();
      for(int i=0;i<n;i++){
         int ai = a.nextInt();
         int oi = a.nextInt();
         int si = a.nextInt();
         int p = a.nextInt();
         customers.add(new Customer(i, ai, oi, si, p == 1));
      }
      Output output = calculateOutput(customers, 0);
      System.out.println(output);
      
   }
   
   
   private static Output calculateOutput(TreeSet<Customer> customers, int currTime){
      List<Customer> possibleCustomers = new ArrayList<>();
      Output output = new Output(0,0);

      Iterator<Customer> it = customers.iterator();
      boolean found = false;
      while (it.hasNext()){
         Customer customer = it.next();
         if(customer.arrivalTime > currTime){
            if(found){
               break;
            }
            currTime  = customer.arrivalTime;
         }
         if(customer.arrivalTime <= currTime){
            if(currTime + customer.orderTime <= (customer.waitTime + customer.arrivalTime)) {
               possibleCustomers.add(customer);
               found = true;
            }
         }
      }
      System.out.println("At time "+currTime+" possible customer "+possibleCustomers);
      if(!possibleCustomers.isEmpty()) {
         for (Customer customer : possibleCustomers) {
            if( currTime + customer.orderTime <= (customer.waitTime + customer.arrivalTime)) {
               System.out.println("Picking Customer "+customer.index);
               customers.remove(customer);
               Output opt = calculateOutput(customers, currTime + customer.orderTime);
               opt.incrementCount(customer.preferred);
               if(opt.getPreferredCustomers() > output.getPreferredCustomers()){
                  output.setPreferredCustomers(opt.getPreferredCustomers());
                  output.setNonPreferredCustomers(opt.getNonPreferredCustomers());
               } else if(opt.getPreferredCustomers()  == output.getPreferredCustomers() && opt.getNonPreferredCustomers() > output.getNonPreferredCustomers()){
                  output.setNonPreferredCustomers(opt.getNonPreferredCustomers());
               }
               customers.add(customer);
            }
         }
      }
      return output;
      
   }
   
   
   
   
   static class Customer implements Comparable<Customer> {
      int index;
      int arrivalTime;
      int orderTime;
      int waitTime;
      boolean preferred;

      public Customer(int index, int arrivalTime, int orderTime, int waitTime, boolean preferred) {
         this.index = index;
         this.arrivalTime = arrivalTime;
         this.orderTime = orderTime;
         this.waitTime = waitTime;
         this.preferred = preferred;
      }

      @Override
      public String toString() {
         final StringBuilder sb = new StringBuilder("Customer{");
         sb.append("index=").append(index);
         sb.append('}');
         return sb.toString();
      }

      @Override
      public int compareTo(Customer o) {
         if(arrivalTime == o.arrivalTime){
            return index - o.index;
         }
         return arrivalTime - o.arrivalTime;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o)
            return true;
         if (o == null || getClass() != o.getClass())
            return false;

         Customer customer = (Customer) o;

         return index == customer.index;

      }

      @Override
      public int hashCode() {
         return index;
      }
   }
   
   static class Output {
      int preferredCustomers = 0;
      int nonPreferredCustomers = 0;

      public Output(int preferredCustomers, int nonPreferredCustomers) {
         this.preferredCustomers = preferredCustomers;
         this.nonPreferredCustomers = nonPreferredCustomers;
      }

      public int getPreferredCustomers() {
         return preferredCustomers;
      }

      public void setPreferredCustomers(int preferredCustomers) {
         this.preferredCustomers = preferredCustomers;
      }
      
      public void incrementCount(boolean preferred){
         if(preferred) {
            this.preferredCustomers += 1;
         } else {
            this.nonPreferredCustomers +=1;
         }
      }

      public int getNonPreferredCustomers() {
         return nonPreferredCustomers;
      }

      public void setNonPreferredCustomers(int nonPreferredCustomers) {
         this.nonPreferredCustomers = nonPreferredCustomers;
      }

      @Override
      public String toString() {
         return getPreferredCustomers() +" "+getNonPreferredCustomers();
      }
   }
}
