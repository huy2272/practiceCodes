package HashMap;

import java.util.HashMap;

public class HashMapPractice {
	public static void main(String[] args) {
		String str =  "III";
		int ans = 0;
		int first =0;
		int second =0;
		
		HashMap<String,Integer> romanNums = new HashMap<>();
		romanNums.put("I", 1);
		romanNums.put("V", 5);
		romanNums.put("X", 10);
		romanNums.put("L", 50);
		romanNums.put("C", 100);
		romanNums.put("D", 500);
		romanNums.put("M", 1000);
		
		
		for (int i = 0; i<str.length(); i++){ 
			int j = i;
			first = romanNums.get((""+str.charAt(j)));
			if	(i!=str.length()-1) {
				second = romanNums.get((""+str.charAt(++j)));
				if	(second>first) {
					ans = ans - first + second;
					i++;
				}else {
					ans += first;
				}
			}else {
				System.out.println("Limit reached");
				ans += first;
				System.out.println("Final answer is: " + ans);
			}
			
			
			
	    }
		
	}
}
