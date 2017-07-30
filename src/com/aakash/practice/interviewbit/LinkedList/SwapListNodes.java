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
package com.aakash.practice.interviewbit.LinkedList;

/**
 * Created by Aakash on 14-Sep-16.
 */
public class SwapListNodes {
   
   public ListNode swapInPairs(ListNode listNode){
      ListNode prev = null, head = listNode;
      ListNode curr = listNode;
      while(curr != null){
         
         if(curr.next != null) {
            ListNode next = curr.next.next;
            curr.next.next = curr;
            if (null != prev) {
               prev.next = curr.next;
            } else {
               head = curr.next;
            }
            curr.next = null;
            prev = curr;
            curr = next;
         }else {
            if (null != prev) {
               prev.next = curr;
            }
            curr = curr.next;
         }
      }
      
      return head;
   }
}
