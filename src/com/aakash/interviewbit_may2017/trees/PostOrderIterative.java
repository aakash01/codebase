package com.aakash.interviewbit_may2017.trees;

import com.aakash.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */
@GoodQuestion
public class PostOrderIterative {

    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode prev = null;

        Stack<TreeNode> stack = new Stack<>();
        if(a != null){
            stack.push(a);
        }
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(prev == null || curr == prev.left || curr == prev.right){
                if(curr.left != null){
                    stack.push(curr.left);
                } else if(curr.right != null){
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    result.add(curr.val);
                }
            } else if(prev == curr.left){
                if(curr.right != null){
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    result.add(curr.val);
                }
            }else {
                stack.pop();
                result.add(curr.val);
            }
            prev = curr;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{});
        PostOrderIterative postOrderIterative = new PostOrderIterative();
        System.out.println(postOrderIterative.postorderTraversal(root));

    }
}
