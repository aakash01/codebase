package com.aakash.practice.interviewbit.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 14-Sep-16.
 */
public class PalindromeListTest {
   
   PalindromeList palindromeList;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      palindromeList = new PalindromeList();
   }

   @After
   public void tearDown() throws Exception {
palindromeList = null;
   }
   
   @Test
   public void test1(){
      ListNode listNode = new ListNode(1);
      listNode.next = new ListNode(2);
      listNode.next.next = new ListNode(3);
      listNode.next.next.next = new ListNode(2);
      listNode.next.next.next.next = new ListNode(1);
      listNode.next.next.next.next.next = null;

      Assert.assertEquals(1, palindromeList.lPalin(listNode));
      
   }

   @Test
   public void test2(){
      ListNode listNode = new ListNode(1);
      listNode.next = null;
      Assert.assertEquals(1, palindromeList.lPalin(listNode));

   }

   @Test
   public void test3(){
      ListNode listNode = new ListNode(1);
      listNode.next = new ListNode(2);
      listNode.next.next = new ListNode(3);
      listNode.next.next.next = new ListNode(3);
      listNode.next.next.next.next = new ListNode(1);
      listNode.next.next.next.next.next = null;

      Assert.assertEquals(0, palindromeList.lPalin(listNode));

   }
}