package com.aakash.practice.interviewbit_may2017.linked_list;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/26/17.
 */
@GoodQuestion
public class ReverseMToN {
    public ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode startPrev = null;
        ListNode curr = a;
        for(int i=1;i<m;i++){
            startPrev = curr;
            curr = curr.next;
        }

        ListNode start = curr, prev = null;
        for(int i=m;i<=n;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        start.next = curr;
        if(startPrev != null){
            startPrev.next = prev;
            return a;
        } else {
            return prev;
        }
    }

    public static void main(String[] args) {
        ReverseMToN reverseMToN = new ReverseMToN();
        ListNode head = ListNode.build(new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7})));
        head.print();
        ListNode newList = reverseMToN.reverseBetween(head, 2, 4);
        newList.print();

    }

}
