package commonInterviewQuestions;

import helperClasses.ListNode;
import helperClasses.MyLinkedList;

public class LinkedListPractice {
	public static void main(String[] args){ 
		MyLinkedList list = MyLinkedList.makeStringLL("String");
		MyLinkedList.printLinkedList(revLinkedListGood(list));
		//System.out.println(isLinkedListPal(list));
	}
	
	/*
	 * Reverse a Linked List
	 */
	public static MyLinkedList revLinkedListGood(MyLinkedList list) {
		ListNode curr = list.head.next;
		ListNode prev = list.head;
		while(curr.next!=null) {
			list.head.next = curr.next;
			curr.next = prev;
			prev=curr;
			curr=list.head.next;
		}
		list.head.next=null;
		list.head = curr;
		list.head.next = prev;
		return list;
	}
	/*
	 * Determine if a linkedlist is a palindrome
	 */
	public static boolean isLinkedListPal (MyLinkedList list) {
		MyLinkedList revList= revLinkedListGood(list);
		ListNode curr1 = list.head.next;
		ListNode curr2 = revList.head.next;
		while(curr1!=null) {
			if(!curr1.data.equals(curr2.data))
				return false;
			else {
				curr1=curr1.next;
				curr2=curr2.next;
			}
		}
		return true;
	}
	
	/*
	 * Write an algorithm to determine if a linkedlist is circular. FOLLOW UP: Determine where the circle meets.
	 */
	public boolean isLinkedListCircular(MyLinkedList list) {
		ListNode curr = list.head;
		while(curr.next!=null){
			if (curr.next==list.head)
				return true;
			else
				curr=curr.next;
		}
		return false;
	}	
}
