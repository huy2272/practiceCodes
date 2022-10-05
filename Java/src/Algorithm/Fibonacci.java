package Algorithm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Fibonacci {
	static int fib(int n) {
		if	(n <= 1) {return n;}
		
		int[] arr = new int[n+1];
		
		arr[0]=0;
		arr[1]=1;
		
		for	(int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}
	
	static int oddonacci(int n) {
		if	(n <= 2) {return n;}
		
		int[] arr = new int[n+1];
		
		arr[0]=1;
		arr[1]=1;
		arr[2]=1;
		
		for	(int i = 3; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		return arr[n];
	}
	
	static int oddonacciRecursive(int n) {
		if(n==0) return 1;
        if(n==1) return 1;
        if(n==2) return 1;
        else 
            return oddonacciRecursive(n-1)+oddonacciRecursive(n-2)+oddonacciRecursive(n-3);
	}
	
	public static void main(String[] args) {
		Fibonacci test = new Fibonacci();
		try {
			File obj = new File("OddoOut.txt");
			if (obj.createNewFile()) {System.out.println("File created: " + obj.getName());} 
			else {System.out.println("File already exists.");}
			
			FileOutputStream fout = new FileOutputStream("OddoOut.txt");
			PrintWriter writer = new PrintWriter(fout);
			for (int i = 5; i <= 20; i=i+5) {
				writer.write(String.valueOf(test.oddonacciRecursive(i)));
				writer.println();
			}
			writer.flush();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("An error occurred when trying to write to a file");
			e.printStackTrace();
		}
	}
}
