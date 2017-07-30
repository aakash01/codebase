package com.aakash.practice.interviewbit_may2017.trees;

import com.aakash.practice.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
 */

/**
 *
 * Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.

 Note: You may assume that duplicates do not exist in the tree.
 */

@AwesomeQuestion
public class CartesianTree {

    public TreeNode buildTree(ArrayList<Integer> a) {
        if(null == a || a.size() == 0){
            return null;
        }
        TreeNode left = null;
        for(int i = 0;i<a.size();){
            int k = i;
            TreeNode node = new TreeNode(a.get(k));
            node.left = left;
            i++;
            while(i<a.size() && a.get(i) < a.get(k)){
                i++;
            }
            if(k < a.size()){
                node.right = buildTree(new ArrayList<>(a.subList(k+1, i)));
            }
            left = node;
        }
        return left;
    }

    public static void main(String[] args) {
        CartesianTree cartesianTree = new CartesianTree();
        TreeNode root = cartesianTree.buildTree(new ArrayList<>(Arrays.asList(new Integer[]{4, 3, 5, 1, 2, 10, 6, 9, 7, 8})));
        //10 5 4 3 2 1 9 6 8 7
        root.print();
    }
}
