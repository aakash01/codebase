package com.interviewbit.string;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class LastWordLengthTest {
   
   LastWordLength lwLength;

   @Before
   public void setUp() throws Exception {
      lwLength = new LastWordLength();
   }

   @After
   public void tearDown() throws Exception {
      lwLength = null;
   }
   
   @Test
   public void test1(){
      int output = lwLength.lengthOfLastWord("Hello World");
      Assert.assertEquals(5, output);
   }

   @Test
   public void test2(){
      int output = lwLength.lengthOfLastWord("Hello World         ");
      Assert.assertEquals(5, output);
   }

   @Test
   public void test3(){
      int output = lwLength.lengthOfLastWord("   HelloWorld            ");
      Assert.assertEquals(10, output);
   }

   @Test
   public void test4(){
      int output = lwLength.lengthOfLastWord("        ");
      Assert.assertEquals(0, output);
   }
}