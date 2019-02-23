package stacksandqueues;
import dataStructures.*;

public class MyQueue {
	
	// first is at the head (right end), LRU element
	// last is at the tail(left end)
	ListNode first, last;
	
	public Object dequeue(ListNode n){
		if(first != null){
			Object item = first.getdata();
			first = first.next;
			return item;
		}
		return null;
		
		
	}
	
	public void enqueue(Object data){
		if(first == null){
			ListNode back = new ListNode(data);
			first = back;
		}else{
			ListNode temp = new ListNode(data);
			last.next = temp;
			last = temp;
		}
	}
	

}
