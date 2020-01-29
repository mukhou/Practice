package dataStructures.stacksandqueues;

import dataStructures.ListNode;

import java.util.EmptyStackException;

public class StackUsingLinkedList {
	ListNode top;

	public int pop() {
		if (top == null)
			throw new EmptyStackException();
		int item = top.getdata();
		top = top.next;
		return item;

	}
	
	public void push(int i) {
		ListNode temp = new ListNode(i);
		temp.next = top;
		top = temp;
	}

	public int peek(){
		if(top == null)
			throw new EmptyStackException();
		return top.getdata();
	}

}
