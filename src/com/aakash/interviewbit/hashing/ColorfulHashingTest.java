package com.aakash.interviewbit.hashing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class ColorfulHashingTest {
   
   ColorfulHashing colorfulHashing;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      colorfulHashing =  new ColorfulHashing();
   }

   @After
   public void tearDown() throws Exception {
      colorfulHashing = null;
   }
   
   @Test
   public void test1(){
      Assert.assertEquals(1, colorfulHashing.colorful(3245));
   }

   @Test
   public void test2(){
      Assert.assertEquals(0, colorfulHashing.colorful(3246));
   }
   
   @Test
   public void test3(){
      Assert.assertEquals(1, colorfulHashing.colorful(23));
   }

   @Test
   public void test4(){
      Assert.assertEquals(0, colorfulHashing.colorful(123456789));
   }

   @Test
   public void test5(){
      Assert.assertEquals(1, colorfulHashing.colorful(263));
   }
   
}