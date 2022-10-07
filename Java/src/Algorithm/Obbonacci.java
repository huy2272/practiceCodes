package Algorithm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Obbonacci {
	// method for linear time

	private static long[] oddonacciCache;
	// instead of deleting the oddonacci sequnce after every iteration we can hold
	// the value in an array
	// with this array we do not have to keep recalculating the oddonacci numbers
	// already solved
	// concept called memorization

	private static long oddonacci(int n) {
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

	static int oddonacciRecursive(long n) {// exponential time
		// We set the first 3 elements
		// Then by using these base elements we can calculate the rest of the sequence
		if (n == 0 || n == 1 || n == 2)
			return 1;
		// Here the time complexity is horrible, it is exponential it should be 3^n
		// (Ternary recursion???)
		// To improve we have to use linear recursion
		else
			return oddonacciRecursive(n - 1) + oddonacciRecursive(n - 2) + oddonacciRecursive(n - 3);
	}
	
	static int oddoTail(int n, int a, int b, int c) {
	// This is the base case, when n == 1 we return whatever value parameter a holds
		if (n == 1)
			return a;
		// Each time we loop through parameter a value will be discarded and parameter a = parameter b, value b = value c
		// parameter c will be the new oddonacci number which is a + b +c
		return oddoTail(n - 1, b, c, a + b + c);
	}
	
	public static void main(String[] args) {
		int n = 40;
		oddonacciCache = new long[n + 1];
		long start = System.currentTimeMillis();
		try {
			File obj = new File("OddoOut.txt");
			// File obj2 = new File("TimeOddo.txt");

			if (obj.createNewFile()) {
				System.out.println("File created: " + obj.getName());
			} else {
				System.out.println("File already exists.");
			}

			FileOutputStream fout = new FileOutputStream("OddoOut.txt");
			PrintWriter writer = new PrintWriter(fout);
			FileOutputStream fout2 = new FileOutputStream("TimeOddo.txt");
			PrintWriter writer2 = new PrintWriter(fout2);

			for (int i = 0; i <= n; i++) {
//				writer.write(String.valueOf(oddonacci(i)));
//				writer.write(String.valueOf(oddoTail(n,1,1,1)));
				writer.write(String.valueOf(oddonacci(i)));
				writer.println();

				//Record the time of every 5 oddonacci number
				if (i % 5 == 0) {
					long current = System.currentTimeMillis() - start;
					writer2.write("Run time:");
					writer2.write(String.valueOf(current));
					writer2.println();
				}

			}
			writer.flush();
			writer2.flush();

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("An error occurred when trying to write to a file");
			e.printStackTrace();
		}

	}
}
