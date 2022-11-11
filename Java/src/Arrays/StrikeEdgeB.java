package Arrays;

import java.util.Stack;

public class StrikeEdgeB {
	
	public StrikeEdgeB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int solStack(int[] arr, int start) {
        int n = arr.length; 
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            
            if (arr[curr] == 0) {return 1;}
            
			// reached this index again, so not possible from this index but might be possible to reach from other direction, so check again in the queue
            if (arr[curr]<0) {continue;}   
            
            if (curr + arr[curr] < n)
                stack.push(curr + arr[curr]);
            if (curr - arr[curr] >= 0)
                stack.push(curr - arr[curr]);
            
            arr[curr] = -arr[curr];
        }
        return 0;		
	}
}
