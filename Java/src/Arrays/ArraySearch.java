package Arrays;

public class ArraySearch {
	static boolean search(int[] arr, int x) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				count++;
		}

		if (count == 5)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 1, 2 };
		int x = 2;
		System.out.println(search(arr, x));
	}
}
