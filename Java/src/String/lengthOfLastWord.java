package String;

public class lengthOfLastWord {

	public static int length(String s) {
        boolean flag = false;
        int counter = 0;
        for (int i = s.length() - 1; i >= 0; i-- ){
            if (s.charAt(i) == ' '){
                //If there is white spaces at the end of the string, it will not return 0
                if  (flag) {break;}
            } 
            else {
                //If the character at the given index is not empty, start counting
                //Since we started counting we can set the flag to true
                //Loop will now terminate once we reach the next empty space
                counter++;
                flag = true;
            }
        }
        System.out.println("Length of last word is: " + counter);
        return counter;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLastWord.length("Hello World");
	}

}
