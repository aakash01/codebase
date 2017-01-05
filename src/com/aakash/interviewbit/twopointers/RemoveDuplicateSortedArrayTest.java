package com.aakash.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class RemoveDuplicateSortedArrayTest {
   
   RemoveDuplicateSortedArray removeDuplicateSortedArray;


   @Rule
   public Timeout globalTimeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      removeDuplicateSortedArray = new RemoveDuplicateSortedArray();
   }

   @After
   public void tearDown() throws Exception {
      removeDuplicateSortedArray = null;
   }

   
   @Test
   public void test1(){
      int output = removeDuplicateSortedArray.removeDuplicates(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3})));
      int output2 = removeDuplicateSortedArray.removeDuplicatesArrayChange(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3})));
      Assert.assertEquals(3, output);
      Assert.assertEquals(3, output2);
   }

   @Test
   public void test2(){
      int output = removeDuplicateSortedArray.removeDuplicates(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,3})));
      int output2 = removeDuplicateSortedArray.removeDuplicatesArrayChange(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,3})));
      Assert.assertEquals(2, output);
      Assert.assertEquals(2, output2);
   }

   @Test
   public void test3(){
      int output = removeDuplicateSortedArray.removeDuplicates(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1})));
      int output2 = removeDuplicateSortedArray.removeDuplicatesArrayChange(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1})));
      Assert.assertEquals(1, output);
      Assert.assertEquals(1, output2);
   }

   @Test
   public void test4(){
      int output = removeDuplicateSortedArray.removeDuplicates(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1,2,2,3,3,4})));
      int output2 = removeDuplicateSortedArray.removeDuplicatesArrayChange(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,1,2,2,3,3,4})));
      Assert.assertEquals(4, output);
      Assert.assertEquals(4, output2);
   }

   @Test
   public void test5(){
      int output = removeDuplicateSortedArray.removeDuplicates(new ArrayList<Integer>(Arrays.asList(new Integer[]{5000, 5000, 5000})));
      int output2 = removeDuplicateSortedArray.removeDuplicatesArrayChange(new ArrayList<Integer>(Arrays.asList(new Integer[]{5000, 5000, 5000})));
      Assert.assertEquals(1, output);
      Assert.assertEquals(1, output2);
   }

   @Test
   public void test6(){
      int output = removeDuplicateSortedArray.removeDuplicates(new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3})));
      int output2 = removeDuplicateSortedArray.removeDuplicatesArrayChange(new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3})));
      Assert.assertEquals(4, output);
      Assert.assertEquals(4, output2);
   }
   
   
}