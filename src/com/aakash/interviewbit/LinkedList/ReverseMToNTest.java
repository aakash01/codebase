package com.aakash.interviewbit.LinkedList;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 14-Sep-16.
 */
public class ReverseMToNTest {
   
   ReverseMToN reverseMToN;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      reverseMToN =  new ReverseMToN();
   }

   @After
   public void tearDown() throws Exception {
      reverseMToN = null;
   }
   
   @Test
   public void test1(){
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(3);
      l1.next.next.next = new ListNode(4);
      l1.next.next.next.next = new ListNode(5);


      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(4);
      l2.next.next = new ListNode(3);
      l2.next.next.next = new ListNode(2);
      l2.next.next.next.next = new ListNode(5);


      Assert.assertTrue(isListEqual(reverseMToN.reverseBetween(l1, 2, 4), l2));
   }

   @Test
   public void test2(){
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(3);
      l1.next.next.next = new ListNode(4);
      l1.next.next.next.next = new ListNode(5);


      ListNode l2 = new ListNode(5);
      l2.next = new ListNode(4);
      l2.next.next = new ListNode(3);
      l2.next.next.next = new ListNode(2);
      l2.next.next.next.next = new ListNode(1);


      Assert.assertTrue(isListEqual(reverseMToN.reverseBetween(l1, 1, 5), l2));
   }

   @Test
   public void test3(){
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(3);
      l1.next.next.next = new ListNode(4);
      l1.next.next.next.next = new ListNode(5);


      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(2);
      l2.next.next = new ListNode(3);
      l2.next.next.next = new ListNode(4);
      l2.next.next.next.next = new ListNode(5);


      Assert.assertTrue(isListEqual(reverseMToN.reverseBetween(l1, 1, 1), l2));
   }

   @Test
   public void test4(){
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(3);
      l1.next.next.next = new ListNode(4);
      l1.next.next.next.next = new ListNode(5);


      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(2);
      l2.next.next = new ListNode(3);
      l2.next.next.next = new ListNode(4);
      l2.next.next.next.next = new ListNode(5);


      Assert.assertTrue(isListEqual(reverseMToN.reverseBetween(l1, 5, 5), l2));
   }

   private boolean isListEqual(ListNode l1, ListNode l2){
      while(l1 != null && l2 != null){
         if(l1.val != l2.val){
            System.out.println("L1  "+l1.val+" L2 : "+l2.val);
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