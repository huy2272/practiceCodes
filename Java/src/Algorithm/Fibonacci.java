package Algorithm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Fibonacci {
//	static int fib(int n) {
//		if	(n <= 1) {return n;}
//		
//		int[] arr = new int[n+1];
//		
//		arr[0]=0;
//		arr[1]=1;
//		
//		for	(int i = 2; i <= n; i++) {
//			arr[i] = arr[i-1] + arr[i-2];
//		}
//		
//		return arr[n];
//	}

	// Find the oddonacci sequence iteratively
//	static int oddonacci(int n) {
//		if	(n <= 2) {return n;}
//		
//		int[] arr = new int[n+1];
//		
//		arr[0]=1;
//		arr[1]=1;
//		arr[2]=1;
//		
//		//Since we are iterating to n and we only have one for loop
//		//The time complexity should be O(n)
//		for	(int i = 3; i <= n; i++) {
//			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
//		}
//		
//		return arr[n];
//	}
	static int oddoTail(int n, int a, int b, int c) {

		if (n == 1)
			return a;
		return oddoTail(n - 1, b, c, a + b + c);
	}

	private static long[] oddonacciCache;

	static int oddonacciRecursive(int n) {
		// We set the first 3 elements
		// Then by using these base elements we can calculate the rest of the sequence
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		// Here the time complexity is horrible, it is exponential it should be 3^n
		// (Ternary recursion???)
		// To improve we have to use linear recursion
		else
			return oddonacciRecursive(n - 1) + oddonacciRecursive(n - 2) + oddonacciRecursive(n - 3);
	}

	static long oddonacci(int n) {
		if ((n == 0) || (n == 1) || (n == 2)) // The first 3 values predetermined for the oddonacci sequence
			return 1;

		else if (n <= 1) {
			return n;// base case
		}

		if (oddonacciCache[n] != 0) {// check if the cache already has a value inside it
			return oddonacciCache[n];
		}

		long nthOddonacciNumber = (oddonacci(n - 1) + oddonacci(n - 2) + oddonacci(n - 3));// oddonacci number at n
		oddonacciCache[n] = nthOddonacciNumber;// storing the oddonaccis already calculated within the array

		return nthOddonacciNumber;
	}


}
