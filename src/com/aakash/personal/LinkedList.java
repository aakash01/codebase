package com.aakash.personal;

import java.util.Random;
import java.util.StringJoiner;

public class LinkedList {
   
   Node head;
   
   public static class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }

      public void print(){
         StringJoiner sj = new StringJoiner(" ---> ", "[", "]");
         Node temp = this;
         while(temp != null){
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
         }
         System.out.println(sj.toString());
      }

      public Node next(int data){
         Node next = new Node(data);
         this.next = next;
         return next;
      }
   }

   public static class RandomNode {
      int data;
      RandomNode next;
      RandomNode random;

      public RandomNode(int data) {
         this.data = data;
      }

      public void print(){
         StringJoiner sj = new StringJoiner(" ---> ", "[", "]");
         RandomNode temp = this;
         while(temp != null){
            sj.add(String.valueOf(temp.data) + (null != temp.random ? "("+temp.random.data+")" : "()"));
            temp = temp.next;
         }
         System.out.println(sj.toString());
      }

      public RandomNode next(int data){
         RandomNode next = new RandomNode(data);
         this.next = next;
         return next;
      }
   }
   
   public void print(){
      head.print();
   }
   
}