package LinkedLists;

import java.util.Stack;

public class Palindrome {
	
	public boolean isPalindrome(ListNode head) {
		Stack<Integer> listStack = new Stack<>();
		//Making a dummy Node to traverse the linked list
		ListNode dummy = new ListNode(-1);
		while	(head != null) {
			//Set the Node to point to the new Node
			dummy.next = head;
			
			//Move to the new Node
			dummy = dummy.next;
			//Add the value of the new Node to the stack
			listStack.add(dummy.val);
			System.out.println("Content of stack " + listStack);
			head=head.next;
			while	(head != null && !listStack.empty() && (listStack.peek() == head.val)) {System.out.println("Popping"); head=head.next; listStack.pop();}
		}
		System.out.println("Outside of while loop " + listStack.empty() + " " + listStack);
		if	(listStack.empty()) {System.out.println("This is a palindrome "); return true;}
		return false;
	}
}
