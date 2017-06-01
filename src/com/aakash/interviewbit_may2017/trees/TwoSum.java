package com.aakash.interviewbit_may2017.trees;

import com.aakash.common.GoodQuestion;

import java.util.Stack;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/31/17.
 */
@GoodQuestion
public class TwoSum {

    void fillStack(Stack<TreeNode> stack, TreeNode t, boolean left){
        while(t != null){
            stack.push(t);
            if(left){
                t = t.left;
            } else {
                t = t.right;
            }
        }
    }

    public int t2Sum(TreeNode A, int B) {

        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        fillStack(left, A, true);
        fillStack(right, A, false);
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode l1 = left.peek();
            TreeNode l2 = right.peek();
            int sum = l1.val + l2.val;
            if(l1 == l2){
                return 0;
            } else if(sum == B){
                return 1;
            }else if(sum > B){
                right.pop();
                fillStack(right, l2.left, false);
            } else {
                left.pop();
                fillStack(left, l1.right, true);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        TreeNode root1 = TreeNode.build(new Integer[]{10, 5, 20, 3, 6, null, 25, null, null, null, 7, null, null, 23, 27});

        System.out.println(twoSum.t2Sum(root1, 29));
    }
}
