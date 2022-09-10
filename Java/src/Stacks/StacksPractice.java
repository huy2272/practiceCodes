package Stacks;

import java.util.Stack;

public class StacksPractice {
	public static void main(String[] args) {
		Stack<String> games = new Stack<>();
		games.add("Call of Duty");
		games.add("Guitar Hero");
		games.add("Super Monkey Ball");
		
		//Take the top element of the stack out
		System.out.println(games.pop());
		//Look at the top element without popping
		System.out.println(games.peek());
		//Check if the stack contains a certain element
		System.out.println(games.contains("Guitar Hero"));
		//Is the stack empty?
		System.out.println(games.empty());
		//Accessing stack element by index
		System.out.println(games.get(0));
		//Set value for certain indexes
		System.out.println(games.set(0, "Call of Duty:Ghost"));
		games.pop();
		System.out.println(games.peek());
		//Check the size of the stack
		System.out.println(games.size());
		System.out.println(games);
	}
}
