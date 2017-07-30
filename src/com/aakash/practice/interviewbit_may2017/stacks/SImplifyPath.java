package com.aakash.practice.interviewbit_may2017.stacks;

import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/27/17.
 */
public class SImplifyPath {

    public String simplifyPath(String a){
        Stack<String> s = new Stack<>();
        String[] dirs = a.split("/");
        for(String dir: dirs){
            if(dir.length() == 0 || dir.equals(".")){
                continue;
            } else if(dir.equals("..")){
                if(!s.isEmpty()) {
                    s.pop();
                }
            } else{
                s.push(dir);
            }
        }
        Stack<String> aux = new Stack<>();
        while(!s.isEmpty()){
            aux.push(s.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!aux.isEmpty()){
            sb.append("/"+aux.pop());
        }
        if(sb.length() == 0){
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SImplifyPath simplifyPath = new SImplifyPath();
        System.out.println(simplifyPath.simplifyPath("/../"));
    }
}
