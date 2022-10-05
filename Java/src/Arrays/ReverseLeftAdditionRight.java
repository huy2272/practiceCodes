package Arrays;

import java.util.Arrays;

public class ReverseLeftAdditionRight {
	
	static int[] reverseAndAdd(int[] arr) {
		int mid = arr.length/2;
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
		System.out.println(Arrays.toString(arr));
		return arr;
	}
	
	public static void main(String[] args) {
		int[] test1 = {1,2,3,4,5,6,7,8};
		ReverseLeftAdditionRight test = new ReverseLeftAdditionRight();
		test.reverseAndAdd(test1);
	}
}
