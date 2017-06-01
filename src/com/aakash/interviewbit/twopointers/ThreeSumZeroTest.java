package com.aakash.interviewbit.twopointers;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class ThreeSumZeroTest {
   
   ThreeSumZero threeSumZero;

   @Rule
   public Timeout globalTimeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      threeSumZero = new ThreeSumZero();
   }

   @After
   public void tearDown() throws Exception {
      threeSumZero =null;
   }
   
   @Test
   public void test1(){
      ArrayList<ArrayList<Integer>> output = threeSumZero.threeSum(new ArrayList<Integer>(Arrays.asList(-1,0,1,2,-1,-4)));
      ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
      expected.add(new ArrayList<Integer>(Arrays.asList(-1, -1, 2)));
      expected.add(new ArrayList<Integer>(Arrays.asList(-1, 0, 1)));
      Assert.assertEquals(expected, output);
   }

   @Test
   public void test2(){
      ArrayList<ArrayList<Integer>> output = threeSumZero.threeSum(new ArrayList<Integer>(Arrays.asList(-31013930, -31013930, 9784175, 21229755)));
      ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
      expected.add(new ArrayList<Integer>(Arrays.asList(-31013930, 9784175, 21229755)));
      Assert.assertEquals(expected, output);
   }
}