package helperClasses;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	public ListNode<T> head;
	
	public MyLinkedList(){
		head = new ListNode<T>();
	}
	
	
	public boolean isEmpty(){
		return head.next==null;
	}
	
	public void add(T o) {
		ListNode<T> node=new ListNode<T>(o);
		ListNode<T> n = this.head;
		while (n.next!=null){
			n=n.next;
		}
		n.next=node;
	}
	
	/*
	 * Make a String a Linked List
	 */
	public static MyLinkedList<String> makeStringLL(String s) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		for (int i=0;i<s.length();i++) {
			list.add(Character.toString(s.charAt(i)));
		}
		return list;
	}
	
	/*
	 * print Linked list
	 */
	public void printLinkedList(MyLinkedList<T> list) {
		ListNode<T> curr = list.head;
		while(curr.next!=null){
			System.out.println(curr.data);
			curr=curr.next;
		}
	}


	public int size() {
		int counter = 0;
		ListNode<T> current = head;
		while (current.next!=null){
			current = current.next;
			counter++;
		}
		return counter;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
