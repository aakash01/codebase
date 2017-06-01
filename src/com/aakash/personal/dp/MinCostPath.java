package com.aakash.personal.dp;

import static com.aakash.personal.dp.Helper.min;
/**
 * Created by a0n007d on 05/02/17.
 */
public class MinCostPath {

   static int minCostPath(int[][] cost, int m, int n, int i, int j){
      if(i == m || j == n){
         return Integer.MAX_VALUE;
      }
      else if (i==m-1 && j == n-1){
         return cost[i][j];
      }
      return min(minCostPath(cost, m, n, i+1, j), minCostPath(cost, m, n, i, j+1),
                     minCostPath(cost, m, n, i+1, j+1)) + cost[i][j];

   }

   static int minCostPathDP(int[][] cost, int m, int n, int i, int j, int[][] matrix){
      if(i == m || j == n){
         return Integer.MAX_VALUE;
      }
      else if (i==m-1 && j == n-1){
         return cost[i][j];
      }
      if(matrix[i][j] == -1) {
         matrix[i][j] = min(minCostPath(cost, m, n, i + 1, j), minCostPath(cost, m, n, i, j + 1),
                        minCostPath(cost, m, n, i + 1, j + 1)) + cost[i][j];
      }
      return matrix[i][j];
   }

   public static void main(String[] args) {
      int[][] cost = {{1,2,3},{4,8,2},{1,5,3}};
      System.out.println(minCostPath(cost, 3, 3, 0, 0));

      int[][] matrix = {{-1, -1, -1}, {-1, -1, -1},{-1, -1, -1}};

      System.out.println(minCostPathDP(cost, 3, 3, 0, 0, matrix));
   }
}
