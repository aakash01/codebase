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
package com.aakash.interviewbit.stackandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Aakash on 17-Sep-16.
 */
public class SimplifyPath {

   public String simplifyPath(String a) {
      Deque<String> queue = new ArrayDeque<>();
      for(String s : a.split("/")){
         if(".".equals(s) || s.length() == 0){
            continue;
         } else if("..".equals(s)){
            queue.pollFirst();
         } else {
            queue.push(s);
         }
      }
      StringBuilder sb = new StringBuilder();
      while(!queue.isEmpty()){
         sb.append("/").append(queue.pollLast());
      }
      if(sb.length() == 0){
         sb.append("/");
      }
      return sb.toString();
   }
   
}
