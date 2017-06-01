package com.aakash.personal.dp;

/**
 * Created by a0n007d on 05/02/17.
 */
public class LongestCommonSubsequence {

   static int LCSHelperRecursive(String A, String B, int i, int j){
      if(i == -1 || j == -1){
         return 0;
      }
      if(A.charAt(i) == B.charAt(j)){
         return 1 + LCSHelperRecursive(A, B, i-1, j-1);
      }
      return Math.max(LCSHelperRecursive(A, B , i-1, j), LCSHelperRecursive(A, B, i, j-1));
   }

   static int LCSHelperDP(String A, String B){
      int[][] LCS = new int[A.length()+1][B.length()+1];
      for(int i=0;i<=A.length();i++){
         LCS[i][0] = 0;
      }
      for(int j=0;j<=B.length();j++){
         LCS[0][j] = 0;
      }

      for(int i=1;i<=A.length();i++){
         for(int j = 1;j<=B.length();j++){
            if(A.charAt(i-1) == B.charAt(j-1)){
               LCS[i][j] = 1 + LCS[i-1][j-1];
            }
            else {
               LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
            }
         }
      }

      // print LCS string
      int i=A.length(), j=B.length();
      while(i>0 && j>0){
         if(A.charAt(i-1) == B.charAt(j-1)){
            System.out.print(A.charAt(i-1));
            i = i-1;
            j = j-1;
         }else {
            if(LCS[i][j-1] > LCS[i-1][j]){
               j = j-1;
            } else{
               i = i-1;
            }
         }
      }

      System.out.println();
      for( i=0;i<=A.length();i++){
         for(j=0;j<=B.length();j++){
            if(i == 0 && j == 0){
               System.out.print("0 ");
            }
            else if(i == 0){
               System.out.print(B.charAt(j-1)+" ");
            }
            else if(j == 0){
               System.out.print(A.charAt(i-1)+" ");
            } else{
               System.out.print(LCS[i][j]+" ");
            }
         }
         System.out.println();
      }

      return LCS[A.length()][B.length()];
   }

   public static void main(String[] args) {
      String A = "AGTXYBR";
      String B = "GGXTARYB";

      System.out.println(LCSHelperRecursive(A, B, A.length()-1, B.length()-1));
      System.out.println(LCSHelperDP(A, B));
   }
}
