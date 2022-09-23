package LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzList {
	public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i < n+1; i++){
            if  (i%3 == 0 && i%5 == 0){
                answer.add("FizzBuzz");
            }
            else if (i%3 == 0){
                answer.add("Fizz");
            }
            else if (i%5 == 0){
                answer.add("Buzz");
            }
            else {
                String j =  String.valueOf(i);
                answer.add(j);
            }
        }
        return answer;
    }
}
