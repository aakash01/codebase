package com.aakash.practice.interviewbit.stackandqueues;

import org.junit.*;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class EvaluateExpressionTest {
   
   EvaluateExpression evaluateExpression;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      evaluateExpression = new EvaluateExpression();
   }

   @After
   public void tearDown() throws Exception {
      evaluateExpression = null;
   }
   
   @Test
   public void test1(){
      Assert.assertEquals(9, evaluateExpression.evalRPN(new ArrayList<String>(Arrays.asList(new String[]{"2", "1", "+", "3", "*"}))));
   }

   @Test
   public void test2(){
      Assert.assertEquals(6, evaluateExpression.evalRPN(new ArrayList<String>(Arrays.asList(new String[]{"4", "13", "5", "/", "+"}))));
   }
}