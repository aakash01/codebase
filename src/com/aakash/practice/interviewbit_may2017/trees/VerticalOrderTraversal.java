package com.aakash.practice.interviewbit_may2017.trees;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/28/17.
 */
public class VerticalOrderTraversal {

    Map<Integer, ArrayList<Integer>> map =new TreeMap<>();

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        Queue<TreeNodeLevelHelper> queue = new LinkedList<>();
        if(A == null){
            return new ArrayList<>();
        }
        queue.add(new TreeNodeLevelHelper(A, 0));
        while (!queue.isEmpty()){
            TreeNodeLevelHelper helperNode = queue.poll();
            if(map.containsKey(helperNode.level)){
                map.get(helperNode.level).add(helperNode.node.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(helperNode.node.val);
                map.put(helperNode.level, list);
            }
            if(helperNode.node.left != null){
                queue.add(new TreeNodeLevelHelper(helperNode.node.left, helperNode.level-1));
            }
            if(helperNode.node.right != null){
                queue.add(new TreeNodeLevelHelper(helperNode.node.right, helperNode.level+1));
            }
        }
        return new ArrayList<>(map.values());
    }


    class TreeNodeLevelHelper {
        TreeNode node;
        int level;

        TreeNodeLevelHelper(TreeNode node, int level){
            this.node=  node;
            this.level = level;
        }

    }

    public static void main(String[] args) {
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();

        TreeNode root = TreeNode.build(new Integer[]{6, 3, 7, 2, 5, null, 9});
        root.print();
        System.out.println(verticalOrderTraversal.verticalOrderTraversal(root));
    }
}
