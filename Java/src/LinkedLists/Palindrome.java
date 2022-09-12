package LinkedLists;

import java.util.Stack;

public class Palindrome {
	
	public boolean isPalindrome(ListNode head) {
		Stack<Integer> listStack = new Stack<>();
		Stack<Integer> stack = new Stack<>() ;
	      ListNode temp = head ;
	      while(temp != null){
	          stack.push(temp.val) ;
	          temp=temp.next ;
	      }
	      
	     
	      while(head != null){
	        if( head.val == stack.peek()){
	          stack.pop() ;
	        }
	        
	        head=head.next ;
	      }
	      
	      System.out.println("Is it a palindrome? " + stack.isEmpty());
	      return stack.isEmpty() ;
	}
}
