package com.aakash.practice.interviewbit_may2017.trees;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/29/17.
 */
@GoodQuestion
public class ZigZagTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a == null){
            return result;
        }
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> aux = new Stack<>();
        boolean isLR = false;
        s.push(a);
        ArrayList<Integer> level = new ArrayList<>();
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            level.add(node.val);
            if(isLR){
                if(null != node.right) {
                    aux.push(node.right);
                }
                if(null != node.left) {
                    aux.push(node.left);
                }
            }else {
                if(null != node.left) {
                    aux.push(node.left);
                }
                if(null != node.right) {
                    aux.push(node.right);
                }
            }

            if(s.isEmpty()){
                result.add(level);
                level = new ArrayList<>();
                isLR = !isLR;
                Stack t = s;
                s = aux;
                aux = t;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        System.out.println(zigZagTraversal.zigzagLevelOrder(root));
    }

}
