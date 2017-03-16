package commonInterviewQuestions;

import helperClasses.ListNode;
import helperClasses.ListRandNode;
import helperClasses.MyLinkedList;
import helperClasses.RandLinkedList;

public class LinkedListPractice {
	public static void main(String[] args) {
		MyLinkedList list = MyLinkedList.makeStringLL("String");
		MyLinkedList.printLinkedList(revLinkedListRecursively(list, list.head.next, list.head));
		// System.out.println(isLinkedListPal(list));
	}

	/*
	 * Reverse a Linked List iteratively  	
	 */
	public static MyLinkedList revLinkedList(MyLinkedList list) {
		if (list.head==null)
			return list;
		ListNode curr = list.head.next;
		ListNode prev = list.head;
		while (curr.next != null) {
			list.head.next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = list.head.next;
		}
		list.head.next = null;
		list.head = curr;
		list.head.next = prev;
		return list;
	}

	/*
	 * Reverse a Linked List recursively
	 */
	public static MyLinkedList revLinkedListRecursively(MyLinkedList list, ListNode curr, ListNode prev) {
		if(list.head==null)
			return list;
		if (curr.next == null) {
			list.head.next = null;
			list.head = curr;
			list.head.next = prev;
		} else {
			list.head.next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = list.head.next;
			revLinkedListRecursively(list, curr, prev);
		}

		return list;
	}

	/*
	 * Determine if a linkedlist is a palindrome
	 */
	public static boolean isLinkedListPal(MyLinkedList list) {
		MyLinkedList revList = revLinkedList(list);
		ListNode curr1 = list.head.next;
		ListNode curr2 = revList.head.next;
		while (curr1 != null) {
			if (!curr1.data.equals(curr2.data))
				return false;
			else {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
		}
		return true;
	}

	/*
	 * Write an algorithm to determine if a linkedlist is circular.
	 */
	public boolean isLinkedListCircular(MyLinkedList list) {
		ListNode slow = list.head;
		ListNode fast = list.head;
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	/*
	 * FOLLOW UP: Determine where a linked list circle meets.
	 */
	public ListNode LinkedListCirculeMeets(MyLinkedList list) {
		ListNode slow = list.head;
		ListNode fast = list.head;
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = list.head;
				break;
			}
		}
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	/*
	 * Merge all branches of a linked list into a single linked list
	 */
	public RandLinkedList mergeLinkedList(RandLinkedList list) {
		ListRandNode curr = list.head;
		while (curr.random != null || curr.next != null) {
			ListRandNode start = curr.random;
			ListRandNode end = curr.random;
			while (end.next != null) {
				end = end.next;
			}
			end.next = curr.next;
			curr.next = start;
			curr.random = null;
			curr = curr.next;
		}
		return list;
	}
}
