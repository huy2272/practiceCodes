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

	static boolean searchInsert(int[] nums, int target) {
		// This solution time complexity is O(log n)
		// We start at the middle point and see if the target value is bigger or smaller
		// If smaller we set the middle point as the new end point
		// If bigger we set the middle point as the new start point
		// middle point = (start + end) / 2
		// If middle point is == target value, return middle
		// Big-Oh (log n) constant < log n < n < n log n < n^2 < n^3 < 2^n
		int count = 0;
		int start = 0;
		int end = nums.length;
		while (start < end) {
			// Divide the arr into two and start comparing in the middle
			int mid = (start + end) / 2;
			// If the middle number is bigger than the target
			// make the mid index the new end point and loop again
			if (nums[mid] > target) {
				end = mid;
			} else if (nums[mid] == target) {
				for (int i = start; i < end; i++) {
					if (nums[i] == target)
						count++;
				}
				if (count == 5)
					return true;
				return false;
			}
			// If middle number is smaller than target
			// set the start point to ++mid, make sure to pre-increment the mid value
			else {
				start = ++mid;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 1 };
		int x = 1;
		System.out.println(searchInsert(arr, x));
	}
}
