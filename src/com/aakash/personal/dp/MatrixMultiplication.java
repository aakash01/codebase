package com.aakash.personal.dp;

/**
 * Created by a0n007d on 05/02/17.
 */
public class MatrixMultiplication {

   static int matMulHelper(int[] a, int i, int j){
      int minCount = Integer.MAX_VALUE;
      if(i == j){
         return 0;
      }
      for(int k=i;k<j;k++){
         int count = matMulHelper(a, i, k) + matMulHelper(a, k+1, j)
                        + a[i-1]*a[k]*a[j];
         if(count < minCount){
            minCount = count;
         }
      }
      return minCount;
   }

   public static void main(String[] args) {
      int arr[] = {40, 20, 30, 10, 30};
      System.out.println(matMulHelper(arr, 1, 4));
   }

}
