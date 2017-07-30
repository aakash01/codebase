package com.aakash.practice.personal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class WordNode{
   String word;
   int numSteps;

   public WordNode(String word, int numSteps){
      this.word = word;
      this.numSteps = numSteps;
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("WordNode{");
      sb.append("word='").append(word).append('\'');
      sb.append(", numSteps=").append(numSteps);
      sb.append('}');
      return sb.toString();
   }
}

public class WordLadder {
   public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
      java.util.LinkedList<WordNode> queue = new java.util.LinkedList<WordNode>();
      queue.add(new WordNode(beginWord, 1));

      wordDict.add(endWord);

      while(!queue.isEmpty()){
         WordNode top = queue.remove();
         String word = top.word;

         if(word.equals(endWord)){
            return top.numSteps;
         }

         char[] arr = word.toCharArray();
         for(int i=0; i<arr.length; i++){
            for(char c='a'; c<='z'; c++){
               char temp = arr[i];
               if(arr[i]!=c){
                  arr[i]=c;
               }

               String newWord = new String(arr);
               if(wordDict.contains(newWord)){
                  queue.add(new WordNode(newWord, top.numSteps+1));
                  System.out.println("inside"+ queue);
                  wordDict.remove(newWord);
               }
               arr[i]=temp;
            }
         }
      }

      return 0;
   }

   public static void main(String[] args) {
      WordLadder sol = new WordLadder();
      String start = "hit";
      String end = "cog";
      Set<String>  s = new HashSet<String>(Arrays.asList("hot", "lot", "log", "tot", "tog"));
      System.out.println(sol.ladderLength(start, end, s));
   }
}