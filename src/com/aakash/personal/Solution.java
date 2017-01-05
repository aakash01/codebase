package com.aakash.personal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

   public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

      PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
      Scanner a = new Scanner(System.in);
      int n = a.nextInt();
      int d = a.nextInt();
      int[] vals = new int[n];
      Map<Integer, List<Integer>> map = new HashMap<>();
      for(int i=0;i<n;i++){
         vals[i] = a.nextInt();
         List<Integer> list;
         if(map.containsKey(vals[i])){
            list = map.get(vals[i]);
         } else {
            list = new ArrayList<>();
         }
         list.add(i+1);
         map.put(vals[i], list);
      }
      for(int i=0;i<d;i++){
         int profit = a.nextInt();
         int start, end;
         for(int val : map.keySet()){
            int reqProfit = val + profit;
            if(map.containsKey(reqProfit)){
               
               
            }
         }
      }
   }

}