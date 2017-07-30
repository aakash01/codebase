package com.aakash.practice.interviewbit_may2017.linked_list;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/26/17.
 */
public class ListCycle {

    public ListNode detectCycle(ListNode a) {
        ListNode slow = a, fast =a;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        fast = a;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListCycle listCycle = new ListCycle();

    }
}
