package dataStructures;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
	ListItem head;
	
	public DoublyLinkedList(){
		head = new ListItem(null);
	    head.next = head.previous = head;
	}
	
	/*
	  * remove all elements in the list
	  */
	  public final synchronized void clear() {
	    head.next = head.previous = head;
	  }

	 /*
	  * returns true if this container is empty.
	  */
	  public final boolean isEmpty() {
	    return head.next == head;
	  }

	 /*
	  * insert element after current position
	  */
	  public final synchronized void insertAfter(Object obj, ListIterator cursor) {
		  ListItem temp = new ListItem(cursor.pos, obj, cursor.pos.next);
		  temp.next.previous = temp;
		  cursor.pos.next = temp;
	  }

	  /*
	   * insert element before current position
	   */
	   public final synchronized void insertBefore(Object obj, ListIterator cursor){
		   ListItem temp = new ListItem(cursor.pos.previous, obj, cursor.pos);
		   temp.previous.next = temp;
		   cursor.pos.previous = temp;
	   }
	   
	   /*
	    * remove the element at current position
	    */
	    public final synchronized void remove(ListIterator cursor) {
	      if (isEmpty()) {
	        throw new IndexOutOfBoundsException("empty list.");
	      }
	      if (cursor.pos == head) {
	        throw new NoSuchElementException("cannot remove the head");
	      }
	      cursor.pos.previous.next = cursor.pos.next;
	      cursor.pos.next.previous = cursor.pos.previous;
	    }

	    /*
	     * find the first occurrence of the object in a list
	     */
	     public final synchronized ListIterator find(Object obj) {
	       if (isEmpty()) {
	         throw new IndexOutOfBoundsException("empty list.");
	       }
	       ListItem pos = head;
	       while (pos.next != head) {  // There are still elements to be inspected
	         pos = pos.next;
	         if (pos.obj == obj) {
	           return new ListIterator(this, pos);
	         }
	       }
	       throw new NoSuchElementException("no such object found");
	     }
}
