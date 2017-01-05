package com.interviewbit.string;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class JustifiedTextTest {
   
   JustifiedText justifiedText ;

   @Rule
   public Timeout timeout = new Timeout(500);
   
   @Before
   public void setUp() throws Exception {
      justifiedText= new JustifiedText();
   }

   @After
   public void tearDown() throws Exception {
      justifiedText = null;
   }
   
   @Test
   public void test1(){
      ArrayList<String> output = justifiedText.fullJustify(new ArrayList<String>(Arrays.asList(new String[]{"This", "is", "an", "example", "of", "text", "justification."})), 16);
      ArrayList<String> expected = new ArrayList<>(Arrays.asList(new String[]{"This    is    an",
                     "example  of text",
                     "justification.  "}));

      System.out.println("Output "+ output);
      System.out.println("Expected "+ expected);
   }

   @Test
   public void test2(){
      ArrayList<String> output = justifiedText.fullJustify(new ArrayList<String>(Arrays.asList(new String[]{""})), 16);
      ArrayList<String> expected = new ArrayList<>(Arrays.asList(new String[]{""}));

      System.out.println("Output "+ output);
      System.out.println("Expected "+ expected);
   }

   @Test
   public void test3(){
      ArrayList<String> output = justifiedText.fullJustify(new ArrayList<String>(Arrays.asList(new String[]{"What", "must", "be", "shall", "be." })), 12);
      ArrayList<String> expected = new ArrayList<>(Arrays.asList(new String[]{""}));

      System.out.println("Output "+ output);
      System.out.println("Expected "+ expected);
   }
}