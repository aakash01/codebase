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
public class ListCycle {

   public ListNode detectCycle(ListNode a) {
      ListNode slow = a, fast = a;
      
      while(fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
         if(slow == fast){
            break;
         }
      }
      
      if(fast == null || fast.next == null){
         return null;
      }
      slow = a;
      while(slow != fast){
         fast = fast.next;
         slow = slow.next;
      }
      return slow;
   }
}
