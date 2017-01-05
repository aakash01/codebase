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
package com.aakash.leetcode;

/**
 * Created by Aakash on 18-Aug-16.
 */
//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
public class Problem23 {

   public ListNode mergeKLists(ListNode[] lists) {
      return mergeList(lists, 0, lists.length -1);
   }

   public ListNode mergeList(ListNode[] lists, int start, int end){
      if(start > end){
         return null;
      }
      if(start == end){
         return lists[start];
      }
      int mid = end - (end - start)/2;
      ListNode l1 = mergeList(lists, start, mid-1);
      ListNode temp = merge(l1, lists[mid]);
      ListNode l2 = mergeList(lists, mid+1, end);
      return merge(temp, l2);
      
   }
   public ListNode merge(ListNode l1, ListNode l2){
      if(l1 == null){
         return l2;
      } else if(l2 == null){
         return l1;
      }
      if(l1.val < l2.val){
         l1.next = merge(l1.next, l2);
         return l1;
      } else {
         l2.next = merge(l1, l2.next);
         return l2;
      }
   }

   public static void main(String[] args) {
      Problem23 p23 = new Problem23();
      ListNode l1 = new ListNode(-1);
      l1.next = new ListNode(5);
      l1.next.next = new ListNode(11);
      l1.print();

      ListNode l2 = new ListNode(6);
      l2.next = new ListNode(10);
      l2.print();

      ListNode[] lists = new ListNode[]{null, l1, null, l2};

      p23.mergeKLists(lists).print();
      
      
   }
   static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      
      void print(){
         System.out.print(val);
         if(null != next){
            System.out.print(" ---> ");
            next.print();
         } else {
            System.out.println();
         }
      }
   }
   
   
}
