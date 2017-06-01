package com.aakash.interviewbit_may2017.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */
public class PreOrderIterative {
    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(a != null){
            stack.push(a);
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{6, 3, 7, 2, 5, null, 9});
        PreOrderIterative preOrderIterative = new PreOrderIterative();
        System.out.println(preOrderIterative.preorderTraversal(root));
    }
}
