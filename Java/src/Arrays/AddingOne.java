package Arrays;

public class AddingOne {
    public int[] plusOne(int[] digits) {
    	//Just increment the index by 1 if it's not 9
        for (int i = digits.length - 1; i >= 0; i--){
            if  (digits[i]!=9){
                digits[i]++;
                break;
            }
            //If the index is 9 then we go to zero and continue the loop one more time
            else{
                digits[i] = 0;
            }
        }
        
        //If the first index is 0 it means we need a bigger arr
        if  (digits[0] == 0){
            int[] answer = new int[digits.length + 1];
            //The bigger arr will always start with 1
            answer[0]++;
            return answer;
        }
        return digits;
    }
}
