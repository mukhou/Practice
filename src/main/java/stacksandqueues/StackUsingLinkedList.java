package stacksandqueues;

import dataStructures.ListNode;

public class StackUsingLinkedList {
	ListNode top;

	public int pop() {
		if (top == null)
			return -1;
		int item = top.getdata();
		top = top.next;
		return item;

	}
	
	public void push(int i){
		ListNode temp = new ListNode(i);
		top.next = temp;
		top = temp;
	}

}
