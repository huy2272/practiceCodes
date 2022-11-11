package Arrays;

public class StrikeEdgeA {
	
	public StrikeEdgeA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int solRecursive(int[] arr, int start) {
        if(start<0 || start>=arr.length || arr[start]<0) {return 0;}
        if(arr[start]==0) {return 1;}
        arr[start]= -arr[start];
        //Go left until it stops working
        int ans1 = solRecursive(arr,start+arr[start]);
        //Then go right from the call that it stops working and work backwards
        int ans2 = solRecursive(arr,start-arr[start]);
        arr[start]= -arr[start];
        return ans1|ans2;        
    }
}
