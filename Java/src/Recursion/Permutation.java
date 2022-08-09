package Recursion;

public class Permutation {
	public static void main(String[] args) {
		permute("CON");
	}
	
	public static void permute(String str) {
		permute("",str);
	}
	
	//Find substring of the string excluding the prefix
	private static void permute(String prefix, String str) {
		int n = str.length();
		//Base case, once this is satisfied the loop stops
		//So after all of the string is added to the prefix print out the prefix
		if (n==0) System.out.println(prefix + " ");
		else {
			//Call permute function for every index of the input string
			for	(int i =0;i<n;i++) {
				//Add to the prefix each time the function is called
				permute(prefix +str.charAt(i),
					//Make sure we do not pass the character added to the prefix already
					str.substring(0,i) + str.substring(i+1,n));
			}
		}
	}
}
