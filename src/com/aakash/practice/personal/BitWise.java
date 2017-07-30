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
package com.aakash.practice.personal;

/**
 * Created by Aakash on 03-Sep-16.
 */
public class BitWise {

   public static void main(String[] args) {
      System.out.println("isPowerOf2  5  --  "+isPowerOf2(5));
      System.out.println("isPowerOf2  8  --  " + isPowerOf2(8));
      
      System.out.println("noOfSetBits  5  --  "+noOfSetBits(5));
      System.out.println("noOfSetBits  8  --  " + noOfSetBits(8));
      
      System.out.println("isEven  5  --  "+isEven(5));
      System.out.println("isEven  8  --  " + isEven(8));
      
      System.out.println("isKSet  50("+Integer.toBinaryString(50)+") 5  --  "+isKSet(50, 5));
      System.out.println("isKSet  133("+Integer.toBinaryString(133)+") 4  --  "+isKSet(133, 4));
      
      System.out.println("setKthBit  50("+Integer.toBinaryString(50)+") 5  --  "+setKthBit(50, 5)+" ("+Integer.toBinaryString(setKthBit(50, 5))+")");
      System.out.println("setKthBit  133("+Integer.toBinaryString(133)+") 4  --  "+setKthBit(133, 4)+" ("+Integer.toBinaryString(setKthBit(133, 4))+")");

      System.out.println("unsetKthBit  50("+Integer.toBinaryString(50)+") 5  --  "+unsetKthBit(50, 5)+" ("+Integer.toBinaryString(unsetKthBit(50, 5))+")");
      System.out.println("unsetKthBit  133("+Integer.toBinaryString(133)+") 4  --  "+unsetKthBit(133, 4)+" ("+Integer.toBinaryString(unsetKthBit(133, 4))+")");

      System.out.println("unsetKthBit2  50("+Integer.toBinaryString(50)+") 5  --  "+unsetKthBit2(50, 5)+" ("+Integer.toBinaryString(unsetKthBit2(50, 5))+")");
      System.out.println("unsetKthBit2  133("+Integer.toBinaryString(133)+") 4  --  "+unsetKthBit2(133, 4)+" ("+Integer.toBinaryString(unsetKthBit2(133, 4))+")");

      System.out.println("toggleKthBit  50("+Integer.toBinaryString(50)+") 5  --  "+toggleKthBit(50, 5)+" ("+Integer.toBinaryString(toggleKthBit(50, 5))+")");
      System.out.println("toggleKthBit  133("+Integer.toBinaryString(133)+") 4  --  "+toggleKthBit(133, 4)+" ("+Integer.toBinaryString(toggleKthBit(133, 4))+")");

      System.out.println("isolateRightMostOne  50("+Integer.toBinaryString(50)+")  --  "+ isolateRightMostOne(50)+" ("+Integer.toBinaryString(
                     isolateRightMostOne(50))+")");
      System.out.println("isolateRightMostOne  133("+Integer.toBinaryString(133)+")  --  "+ isolateRightMostOne(133)+" ("+Integer.toBinaryString(
                     isolateRightMostOne(133))+")");

      System.out.println("isolateRightMostZero  50("+Integer.toBinaryString(50)+")  --  "+ isolateRightMostZero(50)+" ("+Integer.toBinaryString(
                     isolateRightMostZero(50))+")");
      System.out.println("isolateRightMostZero  133("+Integer.toBinaryString(133)+")  --  "+ isolateRightMostZero(133)+" ("+Integer.toBinaryString(
                     isolateRightMostZero(133))+")");

}
   
   // to check if number is power of 2
   public static boolean isPowerOf2(int n){
      return n != 0 && ((n & (n-1))== 0);
   }
   
   // count number of set bits
   public static int noOfSetBits(int n){
      int count = 0;
      while(n!=0){
         count++;
         n = n & n-1;
      }
      return count;
   }
   
   //check if even or odd
   public static boolean isEven(int n){
      return (n&1) == 0;
   }
   
   // check if kth bit is set
   public static boolean isKSet(int n, int k){
      return (n & (1 << k)) != 0;
   }
   
   // set kth bit
   public static int setKthBit(int n, int k){
      return n | (1<<k-1);
   }
   
   // unset kth bit
   public static int unsetKthBit(int n, int k){
      return n & (n ^ (1 << k-1));
   }

   // unset kth bit
   public static int unsetKthBit2(int n, int k){
      return n & ~(1<<k-1);
   }
   
   // toggle kth bit
   public static int toggleKthBit(int n, int k){
      return n ^ (1 << k-1);
   }
   
   //isolate rightmost set bit
   public static int isolateRightMostOne(int n){
      return ~(n-1) & n;
   }

   //isolate rightmost unset bit
   // Eg: 10101011 --->  000000100
   public static int isolateRightMostZero(int n){
      return (n+1) & ~n;
   }

   /**
    * In two's complement system , 
    * -x =  ~x + 1
    */
}
