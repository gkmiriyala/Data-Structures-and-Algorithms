package commonInterviewQuestions;

import java.util.HashMap;

import helperClasses.ListNode;
import helperClasses.ListRandNode;
import helperClasses.MyLinkedList;
import helperClasses.RandLinkedList;

public class LinkedListPractice<T> {
	public static void main(String[] args) {
		LinkedListPractice<String> linkedListPractice = new LinkedListPractice<String>();
		MyLinkedList<String> list = MyLinkedList.makeStringLL("String");
		list.printLinkedList(linkedListPractice.revLinkedListRecursively(list, list.head.next, list.head));
		// System.out.println(isLinkedListPal(list));
	}

	/*
	 * Reverse a Linked List iteratively
	 */
	public MyLinkedList<T> revLinkedList(MyLinkedList<T> list) {
		if (list.head == null)
			return list;
		ListNode<T> curr = list.head.next;
		ListNode<T> prev = list.head;
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
	public MyLinkedList<T> revLinkedListRecursively(MyLinkedList<T> list, ListNode<T> curr, ListNode<T> prev) {
		if (list.head == null)
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
	public boolean isLinkedListPal(MyLinkedList<T> list) {
		LinkedListPractice<T> linkedListPractice = new LinkedListPractice<T>();
		MyLinkedList<T> revList = linkedListPractice.revLinkedList(list);
		ListNode<T> curr1 = list.head.next;
		ListNode<T> curr2 = revList.head.next;
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
	public boolean isLinkedListCircular(MyLinkedList<T> list) {
		ListNode<T> slow = list.head;
		ListNode<T> fast = list.head;
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
	 * Solution: Have a slow reference that moves by 1 step and a fast reference
	 * that moves by 2 steps. Once the slow and fast meet return one of the
	 * references back to the beginning. Start moving both references by one.
	 * They will eventually meet at the node where the circle starts.
	 */
	public ListNode<T> LinkedListCirculeMeets(MyLinkedList<T> list) {
		ListNode<T> slow = list.head;
		ListNode<T> fast = list.head;
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = list.head; // You could put slow or fast back to the
									// beginning
				break;
			}
		}
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow; // You could return slow or fast since they both refer to
						// the same node
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
	 * Implement an algorithm to find the kth to the last element in a singly
	 * linked list
	 */
	public ListNode<T> findKthToLastElement(ListNode<T> a, int k) {
		ListNode<T> kthFromLast = a;
		ListNode<T> last = a;
		for (int i = 0; i < k; i++) {
			last = last.next;
		}
		while (last.next != null) {
			kthFromLast = kthFromLast.next;
			last = last.next;
		}
		return kthFromLast;
	}

	/*
	 * Delete a node from a singly linked list given access only to that node
	 */
	public ListNode<T> deleteAccessNodeFromLinkedList(ListNode<T> accessNode) {
		accessNode.data = accessNode.next.data;
		accessNode.next = accessNode.next.next;
		return accessNode;
	}

	/*
	 * Find out if two linked lists intersects and if they do, return the node
	 * at which they intersect
	 */
	public ListNode<T> whereTwoLinkedListsIntersect(ListNode<T> a, ListNode<T> b) {
		ListNode<T> c = a;
		ListNode<T> d = b;
		int countA = 0;
		int countB = 0;
		while (a.next != null) {
			a = a.next;
			countA++;
		}
		while (b.next != null) {
			b = b.next;
			countB++;
		}
		int diff = countB - countA;
		if (diff < 0)
			for (int i = 0; i > diff; i--) {
				c = c.next;
			}
		else {
			for (int i = 0; i < diff; i++) {
				d = d.next;
			}
		}
		while (c.next != null && d.next != null) {
			if (c == d)
				return c;
			c = c.next;
			d = d.next;
		}
		return c;
	}

	/*
	 * Clone a linked list with a random pointer (Brute Force)
	 */
	public static ListRandNode cloneLinkedListWithRand(ListRandNode list) {
		ListRandNode curr = list;
		ListRandNode newNode = new ListRandNode(list.data);
		ListRandNode currTwo = newNode;
		while (curr.next != null) {
			currTwo.next = new ListRandNode(curr.next.data);
			curr = curr.next;
			currTwo = currTwo.next;
		}
		curr = list;
		currTwo = newNode;
		while (curr.next != null) {
			ListRandNode currSt = curr.next;
			ListRandNode currEnd = curr.random;
			ListRandNode currTwoEnd = currTwo;
			while (currEnd != null && currSt != currEnd) {
				currSt = currSt.next;
				currTwoEnd = currTwoEnd.next;
			}
			currTwo.random = currTwoEnd;
			currTwo = currTwo.next;
			curr = curr.next;
		}
		return list;
	}

	/*
	 * Clone a linked list with a random pointer (Clone, Merge and unlink)
	 */
	public static ListRandNode cloneLinkedListWithRandMergeAndUntangle(ListRandNode old) {
		ListRandNode current = old;
		while (current != null) {
			ListRandNode newNode = new ListRandNode(current.data);
			newNode.next = current.next;
			current.next = newNode.next;
			current = newNode.next;
		}
		ListRandNode oldCurrent = old;
		ListRandNode newCurrent = old.next;
		while (oldCurrent != null) {
			newCurrent.random = oldCurrent.random.next;
			oldCurrent = newCurrent.next;
			newCurrent = oldCurrent.next;
		}
		oldCurrent = old;
		ListRandNode clonedNode = old.next;
		newCurrent = clonedNode;
		while (oldCurrent != null && newCurrent != null) {
			oldCurrent.next = newCurrent.next;
			oldCurrent = oldCurrent.next;
			newCurrent.next = oldCurrent.next;
			newCurrent = newCurrent.next;
		}
		return clonedNode;
	}

	/*
	 * Clone a linked list with a random pointer (using HashMap)
	 */
	public static ListRandNode cloneLLwithRPUsingHM(ListRandNode old) {
		HashMap<ListRandNode, ListRandNode> map = new HashMap<ListRandNode, ListRandNode>();

		ListRandNode newNode = new ListRandNode(old.data);
		ListRandNode newCurrent = newNode;
		map.put(old, newCurrent);
		ListRandNode current = old.next;
		// Clone List and store node in HashMap
		while (current != null) {
			ListRandNode addCloneNode = new ListRandNode(current.data);
			newCurrent.next = addCloneNode;
			newCurrent = newCurrent.next;
			map.put(current, newCurrent);
			current = current.next;
		}
		current = old;
		newCurrent = newNode;

		// Add randoms to cloned list
		while (current != null) {
			newCurrent.random = map.get(current);
			current = current.next;
			newCurrent = newCurrent.next;
		}
		return newNode;
	}
}
