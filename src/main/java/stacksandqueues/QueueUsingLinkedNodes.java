package stacksandqueues;
import dataStructures.*;

import java.util.LinkedHashMap;

public class QueueUsingLinkedNodes {
	
	// head is at the head (left end) (LRU)
	// back is at the back(right end)
	ListNode front, back;

	
	public Object dequeue(ListNode n){
		if(front != null){
			Object item = front.getdata();
			front = front.next;
			return item;
		}
		return null;
		
		
	}
	
	public void enqueue(Object data){
		if(front == null){
			ListNode temp = new ListNode(data);
			front = temp;
		}else{
			ListNode temp = new ListNode(data);
			back.next = temp;
			back = temp;
		}
	}

    public boolean isEmpty(){
        return front == null;
    }
	

}
