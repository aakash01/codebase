package com.aakash.interviewbit.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 14-Sep-16.
 */
public class ListCycleTest {
   
   ListCycle listCycle;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      listCycle = new ListCycle();
   }

   @After
   public void tearDown() throws Exception {
      listCycle = null;
   }
   
   @Test
   public void test1(){
      ListNode listNode = new ListNode(1);
      listNode.next = new ListNode(2);
      ListNode cyclicNode = listNode.next.next = new ListNode(3);
      listNode.next.next.next = new ListNode(4);
      listNode.next.next.next.next = new ListNode(5);
      listNode.next.next.next.next.next = cyclicNode;

      Assert.assertEquals(cyclicNode, listCycle.detectCycle(listNode));
   }

   @Test
   public void test2(){
      ListNode listNode = new ListNode(1);
      listNode.next = new ListNode(2);
      listNode.next.next = new ListNode(3);
      listNode.next.next.next = new ListNode(4);
      listNode.next.next.next.next = new ListNode(5);
      listNode.next.next.next.next.next = null;

      Assert.assertEquals(null, listCycle.detectCycle(listNode));
   }
   
}