package Arrays;

import java.util.Stack;

public class ValidPalindrome125 {
	public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        Stack<Integer> stck = new Stack<>();
        Stack<Integer> stck1 = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            //Lower case characters ASCII values are in [65,90]
            int a = str.charAt(i);
            System.out.println(a);
            if  ((a >= 48 && a <= 57) || (a >= 97 && a <= 122)){
                stck.push(a);
            }
        }
        int mid = stck.size() / 2;

        if  (stck.size()%2 == 0){
            for (int i = 0; i < mid; i++){
                stck1.push(stck.pop());
            }
            int range = stck.size();
            for (int i = 0; i < range ; i++){
                if  (stck.peek() == stck1.peek()){
                    System.out.println("popping");
                    stck.pop();
                    stck1.pop();
                }
            }
            while   (stck.isEmpty() && stck1.isEmpty()){
                return true;
            }
            return false;
        }
        else if  (stck.size()%2 != 0){
            System.out.println("odd");
            for (int i = 0; i < mid; i++){
                stck1.push(stck.pop());
            }
            stck.pop();
            int range = stck.size();
            // If the size of the string is 1 e.g "a" then accepts
            // Make sure stck1 is empty or else string size 3 will cause incorrect output
            if  (range == 1 && stck1.isEmpty())    {return true;}
            for (int i = 0; i < range ; i++){
                if  (stck.peek() == stck1.peek()){
                    stck.pop();
                    stck1.pop();
                }
            }
        }
        while (stck.isEmpty() && stck1.isEmpty()){
            return true;
        }
        return false;
	}
}
