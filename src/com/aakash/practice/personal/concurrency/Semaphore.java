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
package com.aakash.practice.personal.concurrency;

/**
 * Created by Aakash on 15-Sep-16.
 */
public class Semaphore {
   
   private boolean signal = false;
   
   public synchronized void acquire() throws InterruptedException {
      while(signal){
         wait();
      }
      signal = true;
      notifyAll();
   }
   
   public synchronized void release() throws InterruptedException {
      while(!signal){
         wait();
      }
      signal  = false;
      notifyAll();
   }
}
