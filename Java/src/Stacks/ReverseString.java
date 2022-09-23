package Stacks;

import java.util.Stack;

public class ReverseString {
	public void reverse(char[] s) {
        Stack<Character> stack = new Stack<>();
        //Time complexity O(n)
        for (int i =0; i < s.length; i++){
            stack.add(s[i]);
        }
        
        for (int i =0; i< s.length; i++){
            s[i]=stack.pop();
        }
    }
}
