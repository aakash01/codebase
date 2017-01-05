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
public class ReverseMToN {

   public ListNode reverseBetween(ListNode a, int m, int n) {
      ListNode head = a, prev = null, curr = a;
      for(int i=1;i<m;i++) {
         prev = curr;
         curr = curr.next;
      }
      
      ListNode start = curr, currPrev = null;
      for(int i=m;i<=n;i++) {
         ListNode next = curr.next;
         curr.next = currPrev;
         currPrev = curr;
         curr = next;
      }
      
      if( prev != null){
         prev.next = currPrev;
      } else {
         head = currPrev;
      }
      
      start.next = curr;
      
      return head;
   }
}
