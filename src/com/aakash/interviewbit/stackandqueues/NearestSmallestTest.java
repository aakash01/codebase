package com.aakash.interviewbit.stackandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class NearestSmallestTest {
   
   NearestSmallest nearestSmallest;

   @Rule
   public Timeout timeout = new Timeout(500);
   @Before
   public void setUp() throws Exception {
      nearestSmallest = new NearestSmallest();
   }

   @After
   public void tearDown() throws Exception {
      nearestSmallest = null;
   }
   
   @Test
   public void test1(){
      Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(new Integer[]{-1, 4, -1, 2})), nearestSmallest.prevSmaller(new ArrayList<Integer>(Arrays.asList(new Integer[]{4, 5, 2, 10}))));
   }

   @Test
   public void test2(){
      Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(new Integer[]{-1,-1,-1})), nearestSmallest.prevSmaller(new ArrayList<Integer>(Arrays.asList(new Integer[]{3,2,1}))));
   }

   @Test
   public void test3(){
      Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(new Integer[]{-1, 8, 8, 8, 16, -1, -1, 7, 27, 7, 27, 7, -1, -1, 1, 1, 1, 1, 6, 16, 26, 26})), 
                     nearestSmallest.prevSmaller(new ArrayList<Integer>(Arrays.asList(new Integer[]{8, 23, 22, 16, 22, 7, 7, 27, 35, 27, 32, 20, 5, 1, 35, 28, 20, 6, 16, 26, 48, 34}))));
   }
}