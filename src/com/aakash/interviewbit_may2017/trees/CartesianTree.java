package com.aakash.interviewbit_may2017.trees;

import com.aakash.common.AwesomeQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
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
