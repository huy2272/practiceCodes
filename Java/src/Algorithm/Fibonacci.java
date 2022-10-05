package Algorithm;

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
	
	public static void main(String[] args) {
		Fibonacci test = new Fibonacci();
		//System.out.println(test.fib(3));
		System.out.println(test.oddonacci(5));
		System.out.println(test.oddonacci(10));
		System.out.println(test.oddonacci(15));
	}
}
