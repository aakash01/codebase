package com.aakash.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/31/17.
 */
public class MaxDepth {

    public int maxDepth(TreeNode a) {
        if(a == null){
            return 0;
        }
        return Math.max(maxDepth(a.left), maxDepth(a.right)) + 1;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode root = TreeNode.build(new Integer[]{10, 5, 15, 2 , 8, 12, 20, 7, null});
        System.out.println(maxDepth.maxDepth(root));

    }
}
