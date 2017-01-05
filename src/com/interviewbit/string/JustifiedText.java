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
package com.interviewbit.string;

import java.util.ArrayList;

/**
 * Created by Aakash on 13-Sep-16.
 */
public class JustifiedText {

   public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
      ArrayList<String> output= new ArrayList<>();

      ArrayList<String> curr = new ArrayList<>();
      int currLen = b;
      for(int i=0;i<a.size();i++){
         String s = a.get(i);
         if(s.length() != 0) {
            if (s.length() > currLen) {
               output.add(justify(curr, b, true));
               curr = new ArrayList<>();
               currLen = b;
            }
            curr.add(s);
            currLen -= s.length();
            currLen -= 1; //for space
         }
      }
      if(curr.size()!=0) {
         output.add(justify(curr, b, false));
      }
      return output;
   }

   private String justify(ArrayList<String> curr, int b, boolean fillSpace) {
      int l1 = 0;
      for(String s : curr){
         l1 += s.length();
      }
      StringBuilder sb = new StringBuilder();
      int noOfSpaces = 1;
      int extra = 0;
      if(fillSpace) {
         if(curr.size() == 1){
            noOfSpaces = b -l1;
         }else {
            noOfSpaces = (b - l1) / (curr.size() - 1);
            extra = (b - l1) % (curr.size() - 1);
         }
      }
      int j = 1;
      for(String s : curr) {
         sb.append(s);
         if(j != curr.size()) {
            for (int i = 0; i < noOfSpaces; i++) {
               sb.append(" ");
            }
            if (extra > 0) {
               sb.append(" ");
               extra--;
            }
         }
         j++;
      }
      
      if(sb.length() != 0) {
         int diff = b - sb.length();
         for (int i = 0; i < diff; i++) {
            sb.append(" ");
         }
      }
      
      return sb.toString();
   }

}
