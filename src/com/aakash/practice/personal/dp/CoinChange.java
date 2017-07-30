package com.aakash.practice.personal.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a0n007d on 05/02/17.
 */
public class CoinChange {

   static int coinChange(int[] set, int sum, int i, List<Integer> list){

      if(sum == 0){
         System.out.println(list);
         return 1;
      }

      if(i<0 || sum<0){
         return 0;
      }

      List<Integer> l1 = new ArrayList<>();
      l1.addAll(list);
      l1.add(set[i]);

      return coinChange(set, sum - set[i], i, l1) + coinChange(set, sum, i - 1, list);
   }

   public static void main(String[] args) {
      int[] set = {1, 2, 3};
      System.out.println(coinChange(set, 4, 2, new ArrayList<Integer>()));
   }
}
