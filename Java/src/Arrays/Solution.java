package Arrays;

import java.util.Arrays;

public class Solution {
	
	public Solution() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                	int[] array = {i,j};
                	System.out.println(Arrays.toString(array));
                    return array;
                }
            }
        }
        return null;
    }
}
