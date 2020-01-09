package dataStructures;

import stacksandqueues.StackUsingArray;

import java.util.HashMap;
import java.util.Map;


public class LinkedList {
	
	private Node head;
	private int listCount;
	
	// this is an empty list, so the reference to the head node
	// is set to a new node with no data
	public LinkedList(){
		head = new Node(null);
		listCount = 0;
	}

	/**
	 * IMPORTANT: BLOOMBERG INTERVIEW QUESTION
	 * Given head of a linked list and a data value, remove all those nodes from the list
	 * whose data matches the given value.
	 */

	public static Node removeNodesWithValue(Node head, int data){
		if(head == null){
			return null;
		}
		while((int)head.data == data){
			head = head.next;
		}

		Node prev = head;
		Node temp = head.next;
		while(temp != null){
			if((int)temp.data == data){
				prev.next = temp.next;
				temp.next = null;
				temp = prev.next;//set new temp
			}else{
				prev = temp;
				temp = temp.next;
			}
		}
		return head;
	}

    /**
     *
     */
    public static void printLL(Node n) {
        Node temp;
        boolean isInSequence = false;
        while (n.next != null) {
            temp = n;
            while (n.next != null && (Integer)n.data + 1 == (Integer)n.next.data) {
                isInSequence = true;
                n = n.next;
            }

            if (isInSequence) {
                System.out.print(temp.data + "-" + n.data + ", ");
                isInSequence = false;
                if (n.next != null) {
                    n = n.next;
                }
            } else {
                System.out.print(n.data + ", ");
                n = n.next;
            }
        }
        System.out.println(n.data);
    }
	
	/**
	 * given an element(data), adds a node to the end of the list
	 */
	Node InsertAtTail(Node head,int data) {
		Node n = new Node(data);
		if(head == null){
			head = n;
			return head;
		}else {
			Node curent = head;
			while(curent.next != null){
				curent = curent.next;
			}
			curent.next = n;
			return head;
		}
	}
	
	/**
	 * given an element(data), adds a node to the head of the list	 
	 */
	public Node insertAtHead(Object data){
		// create the new node
		Node n = new Node(data);
		// the previous head becomes the next node of the newly created node
		n.next = head;
		head = n;
		return n;
	}

	public Node insertAtHeadOfDoublyLinkedList(Object data){
		// mandatory steps
		Node n = new Node(data);
		n.next = head;

		if(head != null){
			head.prev = n;
		}
		head = n;
		n.prev = null;
		return n;
	}
	
	/**
	 * Given an element(data), adds a node to the specified index of the list.
	 * IDEA: TRAVERSE TO THE (index -1) NODE
	 * http://www.mycstutorials.com/articles/data_structures/linkedlists
     * 5 -> 6 -> 12 -> 87 -> 3 -> 12 -> null
     * index = 3, data = 62
     * 5 -> 6 -> 12 -> 62 -> 87 -> 3 -> 12 -> null
	 */
	public Node addNodeAtIndex(Object data, int index){
		// inserts the specified element at the specified position in this list.

		Node temp = new Node(data);
        temp.next = null;

        if (head == null){
            head = temp;
            return head;
        }
        else if(index == 0){
            temp.next = head;
            head = temp;
            return head;
        }
        else{
            //find the node which is at (index -1)
            Node current = head;//5
            while((index - 1) > 0 && current.next != null){
                current = current.next;//6, 12
                index --;//2, 1

            }
            //temp = 12
            temp.next = current.next;
            current.next = temp;
            return head;
        }
	}

	/**
	 * Retrieves the data at the current node	 
	 */
	public Object getObjectAtIndex(int index){
		
		if(index<=0){
			return null;
		}
		Node current = head.getNext();
		for(int i=1; i < index && current.getNext() != null; i++){
			current = current.getNext();
		}
		// return the data of the traversed node
		return current.getData();
	}
	
	
	/**
	 * CAPITALIQ Interview question.
	 * Given a linked list, find the nth node from the end of it	 
	 * ALGORITHM:
	 * 1. Maintain two pointers – reference pointer and main pointer.
     * 2. Initialize both reference and main pointers to head.
     * 3. First move reference pointer to n nodes from head.
     * 4. Now move both pointers one by one until reference pointer reaches end.
     * 5. Now main pointer will point to nth node from the end.
     * 6. Return main pointer.
	 * 
	 */
	public Node findNodeFromEnd(Node head, int n){
        Node p1 = head;
        Node p2 = head;

        while(n -- != 0){
        	p2 = p2.next;
		}
		while(p2.next != null){
        	p1 = p1.next;
        	p2 = p2.next;
		}
		return p1;
	}
	
	
	/**
	 * PREFERRED APPROACH
	 * to reverse a Single LinkedList(shorter method, preferred)
	 * A -> B -> C -> NULL
	 */	
	public Node reverseListIterative(Node head){
		// A -> B -> C
		Node current = head;// current = A
		head = null;
		
		while(current != null){
			Node temp = current;//A, B, C
			current = current.next; //B, C, null
			temp.next = head;//  null, A, B
			head = temp;//A, B, C
		}
		return head;
	}

    //A -> B -> C -> NULL
    //initial call: reverseListRecursive(head, null)
	public Node reverseListRecursive(Node curr, Node prev) {

		/* If last node mark it head*/
		//ATM: in a LL, next can NEVER be NULL, UNLESS IT'S LAST NODE
		if (curr.next == null) {
			head = curr;
			/* Update next to prev node */
			curr.next = prev;
			return head;
		}

		/* Save curr->next node for recursive call */
		Node temp = curr.next;
		/* Update next to prev node */
		curr.next = prev;
		//recurse
		reverseListRecursive(temp, curr);
		return head;
	}

	/**
	 * reverse a doubly linked list
	 * A <=> B <=> C <=> null
	 * C <=> B <=> A <=> null
	 */
	//ATM: current and temp; temp = current.prev
	public static Node reverseDoublyLinkedListIterative(Node head) {

		Node current = head;
		Node temp = null;

		while (current != null) {
			//swap prev and next of current
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			//set current
			current = current.prev;//seems travelling backward, but actually moving forward,
			// as the prev is now the next of the original list
		}

     /* Before changing head, check for the cases like empty
        list and list with only one node */
		//#################IMPORTANT########################
		if (temp != null) {
			head = temp.prev;
		}
		return head;
	}

   	//https://www.geeksforgeeks.org/reverse-doubly-linked-list-using-recursion/
	//ATM: THE ONLY REVERSE METHOD WHERE WE DO NULL CHECK ON THE HEAD/ROOT NODE
	public static Node reverseDoublyLinkedListRecursive(Node node) {
		// If empty list, return
		if (node == null)
			return null;

		// Otherwise, swap the next and prev
		//EXACTLY SAME LIKE DLL ITERATIVE
		Node temp = node.prev;
		node.prev = node.next;
		node.next = temp;

		// If the prev is now null, the list has been fully reversed
		if (node.prev == null) {
			return node;
		}

		// Otherwise, keep going on node.prev(similar to iterative version)
		return reverseDoublyLinkedListRecursive(node.prev);
	}

	//Clone a linked list with next and random pointer
	public static Node clone(Node head){

		// Initialize two references, one with original list's head.
		Node originalHead = head;
		Map<Node, Node> map = new HashMap<>();
		while(originalHead != null){
			map.put(originalHead, new Node(originalHead.data));
			originalHead = originalHead.next;
		}

		// Adjusting the original list reference again.
		originalHead = head;
		while(originalHead != null){
			Node clone = map.get(originalHead);
			clone.next = map.get(originalHead.next);
			clone.random = map.get(originalHead.random);
			originalHead = originalHead.next;
		}

		return map.get(head);

	}

	// FOLLOW THIS: Recursive
	 void printReverseLinkedList(Node head){
        //base case
		 if(head==null)
			 return;
		 //recurse call
		 printReverseLinkedList(head.next);
		 //print
		 System.out.println(head.data);

		 return;
	}


	// Iterative
	public void printReverseLinkedList1(Node node) {
		StackUsingArray stack = new StackUsingArray();
		while (node != null) {
			stack.push((Integer)node.data);
			node = node.next;
		}
		// print the stack
		while (!stack.isEmpty())
			System.out.println(stack.pop());
	}

	/**
	 * merge two linked lists recursive
	 */
	//PREFERRED APPROACH
	static Node mergeListsRecur(Node headA, Node headB){
		if(headA == null){
			return headB;
		}
		if(headB == null){
			return headA;
		}

		Node newHead;
		if((int)headA.data < (int)headB.data){
			newHead = headA;
			//set next by recursion(just like BST recursive) by moving forward to next node
			newHead.next = mergeListsRecur(headA.next, headB);
		}else {
			newHead = headB;
			newHead.next = mergeListsRecur(headA, headB.next);
		}
		return newHead;
	}


	//EXACTLY SIMILAR LIKE a) mergesort b) merge two sorted arrays
	static Node mergeListsIter(Node headA, Node headB) {

		if(headA == null){
			return headB;
		}
		if(headB == null){
			return headA;
		}

		Node newHead = new Node();
		Node temp = newHead;//dummy node

		//check non null on both heads
		while(headA != null && headB != null){
			if((int)headA.data < (int)headB.data){
				temp.next = headA;
				headA = headA.next;
			}else {
				temp.next = headB;
				headB = headB.next;
			}
			temp = temp.next;
		}
		//while loop terminates => either headA is null or headB is null
		if(headA == null){
			temp.next = headB;
		}else if(headB == null){
			temp.next = headA;
		}

		return newHead.next;
	}

	/**
	 * IMP: Convert Sorted Linked List to BST
	 * Algorithm:
	 * 1. We first count the number of nodes in the given Linked List. Let the count be n.
	 * 2. After counting nodes, we take left n/2 nodes and recursively construct the left subtree.
	 * 3. After left subtree is constructed, we allocate memory for root and link the left subtree with root.
	 * 4. Finally, we recursively construct the right subtree and link it with root. While constructing the BST,
	 *    we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
	 */
	//https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
	BinaryNode sortedListToBST(Node head){
		int count = countNodes(head);
		return sortedListToBSTRecur(head, count);
	}

	private BinaryNode sortedListToBSTRecur(Node head, int count) {
		/* Base Case */
		if(head == null){
			return null;
		}

		/* Recursively construct the left subtree */
		BinaryNode left = sortedListToBSTRecur(head, count / 2);

		/* head_ref now refers to middle node, make middle node as root of BST*/
		BinaryNode root = new BinaryNode((int)head.data);

		// Set pointer to left subtree
		root.left = left;

		/* Change head pointer of Linked List for parent recursive calls */
		head = head.next;

		/* Recursively construct the right subtree and link it with root.
		 The number of nodes in right subtree  is  total nodes - nodes in left subtree - 1 (for root) */
		BinaryNode right = sortedListToBSTRecur(head, count - count / 2 - 1);
		root.right = right;

		return root;
	}

	private int countNodes(Node head) {
		int count = 0;
		Node temp = head;
		while(temp != null){
			temp = temp.next;
			count ++;
		}
		return count;
	}


	/*
      Find merge point of two linked lists
      head pointer input could be NULL as well for empty list
      ALGORITHM: compare each node of one head with all heads of other

    */
    int findMergeNode(Node headA, Node headB) {
        // ATM: two while loops
        while(headA != null){
            Node tempB = headB;
            while(tempB != null){
                if(headA == tempB){
                    return (int)headA.data;
                }
                tempB = tempB.next;
            }
            headA = headA.next;
        }
        return -1;
    }

    /*
      Compare two linked lists A and B
      Return 1 if they are identical and 0 if they are not.
    */
    static int compareLists(Node headA, Node headB) {
        if(headA == null && headB == null){
            return 1;
        }

        if(headA == null && headB != null){
            return 0;
        }

        if(headA != null && headB == null){
            return 0;
        }

        while(headA != null && headB != null){
            if(headA.data != headB.data){
                return 0;
            }
            headA = headA.next;
            headB = headB.next;
        }

        if(headA == null && headB != null){
            return 0;
        }

        if(headA != null && headB == null){
            return 0;
        }

        return 1;
    }


	/**
	 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes, where k is a given positive integer.
	 * For example, if the given linked list is 10->20->30->40->50->60 and k is 4, 
	 * the list should be modified to 50->60->10->20->30->40. 
	 * Assume that k is smaller than the count of nodes in linked list.
	 * Link: http://www.geeksforgeeks.org/rotate-a-linked-list/
	 * Idea: To rotate the linked list, we need to do this IN REVERSE ORDER:
     * 1. change next of kth node to NULL,
     * 2. change next of last node to previous head node.
	 * 3. change head to (k+1)th node.
	 * So we need to get hold of three nodes: kth node, (k+1)th node and last node.
	 * ALGORITHM:
	 * 1. Traverse the list from beginning and stop at kth node.
	 * 2. Store pointer to kth node. We can get (k+1)th node using kthNode->next.
	 * 3. Keep traversing till end and store pointer to last node also.
	 * 4. Finally, change pointers as stated above.
	 */
	
	public void rotateLinkedList(Node head, int k){
		if(k == 0) return;
		Node current = head;
		int counter = 0;
		// traverse till the kth node
	   //  current will point to node 40 in the above example
		while(counter < k && current.next != null){
			current = current.next;
			counter ++;
		}
		 // If current is NULL, k is greater than or equal to count
	    // of nodes in linked list. Don't change the list in this case
	    if (current == null) return;
        // got kth node
	    Node k_th_Node = current;
	    
	    // traverse till end node to get hold of last node
	    // now bring 10 to the next of 60
	    // current will point to last node after this loop
	    // current will point to node 60 in the above example
        // got last node
	    while(current.next != null){
	    	current = current.next;
	    }
	    
	    // Change next of last node to previous head
	    // Next of 60 is now changed to node 10
	    current.next = head;
	    // Change head to (k+1)th node
	    // head is now changed to node 50
	    head = k_th_Node.next;
	    // change next of kth node to NULL
	    // next of 40 is now NULL
	    k_th_Node.next = null;
	    
	}
	
	/**
	 * Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements
	 * present in the given lists. Order of elements in output lists doesn't matter.
	 * Example:
	 * Input: 
	 * List1: 10->15->4->20
	 * List2:  8->4->2->10
	 * Output:
	 * Intersection List: 4->10
	 * Union List: 2->8->20->4->15->10
	 * Idea: Use Hashing	 
	 */	
	// Union
	// 1. Create an empty hash table.
	// 2. Traverse both lists one by one, for each element being visited, look the element in hash table.
	// 3. If the element is not present, then insert the element to result list. 
	// 4. If the element is present, then ignore it.
	public Map<Object, Integer>  unionOfTwoinkedLists(Node list1_head, Node list2_head){
		
		Map<Object, Integer> map = new HashMap<Object, Integer>();
		Node current = list1_head;
		while(current.next != null){
			if(map.containsKey(current.data)){
				continue;
			}else{
				map.put(current, 1);
			}
			current = current.next;
		}
		Node current1 = list2_head;
		while(current1.next != null){
			if(map.containsKey(current.data)){
				continue;
			}else{
				map.put(current, 1);
			}
			current1 = current1.next;
		}
		
		return map;
		
	}
	
	// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
	public static int intersectionOfTwoLinkedLists(Node headA, Node headB){

		int len1 = getCount(headA);
		int len2 = getCount(headB);
		return len1 > len2 ? getIntesectionNode(len1 - len2, headA, headB) : getIntesectionNode(len2 - len1,  headB, headA);
	}

	private static int getIntesectionNode(int diff, Node headA, Node headB) {

		Node currA = headA, currB = headB;

		//move forward currA by do nodes
		for(int i = 0; i < diff; i ++){
			if(currA == null){
				return  -1;
			}
			currA = currA.next;
		}
		//start comparing
		while(currA != null && currB != null){
			//match found
			if(currA.data == currB.data){
				return (int)currA.data;
			}
			//no match, keep moving forward
			currA = currB.next;
			currB = currB.next;
		}
		return -1;
	}

	private static int getCount(Node head) {
		Node current = head;
		int count = 0;
		while(current != null){
			current = current.next;
			count++;
		}
		return count;
	}

	/**
	 * You have two numbers represented by a linked list, where each node contains a single digit. 
	 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
	 * WAP that adds the two numbers and returns the sum as a linked list.
	 * EXAMPLE 
	 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
	 * Output: 8 -> 0 -> 8
	 * ALGORITHM:
	 * Implement this recursively by adding node by node, just as we would digit by digit.
	 * 1. result.data = (left + right + any earlier carry) % 10
	 * 2. if left + right > 10, then carry a 1 to the next addition.
	 * 3. add the tails of the two nodes, passing along the carry.
	 */

	//first call, carry is 0
	public static Node addTwoLinkedLists(Node n1, Node n2, int carry){
		if(n1 == null && n2 == null){
			return null;
		}
		Node result = new Node(carry);
		int value = carry;
		if(n1 != null){
			value += ((Integer)n1.data).intValue();
		}
		if(n2 != null){
			value += ((Integer)n2.data).intValue();
		}
		result.data = value % 10;
		//RECURSIVE CALL
		Node temp = addTwoLinkedLists(n1 == null ? null : n1.next,
									  n2 == null ? null : n2.next,
									 value >= 10 ? 1 : 0);
		//set next
		result.setNext(temp);
		return result;
		
	}
	
	/**
	 * Delete node from the middle of a linked list.
	 * v->w->x->y->z becomes v->w->y->z	 
	 * ALGORITHM:
	 * 1. simply copy the data of the next of the middle to the middle
	 * 2. so that the next of middle becomes the middle
	 * 3. Remove the next of middle which is no longer required
	 * 4. point the middle to next of next
	 */

    // career cup book solution - FOLLOW THIS
    public static boolean deleteNode(Node middle) {
        if (middle == null || middle.next == null) {
            return false; // Failure
        }
        Node temp = middle.next;
        middle.data = temp.data;
        middle.next = temp.next;
        return true;
    }

	public static void deleteNodeOfDoubleLinkedList(Node head, Node node) {
		if(node.prev != null){
			node.prev.next = node.next;
		}else {//it is the head node
			head = node.next;
		}
		if(node.next != null){
			node.next.prev = node.prev;
		}
	}

    public Node insertIntoSortedList(Node head, int data){
        Node n = new Node(data);
        n.next = null;
        n.prev = null;

        if(head == null){
            n = head;
            return head;
        }

        if((int)head.data > data){
            n.next = head;
            head.prev = n;
            head = n;
            return head;
        }
        Node current = head;
        while(current.next != null){
            if((int)current.next.data > data){
                current.next.prev = n;
                n.next = current.next;
                n.prev = current;
                current.next = n;
                return head;
            }
            //move forward
            current = current.next;
        }

        //reached end of list, now insert anyway
        current.next = n;
        n.prev = current;
        return head;

    }

    /**
     * Delete a note from a given position
     * 5 -> 6 -> 12 -> 87 -> 3 -> 12 -> null
     * index = 3 => Node with data 87
     */
    //NEED TWO POINTERS
    public Node deleteAtIndex(Node head, int index){
		if(index < 1 || index > size()){
			return head;
		}
        if(head==null)
            return null;

        //need two pointers here: prev and current(initialized to head)
        // 1. prev to keep track
        // 2. current to be the one deleted
        Node current = head;
        Node prev = null;

        if(index == 0){
            head = head.next;
            current.next = null;
            return head;
        }

        //ATM: only check on index and nothing else
        //prev should land at (index - 1), current should be at index
        while(index > 0){
            prev = current; //5, 6, 12
            current = current.next; //6, 12, 87
            index --;//2, 1, 0
        }

        prev.next = current.next;
        current.next = null;
        return head;
    }

	/**
	 * Delete a node for a given data
	 */
	public Node deleteNodeByData(Node head, int d){
		Node current = head;
		if(current.data.equals(d)){
			return current.next;
		}
		while(current.next != null){
			if(current.next.data.equals(d)){
				current.setNext(current.next.next);
				return current;
			}
			current = current.next;
		}
		return current;
	}

	
	/**
	 * IMPORTANT: Remove duplicates from a linked list
	 * A -> B -> A -> C
	 * ALGORITHM:
	 * 1. For each node(starting from head, keep track of previous and next
	 * 2. Remove if the dups
	 */
	public static Node removeDuplicates(Node head){

		if(head == null){
			return null;
		}

		//two pointers to track prev and next
		Node prev = head;
		Node temp = head.next;

		while(temp != null){
			if(prev.data == temp.data){
				prev.next = temp.next;
				temp.next = null;
				//IMP: move temp forward by setting prev.next
				temp = prev.next;
			}else {
				prev = temp;
				temp = temp.next;
			}
		}
		return head;
	}
	
	/** 
	 * Find the middle of a linked list.
	 * Algorithm:
	 * Step 1: Start with two pointers both pointing to start of the list.
	 * Step 2: Increment one pointer by one and second pointer by two.
	 * Step 3: When traversing the list is done by second pointer, 
	 * the first pointer will be at the middle of the List.
	 */
	public Node findMiddleNode(){
		Node p1 = head, p2 = head;
		while(p2.next != null){
			// Increment first time
			p2 = p2.next;
			if(p2.next != null){
				// Increment second time
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		return p1;
	}
	
	/**
	 * Determine if a linked list has a loop.
	 * Algorithm:
	 * The solution runs in O(N) time and uses O(1) space. 
	 * It uses two pointers (one slow pointer and one fast pointer). 
	 * The slow pointer advances one node at a time, while the fast pointer traverses twice as fast. 
	 * If the list has loop in it, eventually the fast and slow pointer will meet at the same node.
	 * On the other hand, if the loop has no loop, the fast pointer will reach the end 
	 * of list before the slow pointer does.	  
	 */
	public static boolean hasLoop(Node headNode){
		Node p1 = headNode, p2 = headNode;
        if(headNode == null){
            return false;
        }
        while(p2.next != null){
            p2 = p2.next;
            if(p2.next != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            if(p1 == p2){
                return true;
            }
        }
        return false;
	}
	
	/**
	 * Find the meeting node of two pointers if there is a loop in a list.
	 * 
	 */
	public Node meetingNodeInLoop(Node headNode){
		Node p1 = head, p2 = head;
		while(p2.next != null){
			p2 = p2.next;
			if(p2.next != null){
				p1 = p1.next;
				p2 = p2.next;
			}
			if(p1 == p2){
				return p1;
			}
		}
		return null;
	}
	
	/**
	 * IMPORTANT: Find the number of nodes in a loop of a list, and the entry node of loop. 
	 */
	public void numberOfNodesInLoop(Node headNode){

		// find meeting point of nodes
		Node meetPoint = meetingNodeInLoop(headNode);
		if(meetPoint == null){
			return;
		}
		// get the number of nodes in loop
		int nodeCountInLoop = 1;
		Node temp1 = meetPoint;
		while(temp1.next != meetPoint){
			++nodeCountInLoop;
		}
		System.out.println(nodeCountInLoop);

	}

	/**
	 * Find start of loop in a linked list
	 */
	private static void findStartOfLoopInLinkedList(Node head){
		Node p1 = head, p2 = head;
		while(p2.next != null){
			p2 = p2.next;
			if(p2.next != null){
				p1 = p1.next;
				p2 = p2.next;
			}
			if(p1 == p2){
				break;
			}
		}
		//initialize p1(slow) to head and keep p2 where it was
		p1 = head;
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println(p1.data);
	}

	/**
	 * Detect and remove loop in a linked list, if found and removed, return true, return false if no loop found
	 * Algorithm:
	 * 1. Check if loop is present, if not return false
	 * 2. Apply logic to find start of loop(like above) by resetting p1 to head and keeping p2 where it was
	 *    and checking if p1 == p2. Additionally keep track of previous of p2, as when p1 meets p2, the loop begins.
	 *    Hence we need to break that meeting point.
	 *  3. Set previous pf p2 to null
	 *
	 */
	private static boolean detectAndRemoveLoop(Node head){
		Node p1 = head, p2 = head;
		boolean hasLoop = false;
		while(p2.next != null){
			p2 = p2.next;
			if(p2.next != null){
				p1 = p1.next;
				p2 = p2.next;
			}
			if(p1 == p2){
				hasLoop = true;
				break;
			}
		}

		if(!hasLoop){
			return false;
		}
		//initialize p1(slow) to head and keep p2 where it was
		p1 = head;
		Node prevOfP2 = null;
		while(p1 != p2){
			p1 = p1.next;
			prevOfP2 = p2;
			p2 = p2.next;
		}
		prevOfP2.next = null;
		printLinkedList(head);
		return true;
	}



    /**
     * Determine if a given linked list is palindrome
     * Algorithm:
     * 1. Use two pointers: slow and fast
     * 2. While traversing the slow pointer, keep pushing its values into a stack
     * 3. Once the slow reaches the mid, move the slow pointer forward and pop the elements of the stack, while
     *   comparing it with the slow pointer value
     * 4. If everything matches, the linked list is a palindrome
     */
    public boolean isPalindrome(Node n){
        Node p1 = head, p2 = head;
        StackUsingArray myStack = new StackUsingArray();
        while(p2.next != null){
            p2 = p2.next;
            if(p2.next != null){
                p1 = p1.next;
                myStack.push((Integer) p1.data);
                p2 = p2.next;
            }
        }
        // odd number of elements
        if (p2 != null) {
            p1 = p1.next;
        }
        while(p1 != null){
            int value = myStack.pop();
            if((Integer)p1.data != value){
                return false;
            }
            p1 = p1.next;
        }
        return true;
    }
	/**
	 * Find median in a sorted linked list
	 * Algorithm:
	 * Use two pointers: fast and slow and find middle node
	 * if the fast_ptr is Not NULL then it means linked list contain odd element
	 * and we simply print the data of the slow_ptr.
	 * else if fast_ptr reach to NULL its means linked list contain even elements
	 * and we create backup of the previous node of slow_ptr and print (previous node of slow_ptr+ slow_ptr->data)/2
	 */

	public static int findMedianOfLinkedList(Node head){
		Node p1 = head, p2 = head, prevOfP1 = head;
		while(p2 != null && p2.next != null){
			//fast pointer
			p2 = p2.next.next;
			prevOfP1 = p1;
			p1 = p1.next;
		}

		if(p2 != null){
			return (int)p1.data;
		}else {
			return (int)prevOfP1.data;
		}

	}

	/**
     * Return the node prior to the first node containing an item.
     * @param x the item to search for.
     * @return appropriate iterator if the item is found. Otherwise, the
     * iterator corresponding to the last element in the list is returned.
     * Algorithm:
     * 1. Start with the head.
     * 2. Traverse till the node supplied does not match the last node found.
     * 3. Return the same.
     */
	public Node findPreviousNode(Node x){
		Node current = head;
		while(current.getNext() != null && !(current.getNext().equals(x))){
			current = current.getNext();
		}
		return current;
	}
	/**
	 * Remove the first occurrence of an item.
	 * ALGORITHM:
	 * 1. Find the node previous to the node to be removed.
	 * 2. Set the next of this node as next of next.
	 */
	public void remove(Node x){
		Node prev = findPreviousNode(x);		
		if(prev.getNext().getNext() != null){
			Node temp = prev.getNext().getNext();
			remove(x);
			// Bypass deleted node
			prev.setNext(temp);
		}
	}
	
	/**
	 * Flatten a linked list
	 * 
	 */
	public void flatten(Node node) {
		 while (node != null) {
		  if(node.down != null) {
		   if (node.next != null && (Integer)node.next.data < (Integer)node.down.data)
		    moveDownOnRight(node);
		   else {
		    node.down.next = node.next;
		    node.next = node.down;
		    node.down = node.down.down;
		   }
		  } else
		   node = node.next;
		 }
		}
		 
		private void moveDownOnRight(Node node) {
			Node next = node.next;
			Node parent = node;
		 
		 while (next != null && (Integer)next.data < (Integer)node.down.data) {
		  parent = next;
		  next = next.next;
		 }
		  
		 parent.next = node.down;
		 node.down.next = next;
		 node.down = null;
		}
	public int size(){
		return listCount;
	}

	public static void main(String[] args){
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		head.next = second;
		head.prev = null;
		second.next = third;
		second.prev = head;
		third.next = fourth;
		third.prev = second;
		fourth.prev = third;
		printLinkedList(head);
		System.out.println("#########################");
		System.out.println("#########################");
		System.out.println("#########################");
		System.out.println("#########################");
		//printLinkedList(new LinkedList().reverseListRecursive(head, null));
		Node newHead = reverseDoublyLinkedListRecursive(head);
		printLinkedList(newHead);
		//printLinkedList(reverseDoublyLinkedListIterative(head));
		//printLinkedList(removeNodesWithValue(head, 1));

		//detect and remove loop
		/*Node head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);
		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		findStartOfLoopInLinkedList(head);
		System.out.println(detectAndRemoveLoop(head));
*/

		Node headA = new Node(3);
		Node secA = new Node(1);
		Node thrA = new Node(5);
		headA.next = secA;
		secA.next = thrA;
		thrA.next = null;
		//printLinkedList(headA);

		Node headB = new Node(5);
		Node secB = new Node(9);
		//Node thrB = new Node(2);
		headB.next = secB;
		secB.next = null;//thrB;
		//thrB.next = null;

		Node res = addTwoLinkedLists(headA, headB, 0);
		//printLinkedList(res);

		/*Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = null;
		Node newHead= new LinkedList().reverseListIterative(head);*/
		//printLinkedList(newHead);
		//System.out.println(compareLists(null, headB));
		//printLinkedList(headB);
        /*printLinkedList(headA);
        printLinkedList(headB);
		System.out.println(intersectionOfTwoinkedLists(headA, headB));
		Node newHead = mergeListsIter(headA, headB);
		*/


        /*Node headA = new Node(0);
        Node secA = new Node(1);
        Node thrA = new Node(1);
        Node fouA = new Node(4);
        headA.next = secA;
        secA.next = thrA;
        thrA.next = fouA;
        fouA.next = null;
        printLinkedList(headA);

        removeDuplicates(headA);
        printLinkedList(headA);*/

	}

	public static void printLinkedList(Node head){
		while (head != null)
		{
			System.out.print( head.data + " ");
			head = head.next;
		}
	}

}

