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
package com.aakash.practice.personal.vizury;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Aakash on 20-Sep-16.
 */
public class KnightKill {

   public static void main(String[] args) {
      System.out.println(getMinPath("f5","h4","g2"));
   }
   
   public static int getMinPath(String knight, String queen , String rook){
      int p1 = getPath(knight, queen);
      int p2 = getPath(knight, rook);
      int p3 = getPath(queen, rook);
      
      return Math.min(p1+p3, p2 + p3);
   }
   
   public static int getPath(String start, String end){
      
      int[][] visited = new int[8][8];
      for(int i=0;i<8;i++){
         for(int j=0;j<8;j++){
            visited[i][j] = -1;
         }
      }
      int i = start.charAt(1) - '0';
      int j = start.charAt(0) - 'a';
      visited[i][j] = 0;
      
      Queue<String> queue = new LinkedList<>();
      queue.add(start);
      
      while(!queue.isEmpty()){
         String curr = queue.poll();
         i = curr.charAt(1) - '0';
         j = curr.charAt(0) - 'a';
         int min = visited[i][j];
         if(end.equals(curr)){
            return min;
         }
         // move top right
         if(i-2 >=0 && j+1 < 8 && visited[i-2][j+1] == -1){
            visited[i-2][j+1] = min + 1;
            queue.add(getPoint(i-2, j+1));
         }
         // move top left
         if(i-2 >=0 && j-1 >= 0 && visited[i-2][j-1] == -1){
            visited[i-2][j-1] = min + 1;
            queue.add(getPoint(i-2, j-1));
         }
         
         // move right top
         if(i-1 >=0 && j+2 < 8 && visited[i-1][j+2] == -1){
            visited[i-1][j+2] = min + 1;
            queue.add(getPoint(i-1, j+2));
         }
         
         // move right bottom
         if(i+1 < 8 && j+2 < 8 && visited[i+1][j+2] == -1){
            visited[i+1][j+2] = min + 1;
            queue.add(getPoint(i+1, j+2));
         }
         
         // move bottom right
         if(i+2 <8 && j+1 < 8 && visited[i+2][j+1] == -1){
            visited[i+2][j+1] = min + 1;
            queue.add(getPoint(i+2, j+1));
         }
         
         // move bottom left
         if(i+2 <8 && j-1 >= 0 && visited[i+2][j-1] == -1){
            visited[i+2][j-1] = min + 1;
            queue.add(getPoint(i+2, j-1));
         }
         
         // move left bottom
         if(i+1 < 8 && j-2 >= 0 && visited[i+1][j-2] == -1){
            visited[i+1][j-2] = min + 1;
            queue.add(getPoint(i+1, j-2));
         }

         //move left up
         if(i-1 >=0 && j-2 >= 0 && visited[i-1][j-2] == -1){
            visited[i-1][j-2] = min + 1;
            queue.add(getPoint(i-1, j-2));
         }
      }
      return 0;
   }

   private static String getPoint(int i, int j) {
      return (char)(j+'a')+""+(char)(i+'0');
   }
}
