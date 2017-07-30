package com.aakash.practice.personal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

   private ArrayList<Integer> getSubset(ArrayList<Integer> a, int n){
      ArrayList<Integer> result = new ArrayList<>();
      int i = 0;
      while(n > 0){
         if((n&1) != 0){
            result.add(a.get(i));
         }
         n = n>>1;
         i++;
      }
      return result;
   }

   public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      for(int i=0;i<Math.pow(2, a.size()); i++){
         result.add(getSubset(a, i));
      }

      Collections.sort(result, new Comparator<ArrayList<Integer>>(){
      @Override
      public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2){
         int i =0, j=0;
         while(i<l1.size() && j < l2.size()){
            if(l1.get(i) < l2.get(j)){
               return -1;
            } else if(l1.get(i) > l2.get(j)){
               return 1;
            }
            i++;
            j++;
         }
         if(i<l1.size()){
            return 1;
         } else if(j<l2.size()){
            return -1;
         }
         return 0;
      }
	    });

      return result;


   }

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