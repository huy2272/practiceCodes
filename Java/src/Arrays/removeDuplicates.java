package Arrays;

public class removeDuplicates {
	public int remove(int[] nums) {
		//Since numsp[i] values will range from -100 to 100 we set unique number outside of that range
		int currUnique = -101;
        int counter = 0;
        
        //Iterate through the entire arr
        for (int j = 0; j < nums.length; j++){
            //If the arr element value is the same as the currUnique we bypass this element
            if (currUnique == nums[j]){continue;}
            
            //If we found a new number, we increment the counter and store it
            //We also set the new value for currUnique
            if  (currUnique != nums[j]){                
                currUnique = nums[j];
                nums[counter++] = nums[j];
            }

        }
        
        //Return the number of unique values 
        return counter;
	}
}
