package com.aakash.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/31/17.
 */
public class MinDepth {

    public int minDepth(TreeNode a) {
        if(a == null){
            return 0;
        }
        if(a.left == null && a.right == null){
            return 1;
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(a.left != null){
            left = minDepth(a.left);
        }
        if(a.right != null){
            right = minDepth(a.right);
        }
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        MinDepth minDepth = new MinDepth();
        TreeNode root = TreeNode.build(new Integer[]{10, 11});
        System.out.println(minDepth.minDepth(root));

    }
}
