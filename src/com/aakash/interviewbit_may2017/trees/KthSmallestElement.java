package com.aakash.interviewbit_may2017.trees;

import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
 */
public class KthSmallestElement {

    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                k--;
                if(k == 0){
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{10, 5, 15, 2 , 8, 12, 20});
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        System.out.println(kthSmallestElement.kthsmallest(root, 1));

    }
}
