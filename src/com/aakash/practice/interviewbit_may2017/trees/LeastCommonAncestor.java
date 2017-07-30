package com.aakash.practice.interviewbit_may2017.trees;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/16/17.
 */

@GoodQuestion
public class LeastCommonAncestor {


    public int lca(TreeNode a, int val1, int val2) {
        List<Integer> p1 = getPath(a, val1);
        List<Integer> p2 = getPath(a, val2);
        if(p1 == null || p2 == null){
            return -1;
        }

        int i = 0, j=0, ans = -1;
        while(i < p1.size() && j < p2.size() && p1.get(i).equals(p2.get(j))){
            ans = p1.get(i);
            i++; j++;
        }
        return ans;
    }
    private List<Integer> getPath(TreeNode node, int val){
        List<Integer> path = null;
        if(node == null){
            return path;
        }
        if(node.val == val){
            path = new ArrayList<>();
            path.add(val);
            return path;
        }
        path = getPath(node.left, val);
        if(path  == null){
            path = getPath(node.right, val);
        }
        if(path != null){
            path.add(0, node.val);
        }
        return path;
    }


    public TreeNode lcaHelper(TreeNode a, int val1, int val2){
        if(a == null){
            return null;
        }
        if(a.val == val1 || a.val == val2){
            return a;
        }
        TreeNode l = lcaHelper(a.left, val1, val2);
        TreeNode r = lcaHelper(a.right, val1, val2);
        if (l != null && r!= null){
            return a;
        }
        return l != null ? l : r;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(new LeastCommonAncestor().lca(root, 6, 0));
    }
}
