package Algorithm;

public class LongestPrefix {
	public static String longestCommonPrefix(String[] strs) {
		int index = 0;
		int i = 1;
        while (index != -1){
            String sub = strs[0].substring(0,i);
            for (int j = 1; j < strs.length; j++){
                index = strs[j].indexOf(sub);
                if  (index == 0){
                    continue;
                }else {
                	System.out.println(strs[0].substring(0,j));
                	return sub;
                }
            }
            i++;
    }
    return "";
}
        
	public static void main(String[] args) {
		String[] strs = {"flower","flight","flow"};
		longestCommonPrefix(strs);
	}

}
