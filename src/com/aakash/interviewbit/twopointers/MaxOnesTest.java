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
package com.aakash.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


import static org.junit.Assert.assertEquals;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class MaxOnesTest {
   
   MaxOnes maxOnes;

   @Rule
   public Timeout globalTimeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      maxOnes = new MaxOnes();
   }

   @After
   public void tearDown() throws Exception {
      maxOnes = null;
   }

   @Test
   public void Test1() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0,
                     0, 1, 1, 1));
      int b = 1;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2, 3,
                     4));
      assertEquals(expected, actual);
   }

   @Test
   public void Test2() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0,
                     0, 1, 1, 1));
      int b = 2;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 4, 5, 6,
                     7, 8, 9));
      assertEquals(expected, actual);
   }

   @Test
   public void Test3() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0,
                     0, 1, 1, 1));
      int b = 3;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2, 3,
                     4, 5, 6, 7, 8, 9));
      assertEquals(expected, actual);
   }

   @Test
   public void Test4() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 0,
                     0, 1, 1, 1));
      int b = 0;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2, 3,
                     4));
      assertEquals(expected, actual);
   }

   @Test
   public void Test5() {
      ArrayList<Integer> a = new ArrayList<Integer>(Arrays.<Integer>asList());
      int b = 0;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.<Integer>asList());
      assertEquals(expected, actual);
   }

   @Test
   public void Test6() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0));
      int b = 1;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
      assertEquals(expected, actual);
   }

   @Test
   public void Test7() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0));
      int b = 0;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.<Integer>asList());
      assertEquals(expected, actual);
   }

   @Test
   public void Test8() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0,
                     1, 0, 1, 1));
      int b = 2;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(5, 6, 7, 8,
                     9));
      assertEquals(expected, actual);
   }

   @Test
   public void Test9() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 1,
                     1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0));
      int b = 4;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(4, 5, 6, 7,
                     8, 9, 10, 11, 12, 13, 14, 15));
      assertEquals(expected, actual);
   }

   @Test
   public void Test10() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
      int b = 0;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.<Integer>asList());
      assertEquals(expected, actual);
   }

   @Test
   public void Test11() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0, 1, 1, 0, 1, 0));
      int b = 0;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
      assertEquals(expected, actual);
   }

   @Test
   public void Test12() {
      ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 0 ));
      int b = 2;
      ArrayList<Integer> actual = maxOnes.maxone(a, b);
      ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2));
      assertEquals(expected, actual);
   }
}
