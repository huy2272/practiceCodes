package String;

import java.util.HashMap;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;
        int[] counter = new int[123];
        for (int i = 0; i < s.length(); i++){
            int a = s.charAt(i);
            sum += a;
            map.put(s.charAt(i), a);
            counter[a]++;
        }
        for (int i = 0; i < t.length(); i++){
            if  (map.containsKey(t.charAt(i))){
                int a = map.get(t.charAt(i));
                sum -= a;
                counter[a]--;
            }
            else    {return false;}
        }
        if  (sum != 0)  {return false;}
        for (int i = 0; i < 122; i++){
            if  (counter[i] != 0){
                return false;
            }
        }
        
        return true;
    }
}
