/*
 * This computer program is the confidential information and proprietary trade
 * secret of Anuta Networks, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and
 * Anuta Networks, Inc., and receipt or possession does not convey any rights
 * to divulge, reproduce, or allow others to use this program without specific
 * written authorization of Anuta Networks, Inc.
 * 
 * Copyright (c) 2011-2012 Anuta Networks, Inc. All Rights Reserved.
 */
package com.aakash.interviewbit.string;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class CompareVersionTest {
   
   CompareVersions compareVersions;


   @Rule
   public Timeout globalTimeout = new Timeout(500);
   
   @Before
   public void setUp(){
      compareVersions = new CompareVersions();
   }
   
   @After
   public void tearDown(){
      compareVersions = null;
   }
   
   @Test
   public void test1(){
      int output = compareVersions.compareVersion("0.1", "1.1");
      Assert.assertEquals(-1, output);
   }

   @Test
   public void test2(){
      int output = compareVersions.compareVersion("1.13.4", "1.13");
      Assert.assertEquals(1, output);
   }

   @Test
   public void test3(){
      int output = compareVersions.compareVersion("14.0.4.2", "1");
      Assert.assertEquals(1, output);
   }

   @Test
   public void test4(){
      int output = compareVersions.compareVersion("14.0.4.2", "14.0.4.2");
      Assert.assertEquals(0, output);
   }

   @Test
   public void test5(){
      int output = compareVersions.compareVersion("1.0", "1");
      Assert.assertEquals(0, output);
   }

   @Test
   public void test6(){
      int output = compareVersions.compareVersion("4444371174137455", "5.168");
      Assert.assertEquals(1, output);
   }

   @Test
   public void test7(){
      int output = compareVersions.compareVersion("1.001", "1.1");
      Assert.assertEquals(0, output);
   }


   @Test
   public void test8(){
      int output = compareVersions.compareVersion("2", "4");
      Assert.assertEquals(-1, output);
   }
}
