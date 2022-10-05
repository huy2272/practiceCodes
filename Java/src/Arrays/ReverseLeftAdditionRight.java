package Arrays;

import java.util.Arrays;

public class ReverseLeftAdditionRight {
	
	static int[] reverseAndAdd(int[] arr) {
		int mid = arr.length/2;
		if(arr.length%2==0) {
			for	(int i = 0; i < mid ; i++) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				i++;
			}
			
			for	(int i = mid; i < arr.length; i++ ) {
				int temp = arr[i];
				arr[i+1] += temp;
				i++;
			}
		}
		else {
			int oddMid = mid-1;
			for	(int i = 0; i < oddMid ; i++) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				i++;
			}
			
			for	(int i = mid+1; i < arr.length-1; i++ ) {
				int temp = arr[i];
				arr[i+1] += temp;
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	
	public static void main(String[] args) {
		int[] test1 = {1,2,3,4,5,1,2,3,4};
		ReverseLeftAdditionRight test = new ReverseLeftAdditionRight();
		test.reverseAndAdd(test1);
	}
}
