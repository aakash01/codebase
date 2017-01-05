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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

Explanation:g

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
public class BiasedChef1 {

   private static final String PREFERRED = "preferred";
   private static final String NONPREFERRED = "nonpreferred";

   public static void main(String[] args) {
      Scanner a = new Scanner(System.in);
      int n= a.nextInt();
      /*Comparator comparator = new Comparator<ArrayList<Integer>>() {
         @Override
         public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            if(getCustomerArrivalTime(o1) == getCustomerArrivalTime(o2)){
               return getCustomerIndex(o1) - getCustomerIndex(o2) ;
            }
            return getCustomerArrivalTime(o1) - getCustomerArrivalTime(o2);
         }
      };*/
      ArrayList<ArrayList<Integer>> customers = new ArrayList<ArrayList<Integer>>();
      for(int i=0;i<n;i++){
         ArrayList<Integer> list = new ArrayList<>();
         list.add(i);
         list.add(a.nextInt());
         list.add(a.nextInt());
         list.add(a.nextInt());
         list.add(a.nextInt());
         customers.add(list);
      }
      sortList(customers);
      Map<String, Integer> output = calculateOutput(customers, 0);
      System.out.println(output.get(PREFERRED)+" "+output.get(NONPREFERRED));
   }
   
   // sort list based on arrival time
   
   private static void sortList(ArrayList<ArrayList<Integer>> list){
      for (int i = 0; i < list.size(); i++) {
         for (int j = list.size() - 1; j > i; j--) {
            if ( (getCustomerArrivalTime(list.get(i))  == getCustomerArrivalTime(list.get(j)) && getCustomerIndex(list.get(i)) > getCustomerIndex(list.get(j)))
                           || getCustomerArrivalTime(list.get(i)) > getCustomerArrivalTime(list.get(j))) {

               ArrayList<Integer> tmp = list.get(i);
               list.set(i,list.get(j)) ;
               list.set(j,tmp);
            }
         }
      }
   }
   
   // stroring customer as list. utility methods. 
   
   private static int getCustomerIndex(List<Integer> customer){
      return customer.get(0);
   }

   private static int getCustomerArrivalTime(List<Integer> customer){
      return customer.get(1);
   }

   private static int getCustomerOrderTime(List<Integer> customer){
      return customer.get(2);
   }

   private static int getCustomerWaitTime(List<Integer> customer){
      return customer.get(3);
   }
   
   private static boolean isCustomerPreferred(List<Integer> customer){
      return 1 == customer.get(4);
   }



   private static Map<String, Integer> calculateOutput(ArrayList<ArrayList<Integer>> customers, int currTime){
      ArrayList<ArrayList<Integer>> possibleCustomers = new ArrayList<>();
      Map<String, Integer> output = new HashMap<>();
      output.put(PREFERRED,0);
      output.put(NONPREFERRED,0);
      Iterator<ArrayList<Integer>> it = customers.iterator();
      boolean found = false;
      while (it.hasNext()){
         ArrayList<Integer> customer = it.next();
         if(getCustomerArrivalTime(customer) > currTime){
            if(found){
               break;
            }
            currTime  = getCustomerArrivalTime(customer);
         }
         if(getCustomerArrivalTime(customer) <= currTime){
            if(currTime + getCustomerOrderTime(customer) <= (getCustomerWaitTime(customer) + getCustomerArrivalTime(customer))) {
               possibleCustomers.add(customer);
               found = true;
            }
         }
      }
      //System.out.println("At time "+currTime+" possible customer "+possibleCustomers);
      if(!possibleCustomers.isEmpty()) {
         for (ArrayList<Integer> customer : possibleCustomers) {
            if( currTime + getCustomerOrderTime(customer) <= (getCustomerWaitTime(customer) + getCustomerArrivalTime(customer))) {
               //System.out.println("Picking Customer "+customer.get(0));
               customers.remove(customer);
               Map<String, Integer> subOutput = calculateOutput(customers, currTime + getCustomerOrderTime(customer));
               //System.out.println(" Opt "+opt);
               //System.out.println("Customer picked is "+customer);
               if(isCustomerPreferred(customer)){
                  subOutput.put(PREFERRED, subOutput.get(PREFERRED)+1);
               } else {
                  subOutput.put(NONPREFERRED, subOutput.get(NONPREFERRED)+1);
               }
               if(subOutput.get(PREFERRED) > output.get(PREFERRED)){
                  output.put(PREFERRED, subOutput.get(PREFERRED));
                  output.put(NONPREFERRED , subOutput.get(NONPREFERRED));
               } else if(subOutput.get(PREFERRED).equals(output.get(PREFERRED)) && subOutput.get(NONPREFERRED) > output.get(NONPREFERRED)){
                  output.put(NONPREFERRED, subOutput.get(NONPREFERRED));
               }
               customers.add(customer);
            }
         }
      }
      return output;
   }
   
}
