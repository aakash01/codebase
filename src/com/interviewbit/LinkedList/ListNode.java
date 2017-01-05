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
package com.interviewbit.LinkedList;

/**
 * Created by Aakash on 14-Sep-16.
 */
public class ListNode {
   public int val;
   public ListNode next;

   public ListNode(int val) {
      this.val = val;
   }

   @Override
   public String toString() {
      return val +" ";
   }
   
   public void printList(){
      System.out.print(val+" --> ");
      if(null != next){
         next.printList();
      } else {
         System.out.print("null");
      }
   }
}
