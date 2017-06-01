package com.aakash.interviewbit_may2017.trees;

import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/30/17.
 */
public class FlattenTree {

    class Pair {
        TreeNode start;
        TreeNode end;
    }

    public TreeNode flattenIterative(TreeNode a){
        TreeNode head = null, prev = null;
        Stack<TreeNode> s = new Stack<>();
        if(a != null) {
            s.push(a);
        }
        while(!s.isEmpty()){
            TreeNode t = s.pop();
            if(prev == null){
                head = t;
            } else {
                prev.right = t;
            }
            if(t.right != null){
                s.push(t.right);
            }
            if(t.left != null){
                s.push(t.left);
            }
            t.left = null;
            prev = t;
        }
        return head;
    }

    public TreeNode flatten(TreeNode a) {
        Pair pair = flattenHelper(a);
        if(pair ==  null){
            return null;
        }
        return pair.start;
    }

    private Pair flattenHelper(TreeNode node){
        if(node == null){
            return null;
        }
        Pair pair = new Pair();
        pair.start = node;
        Pair left = flattenHelper(node.left);
        Pair right = flattenHelper(node.right);
        if(left != null){
            node.right = left.start;
            if(right != null){
                left.end.right = right.start;
                pair.end = right.end;
            }else {
                pair.end = left.end;
            }
        } else if(right != null){
            node.right = right.start;
            pair.end = right.end;
        } else {
            pair.end = node;
        }
        node.left = null;
        return pair;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        root1.print();
        System.out.println();
        TreeNode flatten = new FlattenTree().flattenIterative(root1);
        flatten.print();
    }

}
