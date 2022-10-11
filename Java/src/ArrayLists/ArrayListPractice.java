package ArrayLists;

import java.util.ArrayList;

public class ArrayListPractice {
	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<>();
		fruits.add("Mango");
		fruits.add("Apple");
		fruits.add("Strawberry");
		fruits.add("Watermelon");
		fruits.remove("Apple"); 
		//fruits.clear();
		System.out.println(fruits);
		System.out.println(fruits.contains("Raspberry"));
	}
	
}
