package com.aakash.interviewbit_may2017.linked_list;

import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/26/17.
 */

/**
 * Linkedlist node helper class.
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }

    public static ListNode build(List<Integer> list){
        if(null == list || list.isEmpty()){
            return null;
        }
        if(list.size() == 1){
            return new ListNode(list.get(0));
        }
        ListNode listNode = new ListNode(list.get(0));
        listNode.next = build(list.subList(1, list.size()));
        return listNode;
    }

    public void print(){
        System.out.print(val+"->");
        if(null != next){
            next.print();
        } else {
            System.out.print("null");
            System.out.println();

        }
    }
}
