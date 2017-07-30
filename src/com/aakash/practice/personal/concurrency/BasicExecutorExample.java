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

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aakash on 11-Sep-16.
 */
public class BasicExecutorExample {

   public static void main(String[] args) {
      ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
      for (int i = 0; i <= 5; i++)
      {
         Task task = new Task("Task " + i);
         System.out.println("A new task has been added : " + task.getName());
         executor.execute(task);
      }
      executor.shutdown();
   }
   
   static class Task implements Runnable{

      private String name;

      public Task(String name)
      {
         this.name = name;
      }

      public String getName() {
         return name;
      }

      @Override
      public void run()
      {
         try
         {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Doing a task during : " + name);
            TimeUnit.SECONDS.sleep(duration);
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }
   }
}
