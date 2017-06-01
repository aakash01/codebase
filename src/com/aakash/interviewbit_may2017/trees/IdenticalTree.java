package com.aakash.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
 */
public class IdenticalTree {

    public int isSameTree(TreeNode a, TreeNode b) {
        if(a == null && b == null){
            return 1;
        }else if(a == null || b == null){
            return 0;
        }
        if(a.val != b.val){
            return 0;
        }
        return isSameTree(a.left, b.left) & isSameTree(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode root2 = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, null, 7});

        IdenticalTree identicalTree = new IdenticalTree();
        System.out.println(identicalTree.isSameTree(root1, root2));

    }
}
