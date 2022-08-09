package Recursion;

public class Permutation {
	public static void main(String[] args) {
		permute("COIN");
	}
	
	public static void permute(String str) {
		permute("",str);
	}
	
	private static void permute(String prefix, String str) {
		int n = str.length();
		if (n==0) System.out.println(prefix + " ");
		else {
			for	(int i =0;i<n;i++) {
				permute(prefix +str.charAt(i),
					str.substring(0,i) + str.substring(i+1,n));
			}
		}
	}
}
