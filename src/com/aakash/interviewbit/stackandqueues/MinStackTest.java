package com.aakash.interviewbit.stackandqueues;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class MinStackTest {
   
   MinStack minStack;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      minStack = new MinStack();
   }

   @After
   public void tearDown() throws Exception {
      minStack = null;
   }
   
   @Test
   public void test1(){
      minStack.push(5);
      minStack.push(4);
      Assert.assertEquals(4, minStack.getMin());
      minStack.push(7);
      Assert.assertEquals(4, minStack.getMin());
      Assert.assertEquals(7, minStack.top());
      minStack.pop();
      minStack.push(2);
      minStack.push(2);
      Assert.assertEquals(2, minStack.getMin());
      minStack.pop();
      Assert.assertEquals(2, minStack.getMin());
   }
}