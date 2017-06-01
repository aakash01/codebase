package com.aakash.personal.concurrency;

/**
 * Created by a0n007d on 25/02/17.
 */
public class Test {

   public static void main(String[] args) throws InterruptedException {

      Object lock = new Object();

      Runnable runnable = ()->{
         int k = 2;
         while(k>0){
            System.out.println("Sleeping for 5 secs");
            try {
               Thread.sleep(5000);
            } catch (InterruptedException e) {
               e.printStackTrace();
               lock.notify();
            }
            k--;

         }
      };
      Thread t = new Thread(runnable);

      TestInterface1 inf1 = ()->{
         System.out.println("Doing work 1");
      };

      Test2 tesObj = new Test2(inf1);


      System.out.println("Start thread");
      t.start();
      t.join();
      System.out.println("Main thread completed");
   }

}
