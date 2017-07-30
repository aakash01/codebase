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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Aakash on 11-Sep-16.
 */
public class CallableExample {

   public static void main(String[] args) {
      ExecutorService executorService = Executors.newFixedThreadPool(2);
      
      List<Future<Integer>> results = new ArrayList<>();
      Random random = new Random();
      for(int i=0;i<4;i++){
         results.add(executorService.submit(new FactorialCalculator(random.nextInt(20))));
      }
      
      for(Future result : results){
         try {
            System.out.println("Ans is "+result.get()+" is TaskDone "+result.isDone());
         } catch (InterruptedException e) {
            e.printStackTrace();
         } catch (ExecutionException e) {
            e.printStackTrace();
         }
      }
   }
   
   static class FactorialCalculator implements Callable<Integer> {
      
      int n;

      public FactorialCalculator(int n) {
         this.n = n;
      }

      @Override
      public Integer call() throws Exception {
         System.out.println("Calculating factorial of "+n);
         return calculateFactorial(n);
      }

      private Integer calculateFactorial(int n) throws InterruptedException {
         if(n == 1 || n == 0){
            return 1;
         }
         Thread.sleep(1000);
         return n * calculateFactorial(n-1);
      }
   }
}
