package com.aakash.practice.interviewbit_may2017.trees;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
 */

/**
 *

 Find shortest unique prefix to represent each word in the list.

 Example:

 Input: [zebra, dog, duck, dove]
 Output: {z, dog, du, dov}
 where we can see that
 zebra = z
 dog = dog
 duck = du
 dove = dov

 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.


 */

@AwesomeQuestion
public class ShortestUniquePrefix {

    public ArrayList<String> prefix(ArrayList<String> a) {
        // build Trie
        TrieNode root = new TrieNode(' ');
        for(String s : a){
            addStringToTrie(root, s);
        }
        ArrayList<String> result = new ArrayList<>();
        for(String s : a){
            result.add(getPrefix(root, s));
        }
        return result;

    }

    private void addStringToTrie(TrieNode parent, String s){
        if(s == null || s.length() == 0){
            return;
        }
        TrieNode node = null;
        char ch = s.charAt(0);
        if(parent.children.containsKey(ch)){
            node = parent.children.get(ch);
        } else {
            node = new TrieNode(ch);
            parent.children.put(ch, node);
        }
        addStringToTrie(node, s.substring(1));
    }

    private String getPrefix(TrieNode parent, String s){
        int index = 0;
        char[] cArr = s.toCharArray();
        for(int i=0;i<cArr.length;i++){
            TrieNode node = parent.children.get(cArr[i]);
            if(node.children.size() > 1) {
                index = i+1;
            }
            parent = node;
        }
        return s.substring(0, index+1);
    }

    class TrieNode{
        Character ch;
        Map<Character, TrieNode> children = new HashMap<>();

        TrieNode(Character ch){
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        System.out.println(shortestUniquePrefix.prefix(new ArrayList<>(Arrays.asList(new String[]{"zebra", "dog", "dove", "duck"}))));
    }
}
