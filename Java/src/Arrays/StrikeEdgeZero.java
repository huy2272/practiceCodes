package Arrays;
import java.util.Stack;
public class StrikeEdgeZero {
    static int solRecursive(int[] arr, int start) {
        if(start<0 || start>=arr.length || arr[start]<0) {return 0;}
        if(arr[start]==0) {return 1;}
        arr[start]= -arr[start];
        //Go right until it stops working
        int ans1 = solRecursive(arr,start+arr[start]);
        //Then go left from the call that it stops working and work backwards
        int ans2 = solRecursive(arr,start-arr[start]);
        arr[start]= -arr[start];
        return ans1|ans2;        
    }
	static int solStack(int[] arr, int start) {
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
            
            arr[curr] = -arr[curr];   //This is not great since we are changing the inputs
        }
        return 0;		
	}
	public static void main(String[] args) {
		
		int[] arr = {4,8,5,2,3,5,1,6,4,0};
		int[] arr2 = {5,8,2,3,1,5,0};
		int[] arr3 = {1,1,1,1,1,1,0};
		System.out.println("Result for recursive function: " + solRecursive(arr, 0));
		System.out.println("Result for recursive function: " + solRecursive(arr2, 0));
		System.out.println("Result for recursive function: " + solRecursive(arr3, 0));
		System.out.println("Result for stack function: " + solStack(arr, 0));
		System.out.println("Result for stack function: " + solStack(arr2, 0));
		System.out.println("Result for stack function: " + solStack(arr3, 0));
	}
}
