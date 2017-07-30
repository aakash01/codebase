package com.aakash.practice.interviewbit_may2017.linked_list;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/26/17.
 */
@GoodQuestion
public class KReverse    {

    public ListNode reverseList(ListNode A, int B) {
        ListNode currStart = A, prevStart = null, head = null;
        while(A != null){
            ListNode prev = null;
            for(int i=1;i<=B;i++){
                ListNode next = A.next;
                A.next = prev;
                prev = A;
                A = next;
            }
            if(prevStart != null){
                prevStart.next = prev;
            } else {
                head = prev;
            }
            prevStart = currStart;
            currStart = A;
        }

        return head;
    }

    public static void main(String[] args) {
        KReverse kReverse = new KReverse();
        ListNode head = ListNode.build(new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6})));
        head.print();
        ListNode newList = kReverse.reverseList(head, 3);
        newList.print();
    }
}
