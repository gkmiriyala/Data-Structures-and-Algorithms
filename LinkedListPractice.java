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
	 * FOLLOW UP: Determine where a circle in a circular linked list starts.
	 * Solution: Have a slow reference that moves by 1 step and a 
	 * fast reference that moves by 2 steps. Once the slow and fast meet
	 * return one of the references back to the beginning. Start moving both
	 * references by one. They will eventually meet at the node where the circle starts.
	 */
	public ListNode LinkedListCirculeMeets(MyLinkedList list) {
		ListNode slow = list.head;
		ListNode fast = list.head;
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = list.head; //You could put slow or fast back to the beginning
				break;
			}
		}
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow; //You could return slow or fast since they both refer to the same node
	}

	/*
	 * Merge all branches of a linked list into a single linked list
	 */
	public static RandLinkedList mergeLinkedList(RandLinkedList list) {
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
	
	/*
	 * Implement an algorithm to find the kth to the last element in a singly linked list
	 */
	public static ListNode findKthToLastElement(ListNode a, int k) {
		ListNode kthFromLast = a;
		ListNode last=a;
		for (int i=0;i<k;i++) {
			last = last.next;
		}
		while(last.next!=null) {
			kthFromLast = kthFromLast.next;
			last=last.next;
		}
		return kthFromLast;
	}
	
	/*
	 * Delete a node from a singly linked list given access only to that node
	 */
	public static ListNode deleteAccessNodeFromLinkedList(ListNode accessNode) {
		accessNode.data = accessNode.next.data;
		accessNode.next = accessNode.next.next;
		return accessNode;
	}
	
	/*
	 * Find out if two linked lists intersects and if they do, return the node
	 * at which they intersect
	 */
	public static ListNode whereTwoLinkedListsIntersect(ListNode a, ListNode b) {
		ListNode c = a;
		ListNode d = b;
		int countA = 0;
		int countB = 0;
		while (a.next!=null){
			a=a.next;
			countA++;
		}
		while (b.next!=null){
			b=b.next;
			countB++;
		}
		int diff = countB-countA;
		if (diff<0)
			for (int i=0; i>diff;i--){
				c=c.next;
			}
		else {
			for (int i=0; i<diff; i++) {
				d=d.next;
			}
		}
		while (c.next!=null && d.next!=null){
			if (c==d) return c;
			c=c.next;
			d=d.next;
		}
		return c;
	}
	
	/*
	 * Clone a linked list with a random pointer
	 */
	public static RandLinkedList cloneLinkedListWithRand(RandLinkedList list) {
		
		return list;
	}
}
