package commonInterviewQuestions;

import helperClasses.ListNode;
import helperClasses.MyLinkedList;

public class LinkedListPractice {
	public static void main(String[] args){ 
		MyLinkedList list = MyLinkedList.makeStringLL("abcbac");
		MyLinkedList.printLinkedList(revLinkedList(list));
		System.out.println(isLinkedListPal(list));
	}
	
	/*
	 * Reverse a Linked List
	 */
	public static MyLinkedList revLinkedList(MyLinkedList list) {
		ListNode curr = list.head.next;
		MyLinkedList revList= new MyLinkedList();
		revList.add(curr.data);
		curr = curr.next;
		while(curr!=null) {
			ListNode n = new ListNode(curr.data);
			n.next = revList.head.next;
			revList.head.next=n;
			curr=curr.next;
		}
		return revList;
	}
	
	/*
	 * Determine if a linkedlist is a palindrome
	 */
	public static boolean isLinkedListPal (MyLinkedList list) {
		MyLinkedList revList= revLinkedList(list);
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
