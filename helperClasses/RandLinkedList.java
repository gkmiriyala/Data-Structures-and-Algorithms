package helperClasses;

public class RandLinkedList {
	public ListRandNode head;
	
	public RandLinkedList(){
		head = new ListRandNode();
	}
	
	
	public boolean isEmpty(){
		return head.next==null && head.random==null;
	}
	
	public void add(String s) {
		ListRandNode node=new ListRandNode(s);
		ListRandNode n = this.head;
		while (n.next!=null){
			n=n.next;
		}
		n.next=node;
	}
	
	/*
	 * Make a String a Linked List
	 */
	public static RandLinkedList makeStringLL(String s) {
		RandLinkedList list = new RandLinkedList();
		for (int i=0;i<s.length();i++) {
			list.add(Character.toString(s.charAt(i)));
		}
		return list;
	}
	
	/*
	 * print Linked list
	 */
	public static void printLinkedList(RandLinkedList list) {
		ListRandNode curr = list.head;
		while(curr.next!=null){
			System.out.println(curr.data);
			curr=curr.next;
		}
	}
	
	
}

