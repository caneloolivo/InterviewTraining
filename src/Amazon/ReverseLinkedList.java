package Amazon;

import java.util.Stack;

public class ReverseLinkedList {
	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 
	 public ListNode reverseList(ListNode head) {
		 ListNode prev = null; 
		 ListNode nextTemp; 
		 while(head != null)
		 { 
			 nextTemp = head.next; 
			 head.next = prev; 
			 prev = head; 
			 head = nextTemp; 
		 } 
		 return prev; 
	 }
	 public ListNode reverseList2(ListNode head) {
		 Stack<Integer> stack = new Stack<Integer>();
		 while(head != null) {
			 stack.push(head.val);
			 head = head.next;
		 }
		 ListNode result = new ListNode();
		 ListNode tmp = result;
		 while(!stack.isEmpty()) {
			 tmp.next = new ListNode(stack.pop());
			 tmp = tmp.next;
		 }
		 return result.next;
	 }
	 
		 
	 public void printList(ListNode head) {
		 ListNode tmp = head;
		 while(tmp != null) {
			 System.out.print(tmp.val +" ");
			 tmp = tmp.next;
		 }
	 }
	 
	 public static void main(String[] args) {
		 ReverseLinkedList solution = new ReverseLinkedList();
		 ListNode head = new ListNode(1, new ListNode(2, 
				 new ListNode(3,new ListNode(4, new ListNode(5)))));
		 ListNode result = solution.reverseList2(head);
		 solution.printList(result);
	 }
}
