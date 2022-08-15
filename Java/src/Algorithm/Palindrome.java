package Algorithm;

public class Palindrome {
//a. Extract off the rightmost digit of your input number. (1234 % 10) = 4
//b. Take that digit (4) and add it into a new reversedNum.
//c. Multiply reversedNum by 10 (4 * 10) = 40, this exposes a zero to the right of your (4).
//d. Divide the input by 10, (removing the rightmost digit). (1234 / 10) = 123
//e. Repeat at step a with 123
	public boolean isPalindrome(int x) {
        int num = x;
        int reverseX = 0;
        if  (x>=0){
            while (num != 0){
                int right = 0;
                right = num % 10;
                reverseX = reverseX*10 + right;
                num = num/10;    
            }
            if  (reverseX == x){return true;}
        }
        return false;
    }
}
