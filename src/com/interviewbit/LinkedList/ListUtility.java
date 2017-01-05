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

import java.util.List;

/**
 * Created by Aakash on 14-Sep-16.
 */
public class ListUtility {
   
   public static ListNode buildList(List<Integer> list){
      ListNode head = null, prev = null;
      
      for(Integer i : list){
         ListNode curr = new ListNode(i);
         if(prev == null){
            head = curr;
         } else {
            prev.next = curr;
         }
         prev = curr;
      }
      return head;
   }

   public static boolean isListEqual(ListNode l1, ListNode l2){
      System.out.println("\nComparing \n L1 :");
      l1.printList();
      System.out.println("\nL2");
      l2.printList();
      while(l1 != null && l2 != null){
         if(l1.val != l2.val){
            return false;
         }
         l1 = l1.next;
         l2 = l2.next;
      }
      if(l1!=null || l2!=null){
         return false;
      }
      return true;
   }
}
