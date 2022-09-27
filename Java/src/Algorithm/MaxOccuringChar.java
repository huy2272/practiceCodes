package Algorithm;

public class MaxOccuringChar {
	static char getMaxOccuringChar(String str) {
		int[] dict = new int[256];
		
		for	(int i = 0; i < str.length(); i++) {
			dict[str.charAt(i)]++;
		}
		
		int max = -1;
		char answer = ' ';
		
		for	(int i = 0; i<str.length(); i++) {
			if	(max < dict[str.charAt(i)]) {
				max = dict[str.charAt(i)];
				answer = str.charAt(i);
			}
		}
		System.out.println("The number of repetition is: " + max);
		return answer;
	}
	
	public static void main(String[] args) {
		char answer = getMaxOccuringChar("eeeeooooo");
		System.out.println(answer);
	}
}
