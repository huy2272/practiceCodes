package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> answer = new ArrayList<>();
        
        int[] dict = new int[26];
        for (int i =0; i< A[0].length(); i++){
            dict[A[0].charAt(i) - 'a']++;
        }
        
        for (int i = 1; i < A.length; i++){
            int[] curr = new int[26];
            for (int j = 0; j < A[i].length(); j++){
                curr[A[i].charAt(j) - 'a']++;
            }
            
            for (int k = 0; k < 26; k++){
                if (curr[k]<dict[k]){dict[k]=curr[k];}
            }
        }
        
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < dict[i]; j++){
                answer.add(""+(char)('a'+i));
            }
        }
        return answer;
    }
}
