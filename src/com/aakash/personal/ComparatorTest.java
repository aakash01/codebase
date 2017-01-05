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
package com.aakash.personal;

import java.util.Scanner;

/**
 * Created by Aakash on 31-Aug-16.
 */
class ComparatorTest {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      Comparator comp = new Comparator();

      int testCases = Integer.parseInt(scan.nextLine());
      while(testCases-- > 0){
         int condition = Integer.parseInt(scan.nextLine());
         switch(condition){
         case 1:
            String s1=scan.nextLine().trim();
            String s2=scan.nextLine().trim();

            System.out.println( (comp.compare(s1,s2)) ? "Same" : "Different" );
            break;
         case 2:
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();

            System.out.println( (comp.compare(num1,num2)) ? "Same" : "Different");
            if(scan.hasNext()){ // avoid exception if this last test case
               scan.nextLine(); // eat space until next line
            }
            break;
         case 3:
            // create and fill arrays
            int[] array1 = new int[scan.nextInt()];
            int[] array2 = new int[scan.nextInt()];
            for(int i = 0; i < array1.length; i++){
               array1[i] = scan.nextInt();
            }
            for(int i = 0; i < array2.length; i++){
               array2[i] = scan.nextInt();
            }

            System.out.println( comp.compare(array1, array2) ? "Same" : "Different");
            if(scan.hasNext()){ // avoid exception if this last test case
               scan.nextLine(); // eat space until next line
            }
            break;
         default:
            System.err.println("Invalid input.");
         }// end switch
      }// end while
      scan.close();
   }
   static class Comparator {
      boolean compare(int a, int b) {
         return a == b;
      }

      boolean compare(String a, String b) {
         if (a == null && b == null) {
            return true;
         } else if (a == null || b == null) {
            return false;
         } else {
            return a.equals(b);
         }
      }

      boolean compare(int[] a, int[] b) {
         if (a == null && b == null) {
            return true;
         } else if (a == null || b == null || a.length != b.length) {
            return false;
         } else {
            for (int i = 0; i < a.length; i++) {
               if (a[i] != b[i]) {
                  return false;
               }
            }
            return true;
         }
      }
   }
}
