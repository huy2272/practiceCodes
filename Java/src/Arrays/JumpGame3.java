package Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class JumpGame3 {
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
		File file = new File("in.txt");
		Scanner sc;
		FileOutputStream fout;		
		try {
			sc = new Scanner(file);
			sc.nextLine();
			while (sc.hasNextLine()) {
				String s=sc.nextLine();
				String[] strArr = s.split(" ");
				int size = Integer.parseInt(strArr[0]);
				int start = Integer.parseInt(strArr[1]);
				int[] intArr = new int[size];
				for	(int i = 0; i < strArr.length-2; i++) {
					intArr[i] = Integer.parseInt(strArr[i+2]);
				}
				System.out.println(Arrays.toString(intArr));
				fout = new FileOutputStream("Out.txt", true);
				PrintWriter writer = new PrintWriter(fout);
				writer.write(String.valueOf(solRecursive(intArr, start))+"\n");
				writer.write(String.valueOf(solStack(intArr, start))+"\n");
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.print("Error while reading or writing to file");
			e.printStackTrace();
		}
	}
}


