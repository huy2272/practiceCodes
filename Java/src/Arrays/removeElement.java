package Arrays;

public class removeElement {
	//given an arr and a value, remove all element == value
	//Then move all the remaining values to the front of the arr
	public int remove(int[] nums, int val) {
        int removeNum = val;
        int counter= 0;
        for (int i =0; i<nums.length;i++){
            if  (removeNum != nums[i]){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}
