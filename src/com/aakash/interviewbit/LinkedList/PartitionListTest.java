package com.aakash.interviewbit.LinkedList;

import org.junit.*;
import org.junit.rules.Timeout;

import java.util.Arrays;

/**
 * Created by Aakash on 14-Sep-16.
 */
public class PartitionListTest {
   
   PartitionList partitionList;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      partitionList = new PartitionList();
   }

   @After
   public void tearDown() throws Exception {
      partitionList = null;
   }
   
   @Test
   public void test1(){
      ListNode l1 = ListUtility.buildList(Arrays.asList(new Integer[]{5,2,1,6}));
      ListNode l2 = ListUtility.buildList(Arrays.asList(new Integer[]{1,5,2,6}));

      Assert.assertTrue(ListUtility.isListEqual(l2, partitionList.partition(l1, 2)));
   }

   @Test
   public void test2(){
      ListNode l1 = ListUtility.buildList(Arrays.asList(new Integer[]{5,2,1,6}));
      ListNode l2 = ListUtility.buildList(Arrays.asList(new Integer[]{5,2,1,6}));

      Assert.assertTrue(ListUtility.isListEqual(l2, partitionList.partition(l1, 1)));
   }

   @Test
   public void test3(){
      ListNode l1 = ListUtility.buildList(Arrays.asList(new Integer[]{5,2,1,6}));
      ListNode l2 = ListUtility.buildList(Arrays.asList(new Integer[]{5,2,1,6}));

      Assert.assertTrue(ListUtility.isListEqual(l2, partitionList.partition(l1, 6)));
   }

   @Test
   public void test4(){
      ListNode l1 = ListUtility.buildList(Arrays.asList(new Integer[]{5,2,1,3,6}));
      ListNode l2 = ListUtility.buildList(Arrays.asList(new Integer[]{2,1,5,3, 6}));

      Assert.assertTrue(ListUtility.isListEqual(l2, partitionList.partition(l1, 3)));
   }
}