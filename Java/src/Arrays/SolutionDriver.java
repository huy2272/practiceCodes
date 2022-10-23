package Arrays;

import HashMap.dayOfTheWeek;

public class SolutionDriver {
	public static void main(String[] args) {
		//Testing twoSum
    	Solution s= new Solution();
		int[] nums = {2,15,11,7};
		int target =9;
		s.twoSum(nums, target);
		
		//Testing for dayOfTheWeek
		dayOfTheWeek j =  new dayOfTheWeek();
		j.solution();
		
		//Testing isValid
		s.isValid("(){}[]");
	}
}
