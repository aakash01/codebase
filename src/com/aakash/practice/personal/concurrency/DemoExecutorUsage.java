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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Aakash on 11-Sep-16.
 */
public class DemoExecutorUsage {
   
   private static ExecutorService executorService;
   private static volatile Future taskOneResult = null;
   private static volatile Future taskTwoResult = null;

   public static void main(String[] args) {
      
      executorService = Executors.newFixedThreadPool(2);
      
      while(true){
         checkTasks();
         try {
            Thread.sleep(3000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   
   static void checkTasks(){
      if(taskOneResult == null || taskOneResult.isDone() || taskOneResult.isCancelled()){
         taskOneResult = executorService.submit(new ThreadOne());
      }
      if(taskTwoResult == null || taskTwoResult.isDone() || taskTwoResult.isCancelled()){
         taskTwoResult = executorService.submit(new ThreadTwo());
      }
   }
   
   static class ThreadOne extends Thread{
      
      @Override
      public void run(){
         try {
            while(true){
               System.out.println("Executing class ThreadOne");
               Thread.sleep(2000);
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   
   static class ThreadTwo extends Thread {
      
      @Override
      public void run(){
         try {
            while(true){
               System.out.println("Executing class ThreadTwo");
               Thread.sleep(2000);
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
