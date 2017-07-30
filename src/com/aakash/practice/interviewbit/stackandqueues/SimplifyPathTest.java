package com.aakash.practice.interviewbit.stackandqueues;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class SimplifyPathTest {
   
   SimplifyPath simplifyPath;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
simplifyPath = new SimplifyPath();
   }

   @After
   public void tearDown() throws Exception {
simplifyPath = null;
   }
   
   @Test
   public void test1(){
      Assert.assertEquals("/home", simplifyPath.simplifyPath("/home/"));
   }

   @Test
   public void test2(){
      Assert.assertEquals("/c", simplifyPath.simplifyPath("/a/./b/../../c/"));
   }

   @Test
   public void test3(){
      Assert.assertEquals("/a/c", simplifyPath.simplifyPath("/a/d/b/../../c/"));
   }

   @Test
   public void test4(){
      Assert.assertEquals("/", simplifyPath.simplifyPath("/../"));
   }
}