/*
package dataStructures;
import java.util.Vector;

public class BFS {

}
 public class BreadthFirstSearch extends SearchApplet { 
public void init(){ 
	public int [] findPath(int node_1, int node_2) {
		System.out.println("Entered BreadthFirstSearch.findPath(" + node_1 + ", " + node_2 + ")"); 
		if (node_1 == node_2) { 
			repaintPath(null, 0); return null; 
			}
		boolean [] visitedFlag = new boolean[numNodes]; 
		float [] distanceToNode = new float[numNodes]; int [] predecessor = new int[numNodes]; 
		Queue queue = new Queue(numNodes + 2); 
		int [] display_path = new int[2 * numNodes + 1]; 
		int num_display_path = 0; 
		for (int i=0; i 0) { 
			 display_path[num_display_path++] = ret2[i-1]; 
			 display_path[num_display_path++] = ret2[i]; } }
	 repaintPath(display_path, num_display_path); 
	 return ret2; } 
 protected class Queue { 
	 public Queue(int num) {
		 queue = new int[num];
		 head = tail = 0; 
		 len = num; 
		 }
	 public Queue() { 
		 this(400);
		 }
	 private int [] queue;
	 int tail, head, len;
	 public void enqueue(int n) {
		 queue[tail] = n; 
		 if (tail >= (len - 1)) {
			 tail = 0;
			 } else {
				 tail++;
				 }
		 } public int dequeue() { 
			 int ret = queue[head];
			 if (head >= (len - 1)) {
				 head = 0;
				 } else {
					 head++; 
					 } return ret;
					 }
		 public boolean isEmpty() { 
			 return head == (tail + 1);
			 }
		 public int head() {
			 return queue[head]; 
			 }
		 }
 protected int [] connected_nodes(int node) { 
	 int [] ret = new int[SearchApplet.MAX]; 
	 int num = 0;
	 for (int n=0; n
		}
		}
	}
}*/
