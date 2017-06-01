package com.aakash.personal.dp;

/**
 * Created by a0n007d on 04/02/17.
 */
public class LongestIncreasingSubsequence {

   /**
    * Complexity is 2^n.
    * @param a
    * @param i
    * @param currLen
    * @param currMax
    * @return
    */
   int LISHelper(int[] a, int i, int currLen, int currMax){
      if(i== a.length){
         return currLen;
      }
      if(a[i] < currMax){
         return LISHelper(a, i+1, currLen, currMax);
      }
      return Math.max(LISHelper(a, i+1, currLen, currMax), LISHelper(a, i+1, currLen+1, a[i]));
   }

   /**
    * Using dynamic programming
    * Complexity is O(n^2)
    * @param a
    */
   int LISHelper2(int[] a){
      int[] LIS = new int[a.length];

      for(int i=0;i<a.length;i++){
         int lis_val = 0;
         for(int j=0;j<i;j++){
            if(a[i]>a[j] && LIS[j] > lis_val){
               lis_val = LIS[j];
            }
         }
         LIS[i] = lis_val + 1;
      }
      int curr_max = 0;
      for(int val : LIS){
         if(curr_max < val){
            curr_max = val;
         }
      }
      return curr_max;

   }

   public static void main(String[] args) {
      int a[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
      LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
      System.out.println("Recursive Solution Answer: "+lis.LISHelper(a, 0, 0, 0));
      System.out.println("Dynamic Programming Answer: "+lis.LISHelper2(a));

   }
}
