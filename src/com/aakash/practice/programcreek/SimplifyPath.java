package com.aakash.practice.programcreek;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/26/17.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] paths = path.split("/");
        for(String p : paths){
            if(".".equals(p)){
                continue;
            } else if("..".equals(p)){
                if(!deque.isEmpty()){
                    deque.removeLast();
                }
            } else if(p.length() != 0){
                deque.addLast(p);
            }
        }
        String finalPath = "";
        while(!deque.isEmpty()){
            finalPath += "/"+deque.removeFirst();
        }
        if(finalPath.length() == 0){
            finalPath = "/";
        }
        return finalPath;
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
    }
}
