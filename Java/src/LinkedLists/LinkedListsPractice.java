package LinkedLists;

import java.util.Iterator;
import java.util.LinkedList;




public class LinkedListsPractice {
	
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(7);
		list.add(8);
		list.add(9);
		//Remove the head node of the linked list
		list.remove();
		System.out.println(list);
		System.out.println(list.get(0));
		
		//Iterate through the list
		Iterator<Integer> iterate = list.iterator();
		while(iterate.hasNext()) {
			if	((int) iterate.next() == 8) {
				System.out.println("We found 8");
			}
		}
		
//		ListNode a = new ListNode(1);
//		ListNode b = new ListNode(0);
//		ListNode c = new ListNode(0);
//		ListNode d = new ListNode(1);
//		a.next = b;
//		b.next = c;
//		c.next = d;
//		
//		Palindrome p = new Palindrome();
//		p.isPalindrome(a);
	}
}
