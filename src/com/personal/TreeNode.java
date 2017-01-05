package com.personal;/*
 * This computer program is the confidential information and proprietary trade
 * secret of Anuta Networks, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and
 * Anuta Networks, Inc., and receipt or possession does not convey any rights
 * to divulge, reproduce, or allow others to use this program without specific
 * written authorization of Anuta Networks, Inc.
 * 
 * Copyright (c) 2011-2012 Anuta Networks, Inc. All Rights Reserved.
 */

/**
 * Created by Aakash on 02-Aug-16.
 */
public class TreeNode {
   int data;
   TreeNode left;
   TreeNode right;

   public TreeNode(int data) {
      this.data = data;
   }
   
   void print(){
      System.out.print("(");
      if(left == null){
         System.out.print(" - ");
      } else {
         left.print();
      }
      System.out.print(" "+data+" ");
      if(right == null){
         System.out.print(" - ");
      } else {
         right.print();
      }
      System.out.print(")");
   }
   
   
}
