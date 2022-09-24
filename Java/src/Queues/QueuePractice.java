package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePractice {
	public static void main(String[] args) {
		Queue<String> line = new LinkedList<>();
		
		line.add("Jackson");
		line.add("Tyreek");
		line.add("Susan");
		
		//Take out the first object that got in
		line.poll();
		
		//Take out the second object that got in
		System.out.println(line.poll());
		
		//Peek at the next object in line without taking it out of queue
		System.out.println(line.peek());
		
		Queue<String> q = new LinkedList<>();
		
		q.add("A");
		q.add("B");
		q.add("C");
		
		//.toArray method turns the queue into an array
		//We can access it like a normal arr
		System.out.println(q.toArray()[2]);
	}
}
