package dataStructures.stacksandqueues;
import dataStructures.*;

import java.util.NoSuchElementException;

public class QueueUsingLinkedList {
	
	// head is at the front (left end) (LRU)
	// back is at the back(right end)
	ListNode front, back;

	
	public Object dequeue(ListNode n){
		if(front == null){
			throw  new NoSuchElementException();
		}
		int data = front.getdata();
		front = front.next;
		if(front == null){
			back = null;
		}
		return data;
	}
	
	public void enqueue(Object data){
		ListNode temp = new ListNode(data);
		if(back != null){
			back.next = temp;
		}
		back = temp;
		if(front == null) {
			front = back;
		}
	}

    public boolean isEmpty(){
        return front == null;
    }
	

}
