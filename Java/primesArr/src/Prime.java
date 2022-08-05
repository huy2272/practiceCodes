import java.util.Arrays;

public class Prime {
	int[] prime = {2,0,0,0,0,0,0,0,0,0,0};
	int size = 1;
	
	public Prime() {
		super();
	}

	public void printPrimes() {
		
		//Check if n > size, find more primes
//		if (n > size) {
//			//findPrime
//		}
		
		//Search each integer larger than the last known prime until it finds another prime
		//Check that the current integer is not divisible by each of the known prime
		
		
		//If size = size of prime array, create a new array that is twice the size
		//Then copy the original data to the new array
		
		//Print the first n primes
		
		
	}
	
	public void findPrime(int[] arr, int n) {
		//Find largest prime
		int max = 2;
		for	(int i =0; i<arr.length; i++) {
			if	(arr[i] > max) {max = arr[i];}
		}

		if (size < n) {
			for (int j = size; j<arr.length;j++) {
				arr[j] = 1;
			}
		}
		
		int counter = 1;
		do {
			
			max++;
			System.out.println("Max " + max);
			//Loop through the entire array and check if new integer divides any element
			for (int i = 0; i<arr.length;i++) {
				System.out.println((max%arr[i]));;
				if (max%2 == 0){break;}
				if (max%arr[i] == 0) {break;}
				else{
					{arr[counter] = max;}
					counter++;
				}				
			}
			size++;
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
		prime1.findPrime(prime1.getPrime(), 8);
		System.out.println(Arrays.toString(prime1.getPrime()));
		System.out.println(prime1.getSize());
	}
}
