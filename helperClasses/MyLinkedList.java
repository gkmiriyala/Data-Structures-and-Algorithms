package helperClasses;

public class MyLinkedList {
	public ListNode head=null;
	
	
	public void add(ListNode node) {
		head = null;
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
}
