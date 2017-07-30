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

/**
 * Created by Aakash on 19-Sep-16.
 */
public class ProducerConsumer {

   public static void main(String[] args) {
      
      List<Integer> integers = new ArrayList<>();
      
      Producer<Integer> producerImplInteger = new Producer<Integer>(integers, 5){
         int count = 0;
         @Override
         protected Integer getData() {
            count++;
            System.out.println("Produced "+count);
            return count;
         }
      };
      
      Consumer<Integer> consumerImplInteger = new Consumer<Integer>(integers, 5) {
         @Override
         protected void consumeData(Integer data) {
            System.out.println("Consumed "+data);
         }
      };
      
      Thread t1 = new Thread(producerImplInteger);
      Thread t2 = new Thread(consumerImplInteger);
       t1.start();
      t2.start();

      List<String> strings = new ArrayList<>();

      Producer<String> producerImplString = new Producer<String>(strings, 5){
         StringBuilder sb = new StringBuilder();
         int count = 0;
         @Override
         protected String getData() {
            sb.append((char)count);
            count++;
            System.out.println("Produced "+sb.toString());
            return sb.toString();
         }
      };

      Consumer<String> consumerImplString = new Consumer<String>(strings, 5) {
         @Override
         protected void consumeData(String data) {
            System.out.println("Consumed "+data);
         }
      };

      Thread t3 = new Thread(producerImplString);
      Thread t4 = new Thread(consumerImplString);
      t3.start();
      t4.start();
   }
   
   
  static abstract class Producer<T> implements Runnable {
     
     private final List<T> queue;
     private final int maxCount;

     public Producer(List<T> queue, int maxCount) {
        this.queue = queue;
        this.maxCount = maxCount;
     }

     @Override
     public void run() {
        while(true){
           T data = getData();
           try {
              produce(data);
              Thread.sleep(1000);
           } catch (InterruptedException e) {
              e.printStackTrace();
           }
        }
     }

     protected abstract T getData();


     private void produce(T data) throws InterruptedException {
        synchronized (queue){
            while(queue.size() == maxCount){
               queue.wait();
            }
           queue.add(data);
           queue.notifyAll();
        }
     }
  }

   static abstract class Consumer<T> implements Runnable {

      private final List<T> queue;
      private final int maxCount;

      public Consumer(List<T> queue, int maxCount) {
         this.queue = queue;
         this.maxCount = maxCount;
      }

      @Override
      public void run() {
         while(true){
            try {
            T data = consume();
              consumeData(data);
               Thread.sleep(3000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }

      protected abstract void consumeData(T data);


      private T consume() throws InterruptedException {
         synchronized (queue){
            while(queue.size() == 0){
               queue.wait();
            }
            T data = queue.remove(0);
            queue.notifyAll();
            return data;
         }
      }
      
      
   }

}
