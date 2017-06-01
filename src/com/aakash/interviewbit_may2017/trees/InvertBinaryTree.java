package com.aakash.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        root.print();
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode invertedNode = invertBinaryTree.invertTree(root);
        System.out.println();
        invertedNode.print();
    }
}
