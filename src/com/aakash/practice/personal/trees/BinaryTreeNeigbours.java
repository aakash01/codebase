package com.aakash.practice.personal.trees;

/**
 * Created by a0n007d on 26/02/17.
 */

/**
 * Given a binary search tree with node structure as follows
 *
 * class TreeNode {
 *    int data;
 *    TreeNode left;
 *    TreeNode right;
 *    TreeNode parent;
 * }
 *
 * A random node is given, you have to write a program to print the 5 closest small and large elements to that node.
 */

public class BinaryTreeNeigbours {


   public static void printNeighbours(TreeNode random){
      int required = 5;
      int visited = printReverseInorder(random.left, required);

      if(visited == required){
         return;
      }

      TreeNode parent = random.parent;
      while(visited != required){
         while(parent != null && parent.data >= random.data){
            parent = parent.parent;
         }
         if(parent == null){
            return;
         }
         System.out.println(parent.data);
         visited += printReverseInorder(parent.left, required - visited);
         parent = parent.parent;
      }

   }

   private static int printReverseInorder(TreeNode node, int required){
      if(node == null || required == 0){
         return 0;
      }

      int visited = printReverseInorder(node.right, required);

      if(visited == required){
         return visited;
      }

      System.out.println(node.data);
      visited += 1;

     visited += printReverseInorder(node.left, required - visited);

     return visited;

   }

   public static void main(String[] args) {

      TreeNode root = new TreeNode(100);
      root.left = new TreeNode(50);
      root.left.parent = root;
      root.right = new TreeNode(200);
      root.right.parent = root;
      root.right.left = new TreeNode(150);
      root.right.left.parent = root.right;
      root.right.right = new TreeNode(500);
      root.right.right.parent = root.right;
      root.right.right.left = new TreeNode(400);
      root.right.right.left.parent = root.right.right;
      root.right.right.left.left = new TreeNode(300);
      root.right.right.left.left.parent = root.right.right.left.left;

      printNeighbours(root.right.right.left);
   }


   private static class TreeNode{
      int data;
      TreeNode left, right, parent;

      public TreeNode(int data) {
         this.data = data;
      }
   }

}
