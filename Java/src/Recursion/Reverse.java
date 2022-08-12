package Tut;
//Using recursion to reverse the string
public class Reverse {
	public static void main(String[] args) {
		String str ="Wonderful Day";
		System.out.println(reverse(str));
	}
	
	public static String reverse( String str) {
		//System.out.println(str);
		if(str.length()==0) {
			return str;
		}else {
			return reverse( str.substring(1) ) + str.charAt(0);
		}
	}
}
