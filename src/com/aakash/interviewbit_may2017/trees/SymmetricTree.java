package com.aakash.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/30/17.
 */
public class SymmetricTree {

    public int isSymmetric(TreeNode a) {
        if(a == null){
            return 1;
        }
        return isSymmetric(a.left, a.right);
    }

    private int isSymmetric(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return 1;
        } else if(t1 == null  || t2 == null || t1.val != t2.val){
            return 0;
        }
        return isSymmetric(t1.left, t2.right) & isSymmetric(t1.right, t2.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.build(new Integer[]{1, 2, 2, 3, 4, 4, 1});
        System.out.println(new SymmetricTree().isSymmetric(root1));
    }
}
