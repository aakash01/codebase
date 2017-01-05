package com.aakash.interviewbit.hashing;

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
public class AnagramsTest {
   
   @Rule
   public Timeout timeout = new Timeout(500);
   
   Anagrams anagrams;
   
      @Before
      public void setUp() throws Exception {
         anagrams =  new Anagrams();
      }
   
      @After
      public void tearDown() throws Exception {
         anagrams = null;
      }
   
   
   @Test
   public void test1(){
      Assert.assertEquals(new ArrayList<ArrayList<Integer>>(){{
         add(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,4})));
         add(new ArrayList<Integer>(Arrays.asList(new Integer[]{2,3})));
      }}, anagrams.anagrams(new ArrayList<String>(Arrays.asList(new String[]{ "cat", "dog", "god", "tca"}))));
   }

}