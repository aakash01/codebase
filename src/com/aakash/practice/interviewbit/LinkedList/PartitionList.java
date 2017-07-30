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
public class PartitionList {

   public ListNode partition(ListNode a, int b) {
      ListNode startPrev = null, start = a, curr = a;
      while(curr != null && curr.val < b){
         startPrev = curr;
         curr = curr.next;
      }
      start = curr;
      ListNode head = a;
      ListNode prev = null;
      while(curr != null){
         ListNode next = curr.next;
         if(curr.val < b){
           prev.next = curr.next;
            if(startPrev!=null){
               startPrev.next = curr;
               startPrev = curr;
            } else {
               head = curr;
               startPrev = curr;
            }
            curr.next = null;
         } else {
            prev = curr;
         }
         curr  = next;
      }
      
      if(startPrev != null){
         startPrev.next = start;
      } 
      return head;
   }
   
   public ListNode partition2(ListNode a, int b) {
      ListNode l1=null, l2 = null, l1Curr = null, l2Curr = null;
      ListNode curr = a;
      while(curr != null){
         ListNode next = curr.next;
         curr.next = null;
         if(curr.val == b){
            curr.next = l2;
            l2 = curr;
            if(l2Curr == null){
               l2Curr = l2;
            }
         } else if(curr.val > b){
            if(l2Curr != null){
               l2Curr.next = curr;
               l2Curr = curr;
            } else {
               l2Curr = l2 = curr;
            }
         } else {
            if(l1Curr != null){
               l1Curr.next = curr;
               l1Curr = curr;
            } else {
               l1Curr = l1 = curr;
            }
         }
         curr = next;
      }
      
      if(l1Curr != null){
         l1Curr.next = l2;
         return l1;
      } else {
         return l2;
      }
   }
}
