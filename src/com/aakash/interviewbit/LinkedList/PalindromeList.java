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
package com.aakash.interviewbit.LinkedList;

/**
 * Created by Aakash on 14-Sep-16.
 */
public class PalindromeList {

   public int lPalin(ListNode A) {
      ListNode slow = A, fast = A;
      while(fast.next!= null){
         fast = fast.next;
         slow = slow.next;
         if(fast.next != null){
            fast = fast.next;
         }
      }

      fast = reverseLinkedList(slow);
      slow = A;
      while(fast != null){
         if(slow.val != fast.val){
            return 0;
         }
         slow = slow.next;
         fast  = fast.next;
      }
      return 1;
   }

   private ListNode reverseLinkedList(ListNode curr){
      ListNode prev = null;
      while(curr != null){
         ListNode next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }
      return prev;
   }
   
   public int isPalindrome(ListNode head, ListNode curr){
      if(curr == null){
         return 1;
      }
      int isPalindrome = isPalindrome(head, curr.next);
      if(isPalindrome == 1 && head.next.val == curr.val){
         head.next = head.next.next;
         return 1;
      }
      return 0;
   }
}
