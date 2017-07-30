package com.aakash.practice.personal.concurrency;

/**
 * Created by a0n007d on 25/02/17.
 */
public class Test2 {

   public Test2(TestInterface1 interface1){
      System.out.println("Initialize iwth interface 1");
      interface1.someWork();
   }

   public Test2(TestInterface2 interface2){
      System.out.println("Initialized with interface 2");
      interface2.someWork2();
   }
}
