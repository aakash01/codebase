package com.aakash.practice.personal.dp;

import static com.aakash.practice.personal.dp.Helper.min;
/**
 * Created by a0n007d on 05/02/17.
 */

public class EditDistance {

   static int EDRecursive(String A, String B, int i, int j){
      if(i == A.length()){
         return B.length() - j;
      }
      if(j == B.length()){
         return A.length() - i;
      }
      if(A.charAt(i) == B.charAt(j)){
         return EDRecursive(A, B , i+1, j+1);
      }
      return 1+ min(EDRecursive(A,B,i+1,j+1), EDRecursive(A,B,i,j+1), EDRecursive(A,B,i+1,j));
   }

   static int EDDP(String A, String B){
      int ED[][] = new int[A.length()+1][B.length()+1];

      for(int i=0;i<=A.length();i++){
         ED[i][0] = i;
      }
      for(int j=0;j<=B.length();j++){
         ED[0][j] = j;
      }

      for(int i=1;i<=A.length();i++){
         for(int j=1; j<= B.length(); j++){
            if(A.charAt(i-1) == B.charAt(j-1)){
               ED[i][j] = ED[i-1][j-1];
            } else {
               ED[i][j] = 1 + min(ED[i][j-1], ED[i-1][j-1], ED[i-1][j]);
            }
         }
      }
      /*System.out.println();
      for(int i=0;i<=A.length();i++){
         for(int j=0;j<=B.length();j++){
            *//*if(i == 0 && j == 0){
               System.out.print(" ");
            } else if(i==0){
               System.out.print(B.charAt(j-1));
            } else if(j == 0){
               System.out.print(A.charAt(i-1));
            }*//*
            System.out.print(ED[i][j]+" ");
         }
         System.out.println();
      }*/

      return ED[A.length()][B.length()];
   }

   public static void main(String[] args) {
      String A="sunday";
      String B="saturday";
      System.out.println(EDRecursive(A,B,0,0));
      System.out.println(EDDP(A, B));
   }
}
