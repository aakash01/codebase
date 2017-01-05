package com.aakash.interviewbit.string;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class LongestPalindromeTest {
   
   LongestPalindrome longestPalindrome;
   
   @Rule
   public Timeout timeout = new Timeout(500);

   @Before
   public void setUp() throws Exception {
      longestPalindrome = new LongestPalindrome();
   }

   @After
   public void tearDown() throws Exception {
      longestPalindrome = null;
   }
   
   @Test
   public void test1(){
      Assert.assertEquals("a", longestPalindrome.longestPalindrome("abcd"));
   }

   @Test
   public void test2(){
      Assert.assertEquals("bb", longestPalindrome.longestPalindrome("abbcd"));
   }

   @Test
   public void test3(){
      Assert.assertEquals("aba", longestPalindrome.longestPalindrome("aba"));
   }

   @Test
   public void test4(){
      Assert.assertEquals("abba", longestPalindrome.longestPalindrome("abba"));
   }

   @Test
   public void test5(){
      Assert.assertEquals("abba", longestPalindrome.longestPalindrome("aaabbad"));
   }

   @Test
   public void test6(){
      Assert.assertEquals("aaabaaa", longestPalindrome.longestPalindrome("aaaabaaa"));
   }
}