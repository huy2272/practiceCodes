package LinkedLists;

import java.util.Iterator;
import java.util.LinkedList;


public class LinkedListsPractice {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(7);
		list.add(8);
		list.add(9);
		
		list.remove();
		
		
		System.out.println(list.get(1));
		
		//Iterate through the list
		
		Iterator iterate = list.iterator();
		
		while(iterate.hasNext()) {
			if	((int) iterate.next() == 8) {
				System.out.println("We found 8");
			}
		}
	}
}
