package com.personal;

// 1 --> 2 --> 3 --> 4 --> 5
public class LinkedListUtility {

   public static void reverseLinkedList(LinkedList linkedList) {

      LinkedList.Node current = linkedList.head;
      LinkedList.Node prevNode = null;
      while(current != null){
         LinkedList.Node temp = current.next;
         current.next = prevNode;
         prevNode = current;
         current = temp;
      }
      linkedList.head = prevNode;
   }
   
   public static LinkedList.Node reverseLLRecursive(LinkedList.Node curr, LinkedList l){
      if(curr.next == null){
         l.head = curr;
      } else {
         LinkedList.Node rev  = reverseLLRecursive(curr.next, l);
         curr.next = null;
         rev.next = curr;
      }
      return curr;
   }
   
   public static LinkedList.Node sortedMergeRecursive(LinkedList.Node head1, LinkedList.Node head2){
      if(head1 == null){
         return head2;
      } else if (head2 == null){
         return head1;
      }
      if(head1.data < head2.data){
         head1.next = sortedMergeRecursive(head1.next, head2);
         return head1;
      } else {
         head2.next = sortedMergeRecursive(head1, head2.next);
         return head2;
      }
   }
   
   public static boolean isLooped(LinkedList linkedList){
      LinkedList.Node slow = linkedList.head;
      LinkedList.Node fast = linkedList.head;
      
      while(slow != null && fast != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
         if(slow == fast){
            return true;
         }
      }
      return false;
      
   }
   
   // loop point in looped linked list
   // insert an element into a sorted linkedlist
   // Check if linkedlist is palindrome 
   // intersection point of a linked list
   
   // intersection of 2 sorted lined list. 
   public static LinkedList.Node sortedListsIntersection(LinkedList.Node head1, LinkedList.Node head2){
      if(head1 == null || head2 == null){
         return null;
      }
      if(head1.data == head2.data){
         LinkedList.Node node = new LinkedList.Node(head1.data);
         node.next = sortedListsIntersection(head1.next, head2.next);
         return node;
      } else if(head1.data > head2.data){
         return sortedListsIntersection(head1, head2.next);
      } else {
         return sortedListsIntersection(head1.next, head2);
      }
   }
   
   public static LinkedList.Node reverseMToN(LinkedList.Node head, int m, int n){
      LinkedList.Node curr = head, prev = null, start = null, end = null;
      int i=0;
      while(++i < m){
         start= curr;
         curr = curr.next;
      }
      end = curr;
      while(i++<=n){
         LinkedList.Node temp  = curr.next;
         curr.next = prev;
         prev = curr;
         curr = temp;
      }
      if(start != null){
         start.next = prev;
      } else {
         head  = prev;
      }
      if(end != null){
         end.next = curr;
      }
      return head;
   }
   
   public static int binarySearch(int[] arr, int l, int r, int q){
      if(l<=r){
         int m = l + (r-l)/2;
         if(arr[m] == q){
            return m;
         } else if(arr[m] > q){
            return binarySearch(arr, l, m-1, q);
         }
         return binarySearch(arr, m+1, r, q);
      }
      return -1;
   }
   
   public static <T extends Comparable> int genericBinarySearch(T[] arr, int l , int r, T query){
      if(l<=r){
         int m = l  +(r-l)/2;
         int compareIndex = query.compareTo(arr[m]);
         if(compareIndex == 0){
            return m;
         } else if(compareIndex < 0){
            return genericBinarySearch(arr, l, m-1, query);
         }
         return genericBinarySearch(arr, m+1, r, query);
      }
      return -1;
   }
   
   public static TreeNode listToBST(LinkedList.Node headPointer, int start, int end){
      if(start > end) {
         return null;
      }
      int mid = start + (end - start)/2;
      TreeNode left = listToBST(headPointer, start, mid - 1);
      TreeNode curr = new TreeNode(headPointer.next.data);
      curr.left = left;
      headPointer.next = headPointer.next.next;
      curr.right = listToBST(headPointer, mid+1, end);
      return curr;
   }
   
   public static boolean isPalindrome(LinkedList.Node leftPointer, LinkedList.Node right){
      if(right == null){
         return true;
      }
      boolean isPalindrome  = isPalindrome(leftPointer, right.next) && leftPointer.next.data == right.data;
      System.out.println("Compared "+leftPointer.next.data +" and "+ right.data);
      leftPointer.next = leftPointer.next.next;
      return isPalindrome;
   }

   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.head = new LinkedList.Node(1);
      list.head.next = new LinkedList.Node(2);
      list.head.next.next = new LinkedList.Node(3);
      list.head.next.next.next = new LinkedList.Node(4);
      
      list.print();

      System.out.print("Iterative reverse   ");
      reverseLinkedList(list);
      list.print();

      System.out.print("Recursive reverse   ");
      reverseLLRecursive(list.head, list);
      list.print();


      LinkedList list1 = new LinkedList();
      list1.head = new LinkedList.Node(1);
      list1.head.next = new LinkedList.Node(8);
      list1.head.next.next = new LinkedList.Node(9);
      list1.print();

      LinkedList list2 = new LinkedList();
      list2.head = new LinkedList.Node(2);
      list2.head.next = new LinkedList.Node(5);
      list2.head.next.next = new LinkedList.Node(8);
      list2.head.next.next.next = new LinkedList.Node(10);
      list2.print();

      LinkedList.Node sortedHead = sortedMergeRecursive(list1.head, list2.head);
      
      sortedHead.print();


      LinkedList list3 = new LinkedList();
      list3.head = new LinkedList.Node(1);
      list3.head.next = new LinkedList.Node(2);
      list3.head.next.next = new LinkedList.Node(3);
      list3.head.next.next.next = new LinkedList.Node(4);
      list3.head.next.next.next.next = list3.head.next;

      System.out.println(isLooped(list3));

      LinkedList list4 = new LinkedList();
      list4.head = new LinkedList.Node(1);
      list4.head.next = new LinkedList.Node(2);
      list4.head.next.next = new LinkedList.Node(3);
      list4.head.next.next.next = new LinkedList.Node(4);
      list4.head.next.next.next.next = new LinkedList.Node(6);
      list4.print();

      LinkedList list5 = new LinkedList();
      list5.head = new LinkedList.Node(2);
      list5.head.next = new LinkedList.Node(4);
      list5.head.next.next = new LinkedList.Node(6);
      list5.head.next.next.next = new LinkedList.Node(8);
      list5.print();
      
      LinkedList.Node head = sortedListsIntersection(list4.head, list5.head);
      
      head.print();
      
      Integer[] arr = new Integer[]{1,2,3,7,9};
      System.out.println(genericBinarySearch(arr, 0, 4, 2));

      String[] strArr = new String[]{"Agra","Bombay","Delhi","Kolkata","Indore"};
      System.out.println(genericBinarySearch(strArr, 0, 4, "Kolkata"));
     
      
      int x = 11;
      int count = 0;
      System.out.print(Integer.toBinaryString(x));
      while ((x=(x&(x-1))) != 0){
         count++;
      }
      System.out.println(" count of 1 "+count);

      LinkedList list6 = new LinkedList();
      list6.head = new LinkedList.Node(1);
      list6.head.next = new LinkedList.Node(2);
      list6.head.next.next = new LinkedList.Node(3);
      list6.head.next.next.next = new LinkedList.Node(4);
      list6.head.next.next.next.next = new LinkedList.Node(5);
      list6.head.next.next.next.next.next = new LinkedList.Node(6);
      list6.head.next.next.next.next.next.next = new LinkedList.Node(7);

      LinkedList.Node reversed = reverseMToN(list6.head, 2, 4);
      reversed.print();
      reverseMToN(reversed, 2, 4);
      reversed.print();

      LinkedList.Node headPointer = new LinkedList.Node(0);
      headPointer.next = list6.head;
      
      TreeNode node = listToBST(headPointer, 0, 6);
      node.print();


      LinkedList list7 = new LinkedList();
      list7.head = new LinkedList.Node(1);
      list7.head.next = new LinkedList.Node(2);
      list7.head.next.next = new LinkedList.Node(3);
      list7.head.next.next.next = new LinkedList.Node(2);
      list7.head.next.next.next.next = new LinkedList.Node(1);

      LinkedList.Node leftPointer = new LinkedList.Node(0);
      leftPointer.next = list7.head;

      System.out.println(isPalindrome(leftPointer, list7.head));
      
   }

}