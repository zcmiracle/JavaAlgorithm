package com.zc;
import com.zc.queue.PriorityQueue;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Person> queue = new PriorityQueue<>();
		queue.enQueue(new Person("James", 38));
		queue.enQueue(new Person("Rose", 29));
		queue.enQueue(new Person("Jake",  39));
		queue.enQueue(new Person("Jordan", 45));
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}

}
