package String;

public class ReverseStringBuffer {
	class Solution {
	    public String reverseWords(String s) {
	    	//Make an arr of words and put each word in an index
	    	//A new index is identified as having a white space between them
	        String[] words = s.split(" ");
	        
	        //By passing a string to StringBuffer we can use the method reverse
	        //However StringBuffer outputs an object so we need to use .toString
	        for (int i = 0; i < words.length; i++){
	            words[i] = new StringBuffer(words[i]).reverse().toString();
	        }
	        
	        //The join method takes every elements in the words arr and separate them with a white space
	        //We return a string that reverse each word
	        //The order of the word within the string stays the same just the letters are reversed
	        return String.join(" ",words);
	    }
	}
}
