package Arrays;

import java.util.Stack;

public class BaseballGame682 {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for (String str : operations){
            if  (str.equals("C")){
                s.pop();
            }
            else if  (str.equals("D")){
                int a = (2*s.peek());
                s.push(a);
            }
            else if  (str.equals("+")){
                int top = s.pop();
                int sum = top + s.peek();
                s.push(top);
                s.push(sum);
            }
            else    {s.push(Integer.parseInt(str));}
            
        }
        
        int tot = 0;
        while (!s.isEmpty()){
            tot += s.pop();
        }

        return tot;
    }
}
