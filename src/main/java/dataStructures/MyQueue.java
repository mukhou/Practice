package dataStructures;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> strQueue = new PriorityQueue<String>();
		strQueue.add("abc");
		
		Queue<String> strQueue1 = new PriorityQueue<String>();
		strQueue1.add("def");
		strQueue.peek();
		System.out.println(strQueue);
		System.out.println(strQueue1);
		strQueue = strQueue1;
		System.out.println(strQueue);

	}

}
