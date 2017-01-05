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

/**
 * Created by Aakash on 11-Sep-16.
 */

import java.util.*;
import java.util.LinkedList;

/**
 * Minimum path from source to target. 
 * avoid obstacles
 */
public class Robot {

/*   public static void main(String[] args) {

      Scanner a = new Scanner(System.in);
      int t = a.nextInt();
      while(t-->0){
         int N = a.nextInt();
         int M = a.nextInt();
         char[][] grid = new char[N][M];
         a.nextLine();
         for(int i=0;i<N;i++){
            String row = a.nextLine();
            for(int j=0;j<M;j++){
               grid[i][j] = row.charAt(j);
            }
         }
         System.out.println(minPath(grid));
      }
   }
   
   public static int minPath(char[][] grid){
      Queue<Point> points = new LinkedList<>();
      int N = grid.length;
      int M = grid[0].length;
      int[][] pathCost = new int[N][M];
      for(int i=0; i<N; i++){
         for(int j=0; j<M; j++){
            if(grid[i][j] == 'B'){
               points.offer(new Point(i, j));
               pathCost[i][j] = 0;
            } else {
               pathCost[i][j] = -1;
            }
         }
      }
      
      while(!points.isEmpty()){
         Point point = points.poll();
         int cost = pathCost[point.i][point.j];
         int i = point.i,j = point.j;
         if(grid[i][j] == 'C'){
            return cost;
         }
         //visit top
         if(i-1 >= 0 && pathCost[i-1][j] == -1 && grid[i-1][j] != 'D'){
            pathCost[i-1][j] = cost+1;
            points.offer(new Point(i-1, j));
         }
         //visit bottom
         if(i+1 < N && pathCost[i+1][j] == -1 && grid[i+1][j] != 'D'){
            pathCost[i+1][j] = cost+1;
            points.offer(new Point(i+1, j));
         }
         //visit left
         if(j-1 >= 0 && pathCost[i][j-1] == -1 && grid[i][j-1] != 'D'){
            pathCost[i][j-1] = cost+1;
            points.offer(new Point(i, j-1));
         }
         //visit right
         if(j+1 < M && pathCost[i][j+1] == -1 && grid[i][j+1] != 'D'){
            pathCost[i][j+1] = cost+1;
            points.offer(new Point(i, j+1));
         }
      }
      return -1;
      
   }
   
   
   static class Point {
      int i, j;

      public Point(int i, int j) {
         this.i = i;
         this.j = j;
      }
   }*/

   public static void main (String[] args) throws java.lang.Exception
   {
      // your code goes here
      Scanner a = new Scanner(System.in);
      int t = a.nextInt();
      while(t-->0){
         int N = a.nextInt();
         int M = a.nextInt();
         char[][] grid = new char[N][M];
         //skip new line
         a.nextLine();
         for(int i=0;i<N;i++){
            String row = a.nextLine();
            for(int j=0;j<M;j++){
               grid[i][j] = row.charAt(j);
            }
         }
         System.out.println(getMinimumTime(grid));
      }
   }

   public static int getMinimumTime(char[][] grid){
      Queue<Cell> visitedCells = new LinkedList<>();
      int N = grid.length;
      int M = grid[0].length;
      int[][] minTimes = new int[N][M];
      for(int i=0;i<N;i++){
         for(int j=0;j<M;j++){
            if(grid[i][j] == 'B'){
               minTimes[i][j] = 0;
               visitedCells.offer(new Cell(i,j));
            } else {
               minTimes[i][j] = -1;
            }
         }
      }
      while(!visitedCells.isEmpty()){
         Cell currCell = visitedCells.poll();
         int i = currCell.i, j = currCell.j;
         int currTime = minTimes[i][j];
         if(grid[i][j] == 'C'){
            return currTime;
         }
         // visit left
         if(j-1>=0 && grid[i][j-1] != 'D' && minTimes[i][j-1] == -1){
            minTimes[i][j-1] = currTime + 1;
            visitedCells.offer(new Cell(i, j-1));
         }
         // visit right
         if(j+1<M && grid[i][j+1] != 'D' && minTimes[i][j+1] == -1){
            minTimes[i][j+1] = currTime + 1;
            visitedCells.offer(new Cell(i, j+1));
         }

         // visit top
         if(i-1>=0 && grid[i-1][j] != 'D' && minTimes[i-1][j] == -1){
            minTimes[i-1][j] = currTime + 1;
            visitedCells.offer(new Cell(i-1, j));
         }

         // visit bottom
         if(i+1<N && grid[i+1][j] != 'D' && minTimes[i+1][j] == -1){
            minTimes[i+1][j] = currTime + 1;
            visitedCells.offer(new Cell(i+1, j));
         }

      }

      return -1;
   }

   static class Cell {
      int i, j;
      public Cell(int i, int j){
         this.i = i;
         this.j = j;
      }
   }


}
