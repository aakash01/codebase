package com.aakash.hackerrank.ctci;

import java.util.*;

/**
 * Created by a0n007d on 27/02/17.
 */
public class TrieContacts {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isComplete;
        int count = 0;

        TrieNode addNode(Character ch){
            if(!children.containsKey(ch)){
                children.put(ch, new TrieNode());
            }
            count += 1;
            return children.get(ch);
        }

        static void addString(TrieNode root, String string){
            TrieNode currNode = root;
            for(char ch : string.toCharArray()){
                currNode = currNode.addNode(ch);
            }
            currNode.isComplete = true;
        }

        static int getStringByPrefix(TrieNode root, String prefix){
            TrieNode currNode = root;
            for(char ch:prefix.toCharArray()){
                if(!currNode.children.containsKey(ch)){
                    return 0;
                }
                currNode = currNode.children.get(ch);
            }
            int count = currNode.count;
            if(currNode.isComplete){
                count += 1;
            }
            return count;

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TrieNode root = new TrieNode();
        long start = System.currentTimeMillis();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            switch(op){
                case "add":
                    TrieNode.addString(root, contact);
                    break;
                case "find":
                    System.out.println(TrieNode.getStringByPrefix(root, contact));
                    break;
            }
        }
        System.out.println("Time taken : " +(System.currentTimeMillis() - start) / 1000 +" secs");
    }
}
