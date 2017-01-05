package com.personal;

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
   }
   
   public void print(){
      head.print();
   }
   
}