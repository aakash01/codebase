package com.aakash.practice.interviewbit_may2017.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/26/17.
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode a, int b) {
        ListNode slow = a, slowPrev = null, fast = a;
        while (b > 0 && fast != null) {
            fast = fast.next;
            b--;
        }
        while(fast != null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(slowPrev == null){
            return slow.next;
        }
        slowPrev.next = slow.next;
        return a;
    }

    public static void main(String[] args) {
        RemoveNthNode removeNthNode = new RemoveNthNode();
        ListNode head = ListNode.build(new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7})));
        head.print();
        ListNode newList = removeNthNode.removeNthFromEnd(head, 8);
        newList.print();
    }
}
