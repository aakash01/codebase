package com.aakash.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
 */
public class PathSum {

    public int hasPathSum(TreeNode a, int b) {
        if(a == null){
            return 0;
        }
        if(a.left == null && a.right == null){
            if(b == a.val){
                return 1;
            }
            return 0;
        }
        return hasPathSum(a.left, b-a.val) | hasPathSum(a.right, b-a.val);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode root = TreeNode.build(new Integer[]{5, 4, 8, 11, 13, 4, 7, 2, null, 1});
        System.out.println(pathSum.hasPathSum(root, 22));
    }
}
