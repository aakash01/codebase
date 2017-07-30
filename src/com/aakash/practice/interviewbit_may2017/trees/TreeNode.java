package com.aakash.practice.interviewbit_may2017.trees;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */
public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }

    public static TreeNode build(Integer[] list){
        return buildHelper(list, 0);
    }

    private static TreeNode buildHelper(Integer[] list, int index){
        if(index >= list.length || list[index] == null){
            return null;
        }
        TreeNode node = new TreeNode(list[index]);
        node.left = buildHelper(list, 2*index+1);
        node.right = buildHelper(list, 2*index + 2);
        return node;
    }

    public void print(){
        System.out.print(val+" ");
        if(left != null) {
            left.print();
        }
        if(right != null) {
            right.print();
        }
    }
}
