package com.interviewbit.string;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class StrStrTest {
   
   StrStr strStr;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      strStr = new StrStr();
   }

   @After
   public void tearDown() throws Exception {
      strStr = null;
   }
   
   @Test
   public void test1(){
      Assert.assertEquals(-1, strStr.strStr(null, null));
   }

   @Test
   public void test2(){
      Assert.assertEquals(-1, strStr.strStr("", "aakash"));
   }

   @Test
   public void test3(){
      Assert.assertEquals(-1, strStr.strStr("aakash", "aakashaakash"));
   }

   @Test
   public void test4(){
      Assert.assertEquals(-1, strStr.strStr("abcd", "abd"));
   }

   @Test
   public void test5(){
      Assert.assertEquals(2, strStr.strStr("abcdefg", "cde"));
   }

   @Test
   public void test6(){
      Assert.assertEquals(4, strStr.strStr("abcdefg", "efg"));
   }

   @Test
   public void test7(){
      Assert.assertEquals(0, strStr.strStr("aakash", "aakash"));
   }

   @Test
   public void test8(){
      Assert.assertEquals(1, strStr.strStr("aaabbddd", "aabbd"));
   }

   @Test
   public void test9(){
      Assert.assertEquals(1, strStr.strStr("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
   }
}