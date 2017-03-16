package helperClasses;

public class MyLinkedList {
	public ListNode head;
	
	public MyLinkedList(){
		head = new ListNode();
	}
	
	
	public boolean isEmpty(){
		return head.next==null;
	}
	
	public void add(String s) {
		ListNode node=new ListNode(s);
		ListNode n = this.head;
		while (n.next!=null){
			n=n.next;
		}
		n.next=node;
	}
	
	/*
	 * Make a String a Linked List
	 */
	public static MyLinkedList makeStringLL(String s) {
		MyLinkedList list = new MyLinkedList();
		for (int i=0;i<s.length();i++) {
			list.add(Character.toString(s.charAt(i)));
		}
		return list;
	}
	
	/*
	 * print Linked list
	 */
	public static void printLinkedList(MyLinkedList list) {
		ListNode curr = list.head;
		while(curr.next!=null){
			System.out.println(curr.data);
			curr=curr.next;
		}
	}
	
	
}
