package Stacks;

import java.util.Stack;

public class Parentheses {
	public Parentheses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		//Loop through all elements in s
		//If it is opening bracket, add to stack
		//If not check if the closing bracket matches with the top of the stack
		//If yes pop, if no return false
		
		//Make sure the string contains more than 1 character
		if	(s.length() <= 1) {System.out.println("False, String is too short!"); return false;}
		
		//Have to make sure the stack is not empty to account for "]}" closing parentheses appearing first
		for	(int i =0; i < s.length(); i++) {
			if	((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {stack.add(s.charAt(i));}
			else if	(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') {stack.pop();}
			else if	(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') {stack.pop();}
			else if	(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') {stack.pop();}
			else	{System.out.println("False"); return false;}
		}
		
		//Have to make sure the stack is empty
		//If the stack is !empty it means that there is at least 1 parentheses that was not closed
		if (stack.size() == 0) {System.out.println("true");return true;}
		
		System.out.println("False, stack is not empty");
		return false;
	}
}
