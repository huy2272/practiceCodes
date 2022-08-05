package Arrays;
public class Prime {
	int[] prime = {2,0,0};
	int size = 1;
	
	public Prime() {
		super();
	}

	public void printPrimes(int n) {
		
		//Check if n > array size
		//If n is bigger than current prime array size
		//Call makeNewArr() which returns a new twice as big arr
		//Pass this new arr through findPrime method
		int arrSize = prime.length;
		if (n >= arrSize) {
			
			//Increase array size until it is bigger than n
			do {
				arrSize+=arrSize;
			} while (arrSize <= n);
			
			//Make a new array with the new array size
			int[] newArr = makeNewArr(arrSize, prime);
			findPrime(newArr,n);
			System.out.println("Printing " + n + " prime numbers: ");
			for	(int j = 0; j<size;j++) {System.out.println(newArr[j]);}
		} 
		// if n < = 1
		else if (n <= 1){
			System.out.println("Printing " + n + " prime numbers: ");
			for	(int k = 0; k < n; k++) {System.out.println(prime[k]);}
		}
		
		else {
			findPrime(prime,n);
			System.out.println("Printing " + n + " prime numbers: ");
			for	(int j = 0; j<size;j++) {System.out.println(prime[j]);}
		}
	}
	
	public int[] makeNewArr(int arrSize, int[] a) {
		int[] newPrime = new int[arrSize];
		System.arraycopy(a, 0, newPrime, 0, a.length);
        return newPrime;
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
		
		int localMax = findMax(arr);
		do {
			//Increment biggest prime number by 1
			localMax++;
			
			//Loop through the array until index[size]
			//Divide max by every prime numbers inside prime[]
			//Size = number of prime numbers within the array
			int mod = 0;
			for (int i =0; i< size;i++) {
				mod = localMax%arr[i];
				
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
	

	public static void main(String[] args) {
		Prime prime1 = new Prime();
		prime1.printPrimes(0);
		prime1.printPrimes(1);
		prime1.printPrimes(2);
		prime1.printPrimes(10);
	}
}
