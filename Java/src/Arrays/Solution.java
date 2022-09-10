//package Arrays;
//
//import java.util.Arrays;
//
//public class Solution {
//	
//	public Solution() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                	int[] array = {i,j};
//                	System.out.println(Arrays.toString(array));
//                    return array;
//                }
//            }
//        }
//        return null;
//    }
//}
package Arrays;
import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 */
public class Solution
{
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
	
	public static float[]  meanAndMode(float[] inputArr)
	{
		float[]  answer = new float[100];
		// Write your code here
		
		float mean = 0f;
		for	(int i = 0; i< inputArr.length; i++){
			mean = (mean + inputArr[i])/inputArr.length;
		}
		
		answer[0] = mean;

		float maxValue = 0.0f;
		int maxCount =0;
		int count =0;
		for	(int j =0; j< inputArr.length; j++ ){
			count = 0;
			for (int k =0; k<inputArr.length; k++){
				if (inputArr[j] == inputArr[k]){count++;}
			}
			if(count < maxCount){break;}
			else{maxCount = count; maxValue = inputArr[j];}
		}

		answer[1] = maxValue;

		return answer;
	}
	
	public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++){
            int initBracket = (int) s.charAt(i);
            int nxtBracket = (int) s.charAt(++i);
            if	(nxtBracket == ++initBracket) {return true;}
            else	{break;}
        }
        return false;
    }
}
