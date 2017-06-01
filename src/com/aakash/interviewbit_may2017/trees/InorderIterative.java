package com.aakash.interviewbit_may2017.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */
public class InorderIterative {

    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || a != null){
            if(a != null){
                stack.push(a);
                a = a.left;
            } else {
                a = stack.pop();
                result.add(a.val);
                a = a.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{6, 3, 7, 2, 5, null, 9});
        InorderIterative inorderIterative = new InorderIterative();
        System.out.println(inorderIterative.inorderTraversal(root));
    }
}
