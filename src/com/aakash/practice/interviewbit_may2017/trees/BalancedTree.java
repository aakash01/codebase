package com.aakash.practice.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
 */
public class BalancedTree {

    public int isBalanced(TreeNode a) {
        int h = isBalancedHelper(a);
        return h == -1 ? 0 : 1;
    }

    private int isBalancedHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = isBalancedHelper(node.left);
        int right = isBalancedHelper(node.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{6, 3, 7, 2, 5, null, 9});
        TreeNode root1 = TreeNode.build(new Integer[]{1, 2, null, 3});
        BalancedTree balancedTree = new BalancedTree();
        System.out.println(balancedTree.isBalanced(root1));
    }
}
