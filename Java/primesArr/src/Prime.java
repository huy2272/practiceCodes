import java.util.Arrays;

public class Prime {
	int[] prime = {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int size = 1;
	
	public Prime() {
		super();
	}

	public void printPrimes(int n) {
		
		//Check if n > size, find more primes
		if (n > size) {
			findPrime(prime,n);
			for	(int j = 0; j<size;j++) {System.out.println(prime[j]);}
		}
		
		
		
		
		//If size = size of prime array, create a new array that is twice the size
		//Then copy the original data to the new array
		
		//Print the first n primes
		
		
	}
	
	//Find largest prime
	public int findMax(int[] arr) {
		int max = 2;
		for	(int i =0; i<arr.length; i++) {
			if	(arr[i] > max) {max = arr[i];}
		}
		return max;
	}
	
	//Search each integer larger than the last known prime until it finds another prime
	//Check that the current integer is not divisible by each of the known prime
	public void findPrime(int[] arr, int n) {
		
//		int max = 2;
//		for	(int i =0; i<arr.length; i++) {
//			if	(arr[i] > max) {max = arr[i];}
//		}
		
		int localMax = findMax(prime);
		do {
			//Increment biggest prime number by 1
			localMax++;
			System.out.println("Max " + localMax);
			int mod = 0;
			//Loop through the array until index[size]
			//Divide max by every prime numbers inside prime[]
			//Size = number of prime numbers within the array
			for (int i =0; i< size;i++) {
				mod = localMax%arr[i];
				System.out.println("mod: " + mod);
				System.out.println("size: " + size);
				//If mod = 0, it means max divides the prime number
				//Therefore max is not prime
				if	(mod == 0) {break;}
			}
			//If mod != 0, then it means the new max is not divisible by any element
			//Therefore max is a new prime
			//Size increment by 1
			if	(mod != 0) {arr[size]=localMax; size++;}
		} while (size < n);
		
		
	}
	
	
	
	public int[] getPrime() {
		return prime;
	}

	public void setPrime(int[] prime) {
		this.prime = prime;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static void main(String[] args) {
		Prime prime1 = new Prime();
//		prime1.findPrime(prime1.getPrime(), 10);
//		System.out.println(Arrays.toString(prime1.getPrime()));
//		System.out.println(prime1.getSize());
		prime1.printPrimes(10);
	}
}
