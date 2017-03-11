package com.practice;

import java.util.LinkedList;

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
	 * 1)	Write an algorithm to determine if a linkedlist is a palindrome
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
	 * 2)	Write an algorithm to determine if a linkedlist is circular. FOLLOW UP: Determine where the circle meets.
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
	
	/*
	 * 3)	Clone a linked list with a random pointer.
	 */
	public LinkedList<Object> cloneLinkedList(LinkedList<Object> list) {
		LinkedList<Object> listLocal = new LinkedList<Object>();
		return listLocal;
	}
	
	/*
	 * 4)	Write code to remove duplicates from an unsorted linked list. Follow up: 
	 * How would you solve it if temporary buffer is not allowed?
	 */
	
	/*
	 * 5)	Implement an algorithm to find the kth to the last element of a singly linked list
	 */
	
	/*
	 * 6)	Implement an algorithm to delete a node in a singly linked list, given only access to that node. 
	 */
	
	/*
	 * 7)	Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes great than or equal to x.
	 */
	
	/*
	 * 8)	Reverse a linked list – iteratively and recursively
	 */
	
	/*
	 * 9)	Given a singly linked list which has data sorted in ascending order, construct a balanced BST
	 */
	
	
}
