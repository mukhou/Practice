package dataStructures;

import java.util.*;

import stacksandqueues.StackUsingArray;

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order

/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo method.
 * 
 * @author Mark Allen Weiss
 */
public class BinarySearchTree {
	/**
	 * Construct the tree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/** The tree root. */
	private BinaryNode root;

    public static ArrayList path;

	// Find height of a binary tree == max depth
	public int findTreeHeight_recursive(BinaryNode rootNode) {
		if (rootNode == null)
			return 0;
		int leftHeight = findTreeHeight_recursive(rootNode.left);
		int rightHeight = findTreeHeight_recursive(rootNode.right);

		return (1 + Math.max(leftHeight, rightHeight));

	}
	// max depth iterative == height of a binary tree
	// GS
	public static int findTreeHeight_iterative(BinaryNode rootNode){
		if (rootNode == null) {
			return 0;
		}
		Queue<BinaryNode> queue = new java.util.LinkedList<>();
		// ENQUEUE
		queue.add(rootNode);
		int height = 0;
		while(true){
			// find node count for every level
			int nodeCount = queue.size();
			// for each iteration, after nodeCount is emptied,
			// return the value of height
			if(nodeCount == 0){
				return height;
			}
			// increase height for each new level
			height ++;
			while(nodeCount > 0){
				// DEQUEUE
				BinaryNode temp = queue.poll();
				if(temp.left != null){
					queue.add(temp.left);
				}
				if(temp.right != null){
					queue.add(temp.right);
				}
				// decrease nodeCount
				nodeCount --;
			}
		}
			
		}
	
	
	// Find the maximum sum of a path through a binary tree
	public static int maxDepthSum(BinaryNode rootNode) {
		if (rootNode == null) {
			return 0;
		}
		if (rootNode.left == null && rootNode.right == null)
			return rootNode.data;
		else if (rootNode.right != null)
			return rootNode.data + maxDepthSum(rootNode.right);
		else if (rootNode.left != null)
			return rootNode.data + maxDepthSum(rootNode.left);
		else
			return rootNode.data + Math.max(maxDepthSum(rootNode.left), maxDepthSum(rootNode.right));
	}

	/**
	 * CAPITALIQ Interview question. Given a binary tree,find a path (root ->
	 * leaf) whose elements sum up to a given number. Return false if no such
	 * path can be found. 
	 * Detailed expl: Given a Binary Tree and a number �sum�,
	 * wap to see if there exists a root to leaf path in the tree whose
	 * summation is equal to the given number �sum�. The given binary tree
	 * contain only integer values. 
	 * ALGORITHM:
	 *  1. Check for root = null
	 *  2. if not, check for left and right subtrees, subtracting the root data from
	 * the given number.
	 * 3. return true if either of them meet the condition.
	 */
	// Preferred approach
	public boolean checkPathSum(BinaryNode rootNode, int num) {
		// base case
		if (rootNode == null) {
			return (num == 0);
		} else {
			BinaryNode current = rootNode;
			if (current.left == null && current.right == null) {
				return (current.data == num);
			} else if (current.left != null) {
				return checkPathSum(current.left, num - current.data);
			} else if (rootNode.right != null) {
				return checkPathSum(current.right, num - current.data);
			} else
				return (checkPathSum(current.left, num - current.data) || checkPathSum(
						current.right, num - current.data));
		}
	}
	
	/**
	 * GS
	 * Find the distance of a node from the root in a binary tree.Print error message if node doesn't exist. 
	 * Extend the problem to distance of any node to any other node that is below it.
	 * distance = 0,initially
	 */
	public int findDistanceBetweenTwoNodes(BinaryNode node, int key, int distance)	{
		if(node == null) return 0;
		if(node.data == key) return distance;
	
		else return (findDistanceBetweenTwoNodes(node.left, key, distance + 1) |
				findDistanceBetweenTwoNodes(node.right, key, distance + 1));
	}

	/**
	 * Write a program to return a max BST within a given B-tree
	 */
	public int findMaxBST(BinaryNode rootNode) {
		if (rootNode == null)
			return 0;
		int left, right, max;
		// assign max as value of root node
		max = rootNode.data;
		left = findMaxBST(rootNode.left);
		if (left > max) {
			max = left;
		}
		right = findMaxBST(rootNode.right);
		if (right > max) {
			max = right;
		}
		return max;
	}
	
	/**
	 * WAP to find the in-order successor of a node in binary tree.
	 * ALGORITHM:
	 * 1. If X has a right child, then the successor must be on the right side of X
	 *  (because of the order in which we visit nodes). 
	 * 2. Else, we go to X's parent (call it P).
	 * 	a)If X was a left child (P.left = X), then P is the successor of X
	 * 	b)If X was a right child (P.right = X), then we have fully visited P, so we call successor(P).
	 */
	public BinaryNode findInOrderSuccessor(BinaryNode n){
		BinaryNode successor = null;
		if(n.right != null){
			successor = findMin(n.right);
		}
		
		while((successor = n.parent) != null){
			if(successor.left == n){
				break;
			}
			else successor = n;
		}
		return successor;
	}

	/**
	 * Check if a tree is balance`d.
	 *  ALGORITHM:
	 *  1.find the max and min paths.
	 *  2.check if the difference between them is <= 1
	 */

	// Find the max depth == height of tree
	public static int maxDepth(BinaryNode rootNode, int height) {
		
		// Base Case
		if (rootNode == null) {
			return 0;
		} else if (rootNode.left == null & rootNode.right == null) {
			return height;
		}// assuming left and right nodes are not null
		else
			return Math.max(maxDepth(rootNode.left, height + 1),
					maxDepth(rootNode.right, height + 1));
	}
	
	
	

	// Find the min depth
	public static int minDepth(BinaryNode rootNode, int height) {
		if (rootNode == null) {
			return 0;
		} else if (rootNode.left == null & rootNode.right == null) {
			return height;
		}// assuming left and right nodes are not null
		else
			return Math.min(minDepth(rootNode.left, height + 1),
					minDepth(rootNode.right, height + 1));
	}

	// check to find difference between max and min depth
	public static boolean isBalanced(BinaryNode rootNode, int height) {
		return ((maxDepth(rootNode, height) - minDepth(rootNode, height)) <= 1);
	}

	/**
	 * Check if a given tree is a BST. 
	 * ALGORITHM: 
	 * 1. Do in-order traversal, and check is previous member is less than current 
	 * 2. check for left subtree, center and right subtree respectively
     * 3. if yes, return true
	 */

	public static boolean isBST(BinaryNode rootNode, int max, int min) {
		// Base case
		if (rootNode == null)
			return true;
		if (rootNode.data < min || rootNode.data > max)
			return false;
		return (isBST(rootNode.left, rootNode.data-1, min) &&
				isBST(rootNode.right, max, rootNode.data+1));
	}
	
	/*public static boolean isBST(BinaryNode rootNode){
		BinaryNode prev = null;
		if(rootNode != null){
			if(!isBST(rootNode.left)){
				return false;
			}
			if(prev != null && rootNode.data <= prev.data){
				return false;
			}
			prev = rootNode;
			return (isBST(rootNode.right));
		}
		return true;
	}*/
	
	/**
	 * IMPORTANT:
	 * Given a Binary Tree, check if all leaves are at same level or not.
	 * ALGORITHM:
	 * 1.First find level of the leftmost leaf and store it in a variable leafLevel.
	 * 2.Then compare level of all other leaves with leafLevel, if same, return true, 
	 *   else return false.
	 * 3.The value of leafLevel is initialized as 0 to indicate that the first leaf
	 *   is not yet seen yet.
	 * 4.The value is updated when we find first leaf.
	 * 5.Compare level of subsequent leaves (in preorder) with leafLevel.
	 * 6.Traverse the given Binary Tree in Preorder fashion.
	 * http://www.geeksforgeeks.org/check-leaves-level/
	 */
	// initial call: checkLeavesSameLevel( rootNode, 0, 0){
	public boolean checkLeavesSameLevel(BinaryNode rootNode, int level, int leafLevel){
		// base case
		if(rootNode == null) return true;
		
		// If a leaf node is encountered
	    if (rootNode.left == null && root.right == null)
	    {
	        // When a leaf node is found first time
	        if (leafLevel == 0)
	        {
	        	// value is updated when we find first leaf.
	            leafLevel = level; 
	            return true;
	        }
	 
	        // subsequent leaves  is compared with leafLevel.
	        return (level == leafLevel);
	    }
	 
	    // If this node is not leaf, recursively check left and right subtrees
	    return checkLeavesSameLevel(rootNode.left, level+1, leafLevel) &&
	    checkLeavesSameLevel(rootNode.right, level+1, leafLevel);
	}

	/**
	 *  Given a binary tree, write a code that returns the difference between sum of nodes at even level and 
	 *  sum of nodes at odd level. 
	 *  Root is considered at level 0.
	 *  IDEA:
	 *  The problem can also be solved using simple recursive traversal. 
	 *  We can recursively calculate the required difference as, value of root's data subtracted by
	 *  the difference for subtree under left child and the difference for subtree under right child.
	 *  Same approach followed by GeeksforGeeks:
	 *  http://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
	 */
	public int oddEvenNodesDifference(BinaryNode rootNode)
	{
		if(rootNode == null) return 0;
	    int lvalue, rvalue;
	    lvalue = oddEvenNodesDifference(rootNode.left);
	    rvalue = oddEvenNodesDifference(rootNode.right);
	   // Difference for root is root's data - difference for left subtree - difference for right subtree
	    return rootNode.data -(lvalue + rvalue);
	}
	
	/**
	 * Find depth of the deepest odd level leaf node in a Binary Tree 
	 * ALGORITHM:
	 * 1. Recursively traverse the given binary tree and while traversing,
	 *    maintain a variable �level� which will store the current node�s level in the tree. 
	 * 2. If current node is leaf then check �level� is odd or not. 
	 * 3. If level is odd then return it.
	 * 4. If current node is not leaf, then recursively find maximum depth
	 *    in left and right subtrees, and return maximum of the two depths.
	 *    Check: http://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/
	 */
	// Initially, value of level is 1.
	public int findDeepestOddLevelNode(BinaryNode rootNode, int level){
		// base case
		if(rootNode == null) {
			return 0;
		}
		// if current node is leaf, check its level
		if(rootNode.left == null && rootNode.right == null){
			if(level % 2 != 0){
				return level;
			}
			
		}
		//current node is not a leaf
		return Math.max(findDeepestOddLevelNode(rootNode.left, level + 1), 
				findDeepestOddLevelNode(rootNode.right, level + 1));
	}
	
	/**
	 * IMPORTANT
	 * Construct Tree from given In-order and Pre-order traversals.
	 * Example:
	 * In-order sequence: D B E A F C
	 * Pre-order sequence: A B D E C F
	 * ALGORITHM:
	 * 1.In a Pre-order sequence, leftmost element is the root of the tree. 
	 * 2.So we know "A" is root for given sequences. By searching "A" in In-order sequence,
	 * we can find out all elements on left side of "A" are in left subtree and
	 * elements on right are in right subtree.
	 * 3.We recursively follow above steps and get the following tree. 
	 */	
	public BinaryNode buildTreeFromPreIn(char[] inOrder, char[] preOrder, int inOrderStart, int inOrderEnd, int preIndex){		
		if(inOrderStart > inOrderEnd) return null;
		// create the root node from the first node of Pre-Order sequence
		BinaryNode rootNode = new BinaryNode(preOrder[preIndex++]);
		
		// search the in-order sequence for the index of this root node
		int indexOfRoot = searchInOrder(inOrder, inOrderStart, inOrderEnd, rootNode.data);
		// iteratively build left and right subtrees
		rootNode.left = buildTreeFromPreIn(inOrder, preOrder, inOrderStart, indexOfRoot - 1, preIndex);
		rootNode.right = buildTreeFromPreIn(inOrder, preOrder, indexOfRoot + 1, inOrderEnd, preIndex);
		return root;
		
	}
	
	private int searchInOrder(char[] inOrder, int inOrderStart,
			int inInorderEnd, int data) {
		for(int i = inOrderStart; i <= inInorderEnd; i ++){
			if(inOrder[i] == data){
				return i;
			}
		}
		return 0;
	}
	

	/**
	 * Given inorder and postorder traversals construct a binary tree.
	 * Same approach as building tree from In-Order and Pre-Order sequence
	 * Only difference: start creating root from the right most character of
	 * given post order sequence and keep decreasing it by 1 for successive root creations
     * postIndex is the last index of the postorder array
	 * http://www.geeksforgeeks.org/forums/topic/given-inorder-and-postorder-traversals-construct-a-binary-tree-2/
	 */
	
	public BinaryNode buildTreeFromPostIn(char[] inOrder, char[] postOrder, int inOrderStart, int inOrderEnd, int postIndex){
		if(inOrderStart > inOrderEnd) return null;
		// create the root node from the first node of Pre-Order sequence
		BinaryNode rootNode = new BinaryNode(postOrder[postIndex --]);
		int indexOfRoot = searchInOrder(inOrder, inOrderStart, inOrderEnd, rootNode.data);
		
		// same as building tree from In-Order and Pre-Order sequence
		rootNode.left = buildTreeFromPostIn(inOrder, postOrder, inOrderStart, indexOfRoot - 1, postIndex);
		rootNode.right = buildTreeFromPostIn(inOrder, postOrder, indexOfRoot + 1, inOrderEnd, postIndex);
		
		return rootNode;
		
	}
	
	/**
	 * IMPORTANT
	 * Construct Full Binary Tree from given preorder and postorder traversals.
	 * Example:
	 * Pre-order sequence: 1, 2, 4, 8, 9, 5, 3, 6, 7
	 * Post-order sequence: 8, 9, 4, 5, 2, 6, 7, 3, 1
	 * ALGORITHM:
	 * 1.In pre[], the leftmost element is root of tree, so start creating the tree with
	 *   the root node with this value and increment the index for successive root creations.
	 * 2.The value next to 1 in pre[], must be left child of root. 
	 *   So we know 1 is root and 2 is left child.
	 * 3.We know 2 is root of all nodes in left subtree. and all nodes before 2 in post[] must be in left subtree.
	 * 4.Now we know 1 is root, elements {8, 9, 4, 5, 2} are in left subtree, 
	 *   and the elements {6, 7, 3} are in right subtree.
	 * 5. Recurse the process.
	 *    http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
	 */
	public BinaryNode buildTreeFromPrePost(char[] preOrder, char[] postOrder, int postOrderStart, int postOrderEnd, int preIndex){
		if(postOrderStart > postOrderEnd) return null;
		// create the root node from the first node of Pre-Order sequence
		BinaryNode rootNode = new BinaryNode(preOrder[preIndex++]);
		
		// crawl the post order sequence till we find the next element (root node of left subtree)
		// from the pre order sequence, so we can divide the post order
		// sequence into left and right subtrees
        /*for(index_of_left_subtree = postOrderStart; index_of_left_subtree <= postOrderEnd; index_of_left_subtree++){
			// if next element of pre matches any of post, stop
			if(postOrder[index_of_left_subtree] == preOrder[preIndex]){
				break;
			}
		}*/
        //IMP: we are passing preOrder[preIndex] to the search function which is the index of left subtree
		/// and not the root.data
		int indexOfLeftSubtree = searchInOrder(postOrder, postOrderStart, postOrderEnd, preOrder[preIndex]);

		rootNode.left = buildTreeFromPreIn(preOrder, postOrder, postOrderStart, indexOfLeftSubtree, preIndex);
		rootNode.right = buildTreeFromPrePost(preOrder, postOrder, indexOfLeftSubtree + 1, postOrderEnd, preIndex);
		
		return rootNode;
		
	}
	
	/**
	 * Given a sorted (increasing order) array, write an algorithm to create a
	 * binary tree with minimal height.
     * Solution: We will try to create a binary
	 * tree such that for each node, the number of nodes in the left subtree and
	 * the right subtree are equal. 
	 * Algorithm: 
	 * 1. Insert into the tree the middle element of the array.
	 * 2. Insert (into the left subtree) the left
	 * subarray elements. 
	 * 3. Insert (into the right subtree) the right subarray
	 * elements. 
	 * 4. Recurse
	 */
	public static BinaryNode createMinimalBST(int[] arr) {
		return addToTree(arr, 0, arr.length - 1);
	}

	// method to create the tree
	public static BinaryNode addToTree(int[] arr, int start, int end) {

		if (end < start)
			return null;
		// find the mid number
		int mid = (start + end) / 2;
		// create the root node
		BinaryNode rootNode = new BinaryNode(arr[mid]);
		// create the left subtree
		rootNode.left = addToTree(arr, start, mid - 1);
		// create the right subtree
		rootNode.right = addToTree(arr, mid + 1, end);
		return rootNode;
	}

	/**
	 * IMPORTANT: Find the least common ancestor for any two given nodes in a
	 * Binary search tree. 
	 * ALGORITHM: 
	 * Check if nodes a and b are in left and right subtrees
	 * if yes, return root node else check in left and right subtrees
	 */
	public BinaryNode findLCA(BinaryNode rootNode, BinaryNode a, BinaryNode b) {
		if (rootNode == null) {
			return null;
		}
		if ((rootNode.data > a.data & rootNode.data < b.data)
				|| (rootNode.data < a.data & rootNode.data > b.data)) {
			return rootNode;
		} else {
			if (rootNode.data < a.data & rootNode.data < b.data) {
				return findLCA(rootNode.right, a, b);
			} else {
				return findLCA(rootNode.left, a, b);
			}
		}
	}

	/**
	 * Print BST keys in the given range. Detailed desc: Given two values k1 and
	 * k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Print all
	 * the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2
	 * and x is a key of given BST. Print all the keys in increasing order. Much
	 * like inorder traversal with k1 as left and k2 as right
	 */
	public static void printBSTKeys(BinaryNode rootNode, int k1, int k2) {
		if (rootNode == null)
			return;
		// root node strictly less than k1
		if (rootNode.data > k1) {
			printBSTKeys(rootNode.left, k1, k2);
		}
		// if k1 <= root.data <= k2
		if (rootNode.data >= k1  && rootNode.data <= k2) {
			System.out.println(rootNode.data);
		}
		// root node strictly greater than k2
		if (rootNode.data < k2) {
			printBSTKeys(rootNode.right, k1, k2);
		}
	}

	/**
	 * Given a binary tree, print out the tree in level order (i.e, from left to
	 * right, level by level). Output all in same line.
	 * ALGORITHM: BFS
	 */
	public static void printTreeByLevelOneLine(BinaryNode root) {
		Queue<BinaryNode> queue = new java.util.LinkedList<BinaryNode>();
		// follow BFS
		queue.add(root);
		while (!queue.isEmpty()) {
			// DEQUE
			BinaryNode temp = queue.poll();
			System.out.print(temp.data);
			// ENQUEUE
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}

		}
	}
	
	/**
	 * WAP to print the nodes of a tree level-wise,in a new line for each level
	 * @param rootNode
	 */
	public void printTreeLevelWiseNewLine(BinaryNode rootNode) {

		// If the first node isn't null....continue on
		if (rootNode != null) {
			// Queue that holds the nodes on the current level
			Queue<BinaryNode> currentLevelQueue = new java.util.LinkedList<BinaryNode>();
			 // Queue the stores the nodes for the next level
			Queue<BinaryNode> nextLevel = new java.util.LinkedList<BinaryNode>();
			// Stores the height of the current tree
			int treeHeight = findTreeHeight_recursive(rootNode); 
			// keeps track of the total levels printed so we don't pass the height and print a billion "null"s 
			int levelTotal = 0; 
			// ENQUEUE
			currentLevelQueue.add(rootNode);

			// while there is still another level to print and we haven't gone
			// past the tree's height
			while (!currentLevelQueue.isEmpty() && (levelTotal < treeHeight)) {

				// this step is same as print in one level
				// Print the next node on the level, add its children to the
				// next level's queue, and dequeue the node...do this until the
				// current level has been printed
				while (!currentLevelQueue.isEmpty()) {

					// Print the current value
					System.out.print(currentLevelQueue.peek().data + " ");

					// If there is a left child, put the node on the nextLevel's
					// stack.
					BinaryNode tempLeft = currentLevelQueue.peek().left;
					if (tempLeft != null)
						// keep adding to next level queue
						nextLevel.add(tempLeft);

					// If there is a right child, put the node on the
					// nextLevel's stack.
					BinaryNode tempRight = currentLevelQueue.remove().right;
					if (tempRight != null)
						//keep adding to next level queue
						nextLevel.add(tempRight);

				}// end inner while

				// populate the currentLevel queue with items from the next
				// level
				while (!nextLevel.isEmpty()) {
					// strip each node out of next level and add it to current
					// level queue
					currentLevelQueue.add(nextLevel.remove());
				}

				// Print a blank line to show height
				System.out.println("");

				// increment level
				levelTotal++;

			}// end outer while

		}// end if(tmpRoot != null)

	}// end method printTree
	
	/**
	 * Print tree level-order traversal but starting from the depth i.e,
	 * the lowest level should get printed first and the root node should get printed last.
	 * @param rootNode
	 */
	public static void printTreeByLevelOneLineReverse(BinaryNode rootNode){
		Queue<BinaryNode> queue = new java.util.LinkedList<BinaryNode>();
		// follow BFS
		queue.add(rootNode);		
		StackUsingArray stack = new StackUsingArray();
		// add root to stack
		stack.push(queue.peek().data);
		while (!queue.isEmpty()) {
			// DEQUE
			BinaryNode temp = queue.poll();			
			// ENQUEUE
			if (temp.left != null) {
				queue.add(temp.left);
				stack.push(temp.left.data);
			}
			if (temp.right != null) {
				queue.add(temp.right);
				stack.push(temp.right.data);
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}

	}



	/**
	 * Inorder Tree Traversal without Recursion
	 * ALGORITHM:
	 * 1) Create an empty stack S.
	 * 2) Initialize current node as root
	 * 3) Push the current node to S and set current = current->left until current is NULL
	 * 4) If current is NULL and stack is not empty then
	 *    a) Pop the top item from stack.
	 *    b) Print the popped item, set current = current->right
	 *    c) Go to step 3.
	 * 5) If current is NULL and stack is empty then we are done.
	 * check: http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/

	 * @param rootNode
	 */
	/*public static void printInorder(BinaryNode rootNode)
	{
		Stack stack = new Stack();
		
		BinaryNode current = rootNode;
		while(!stack.isEmpty() || current != null){
			if(current != null){
				stack.push(current);
				current = current.left;
			}else{
				current = stack.pop();
				System.out.print(current.data);
				current = current.right;
			}
		}
	}*/
	
	/**
	 * Print in order traversal of tree without recursion and without stack
	 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
	 */

    /**
     * 1. Initialize current as root
       2. While current is not NULL
            If current does not have left child
                a) Print current’s data
                b) Go to the right, i.e., current = current->right
            Else
                a) Make current as right child of the rightmost
                node in current's left subtree
                b) Go to this left child, i.e., current = current->left
     * @param root
     */
    //https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
	public static void printInOrder(BinaryNode root){
		if(root == null)
			return;		
		BinaryNode current = root;
		while(current != null){
			// if no left subtree, print the root and then right subtree
			if(current.left == null){
				System.out.print(current.data);
				current = current.right;
			}else{
				// Find the inorder predecessor of current 
				BinaryNode pre = current.left;
				while(pre.right != null && pre.right !=current){
					pre = pre.right;
				}
				
				// Make current as right child of its inorder predecessor 
				if(pre.right == null){

					pre.right = current;
					current = current.left;

				}else{
					/* Revert the changes made in if part to restore the original 
			        tree i.e., fix the right child of predecssor */
					pre.right = null;
					System.out.print(current.data);
					current = current.right;
				}				
			}
		}		
	}
	
			
	/**
	 * Convert a given Binary Tree to Doubly Linked List.
	 * Check this for explanation:
	 * http://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
	 */
	
	// Changes left pointers to work as previous pointers in converted DLL
	// The function simply does in-order traversal of Binary Tree and updates
	// left pointer using previously visited node
	public void fixLeftPointer(BinaryNode rootNode){
		BinaryNode pre = null;
		if(rootNode != null){
			// traverse till the left most node
			fixLeftPointer(rootNode.left);
			// set its left to null, for the left most node 
			rootNode.left = pre;
			pre = rootNode;
			fixLeftPointer(rootNode.right);
		}
	}
	// Changes right pointers to work as next pointers in converted DLL
	public BinaryNode fixRightPointer(BinaryNode rootNode){
		BinaryNode prev = null;
		
		// Find the right most node in BT or last node in DLL
	    while (rootNode != null && rootNode.right != null)
	    	rootNode = rootNode.right;
	 
	    // Start from the rightmost node, traverse back using left pointers.
	    // While traversing, change right pointer of nodes.
	    while (rootNode != null && rootNode.left != null)
	    {
	        prev = rootNode;
	        rootNode = rootNode.left;
	        rootNode.right = prev;
	    }
	 
	    // The leftmost node is head of linked list, return it
	    return rootNode;
		
	}
	

	/**
	 * Write a function to create an mirror image of binary tree
	 */
	public BinaryNode mirrorImage(BinaryNode rootNode) {
		if (rootNode != null) {
			mirrorImage(rootNode.left);
			mirrorImage(rootNode.right);
			BinaryNode temp = rootNode.left;
			rootNode.left = rootNode.right;
			rootNode.right = temp;
		}
		return rootNode;
	}

	/**
	 * WAP to count leaf nodes in a binary tree. 
	 * ALGORITHM:
	 * 1. If node is NULL then return 0.
	 * 2. Else If left and right child nodes are NULL return 1.
	 * 3. Else recursively calculate leaf count of the tree using below formula:
	 * Leaf count of a tree = Leaf count of left subtree + Leaf count of right
	 * subtree.
	 * Program is taken from this site:
	 * http://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
	 */
	public static int getLeafCount(BinaryNode rootNode) {
		if (rootNode == null)
			return 0;
		if (rootNode.left == null && rootNode.right == null)
			return 1;
		return getLeafCount(rootNode.left) + getLeafCount(rootNode.right);

	}
	
	/**
	 * IMPORTANT: Given a binary search tree, design an algorithm which creates
	 * a linked list of all the nodes at each depth.
	 * http://tianrunhe.wordpress.com/2012/03/03/create-linked-lists-of-all-the-nodes-at-each-depth-for-a-bst/
	 */
	public static ArrayList<java.util.LinkedList<BinaryNode>> findLevelLinkList(
			BinaryNode rootNode) {
		// initialize level to 0
		int level = 0;
		// the result will contain a List of LinkedList of Nodes
		// iterate over its length for each level
		ArrayList<java.util.LinkedList<BinaryNode>> resultList = new ArrayList<java.util.LinkedList<BinaryNode>>();
		// create the list to hold the nodes at each level
		java.util.LinkedList<BinaryNode> nodeList = new java.util.LinkedList<BinaryNode>();
		nodeList.add(rootNode);
		resultList.add(level, nodeList);
		while (true) {
			// every time re-create a new linked list of nodes to hold
			// the nodes at the current 
			// Note: this list is created outside the for loop, so that
			// all modes of the same level are added to the list
			// before it gets recreated again
			nodeList = new java.util.LinkedList<BinaryNode>();
			for (int i = 0; i < resultList.get(level).size(); i++) {
				BinaryNode temp = resultList.get(level).get(i);
				if (temp != null) {
					if (temp.left != null) {
						nodeList.add(temp.left);
					}
					if (temp.right != null) {
						nodeList.add(temp.right);
					}
				}
			}
			// add the nodes of this level to the result list
			if (nodeList.size() > 0) {
				resultList.add(level + 1, nodeList);
			} else {
				break;
			}
			// IMPORTANT: increase level, even if there are no new nodes at
			// present level
			level++;
		}
		return resultList;

	}

	/**
	 * IMPORTANT: Given a binary tree return the level with maximum number of
	 * nodes. 
	 * ALGORITHM:
	 *  1. Run a BFS, starting from root node. 
	 *  2. Keep track of levels and no. of nodes in each level. 
	 *  3. Update max_nodes_in_level and level_number, with no. of nodes in current level and current level
	 *     number, IF no.of nodes in current level > max_nodes_in_level. 
	 *  4. Return level_number.
	 */
	public int MaxNodesLevel(BinaryNode rootNode) {
		// the current queue
		Queue<BinaryNode> currentQueue = new PriorityQueue<BinaryNode>();
		// queue at the next level
		Queue<BinaryNode> nextlevelQueue;
		BinaryNode temp;
		// level of maximum nodes
		int maxNodeslevel = 0;
		// no. of nodes at the previous level
		int prevLevelCount_Nodes = 0;
		// max. no. of nodes
		int maxNodes = 0;
		// no. of nodes at the current level
		int currentlevelCount_Nodes = 0;

		// add the root node
		if (rootNode != null) {
			currentQueue.add(rootNode);
		}
		// perform BFS: while Q is not empty, deQueue(Q)
		// two while loops
		while (!currentQueue.isEmpty()) {
			// create a new Queue at each level to store leaves of that level
			nextlevelQueue = new PriorityQueue<BinaryNode>();
			// deQueue(Q)
			while ((temp = currentQueue.poll()) != null) {
				if (temp.left != null) {
					nextlevelQueue.add(temp.left);
				}
				if (temp.right != null) {
					nextlevelQueue.add(temp.right);
				}
			}

			// set count of nodes in current level as length of nextlevelQueue
			currentlevelCount_Nodes = nextlevelQueue.size();
			// Update max_nodes_in_level and level_number, with no. of nodes in
			// current level and current level number.
			// update maxNodes
			maxNodes = prevLevelCount_Nodes > currentlevelCount_Nodes ? prevLevelCount_Nodes
					: currentlevelCount_Nodes;
			// increase maxNodeslevel or keep it same
			maxNodeslevel += (maxNodes == currentlevelCount_Nodes) ? 1 : 0;
			// start with new max/nodes, set previous count as maxNodes(till
			// now), for next iteration
			prevLevelCount_Nodes = maxNodes;
			// set currentQueue as nextlevelQueue for next iteration
			currentQueue = nextlevelQueue;
		}
		return maxNodeslevel;
	}

	/**
	 * Flatten Binary Tree to Linked List
	 */
	public void flattenTree(BinaryNode rootNode) {
		if (rootNode == null)
			return;
		if (rootNode.left != null) {
			BinaryNode rightSubtree = rootNode.right;
			rootNode.right = rootNode.left;
			rootNode.left = null;
			BinaryNode tempRight = rootNode.right;
			while (tempRight.right != null) {
				tempRight = tempRight.right;
			}
			tempRight.right = rightSubtree;
		}
		// call recursively on the right node of the root
		flattenTree(rootNode.right);
	}

    /**
     * Given a Binary tree (Not binary Search Tree ), Print a path from root to a given node.
     * Link: http://algorithms.tutorialhorizon.com/print-a-path-from-root-to-node-in-binary-tree/
     * ALGORITHM:
     * 1. Start from the root and compare it with x, if matched then we have found the node.
     * 2. Else go left and right.
     * 3. Recursively do step 2 and 3 till you find the node x.
     * 4. Now when you have found the node, stop the recursion.
     * 5. Now while going back to the root while back tracking, store the node values in the ArrayList.
     * 6. Reverse the ArrayList and print it.
     */
    public static boolean findPathFromRootToNode(BinaryNode root, BinaryNode node){
        path = new ArrayList();
        if(root == null){
            return false;
        }
        if(root == node || findPathFromRootToNode(root.left, node) || findPathFromRootToNode(root.right, node)){
            path.add(root.data);
            return true;
        }
        return false;
    }


    /**
     * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
     * where largest means subtree with largest number of nodes in it.
     * Algorithm: bottom up approach
     * Link: http://articles.leetcode.com/2010/11/largest-binary-search-tree-bst-in.html
     */
    public BinaryNode findLargestBSTSubtree(BinaryNode node){
        BinaryNode largestBST = null;
        int min = 0, max = 0;
        int maxNodes = Integer.MIN_VALUE;
        findLargestBSTSubtree(root, min, max, maxNodes, largestBST);
        return largestBST;
    }

    private int findLargestBSTSubtree(BinaryNode root, int min, int max, int maxNodes, BinaryNode largestBST) {
        boolean isBST = true;
        int leftNodes = findLargestBSTSubtree(root.left, min, max, maxNodes, largestBST);
        int currMin = (leftNodes == 0) ? root.data : min;
        if (leftNodes == -1 || (leftNodes != 0 && root.data <= max))
        isBST = false;
        int rightNodes = findLargestBSTSubtree(root.right, min, max, maxNodes, largestBST);
        int currMax = (rightNodes == 0) ? root.data : max;
        if (rightNodes == -1 || (rightNodes != 0 && root.data >= min))
        isBST = false;
        if (isBST) {
            min = currMin;
            max = currMax;
            int totalNodes = leftNodes + rightNodes + 1;
            if (totalNodes > maxNodes) {
                maxNodes = totalNodes;
                largestBST = root;
            }
            return totalNodes;
        } else {
            return -1;   // This subtree is not a BST
        }

    }

    /**
	 * Design a Binary Search Algorithm
	 */
	// Binary Search: Iterative version
	public BinaryNode BSTIterative(BinaryNode rootNode, int key) {
		BinaryNode current = rootNode;
		while (current != null) {
			if (current.data == key)
				return current;
			else if (key < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return current;
	}

	// Binary Search: Recursive version
	public BinaryNode BSTRecursive(BinaryNode rootNode, int key) {
		BinaryNode current = rootNode;
		if (current == null)
			return null;
		if (current.data == key)
			return current;
		else if (key < rootNode.data) {
			BSTRecursive(rootNode.left, key);
		} else {
			BSTRecursive(rootNode.right, key);
		}
		return current;
	}

	/**
	 * Insert an element into a BST
	 */
	// Insertion: Iterative Version
	public void insertIterative(int data) {
		if (root == null) {
			root = new BinaryNode(data);
			return;
		}
		BinaryNode current = root;
		while (current != null) {
			if (root.data == data)
				return;
			if (data < root.data) {
				if (root.left == null) {
					root.left = new BinaryNode(data);
					return;
				} else {
					current = root.left;
				}
			} else {
				if (root.right == null) {
					root.right = new BinaryNode(data);
					return;
				} else {
					current = root.right;
				}
			}
		}
	}

	// Insertion: Recursive Version
	public void insertRecursive(int data) {
		if (root == null) {
			root = new BinaryNode(data);
			return;
		} else {
			BinaryNode current = root;
			internlInsert(current, data);
		}
	}

	private void internlInsert(BinaryNode current, int data) {
		if (current.data == data) {
			return;
		} else if (data < root.data) {
			if (root.left == null) {
				root.left = new BinaryNode(data);
			} else {
				internlInsert(current.left, data);
			}
		} else {
			if (root.right == null) {
				root.right = new BinaryNode(data);
			} else {
				internlInsert(current.right, data);
			}
		}

	}

	/**
	 * Insert into the tree; duplicates are ignored.
	 * 
	 * @param x
	 *            the item to insert.
	 */
	public void insert(Comparable x) {
		root = insert(x, root);
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * 
	 * @param x
	 *            the item to remove.
	 */
	public void remove(Comparable x) {
		root = remove(x, root);
	}

	/**
	 * Find the smallest item in the tree.
	 * 
	 * @return smallest item or null if empty.
	 */
	public Comparable findMin() {
		return elementAt(findMin(root));
	}

	/**
	 * Find the largest item in the tree.
	 * 
	 * @return the largest item of null if empty.
	 */
	public Comparable findMax() {
		return elementAt(findMax(root));
	}

	/**
	 * Find an item in the tree.
	 * 
	 * @param x
	 *            the item to search for.
	 * @return the matching item or null if not found.
	 */
	public Comparable find(int x) {
		return elementAt(find(x, root));
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty() {
		root = null;
	}

	/**
	 * TestGroovy if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Internal method to get element field.
	 * 
	 * @param t
	 *            the node.
	 * @return the element field or null if t is null.
	 */
	private Comparable elementAt(BinaryNode t) {
		return t == null ? null : t.element;
	}

	/**
	 * Internal method to insert into a subtree.
	 * 
	 * @param x
	 *            the item to insert.
	 * @param t
	 *            the node that roots the tree.
	 * @return the new root.
	 */
	private BinaryNode insert(Comparable x, BinaryNode t) {
		if (t == null)
			t = new BinaryNode(x, null, null);
		else if (x.compareTo(t.element) < 0)
			t.left = insert(x, t.left);
		else if (x.compareTo(t.element) > 0)
			t.right = insert(x, t.right);
		else
			; // Duplicate; do nothing

		return t;
	}

	/**
	 * Internal method to remove from a subtree.
	 * 
	 * @param x
	 *            the item to remove.
	 * @param rootNode
	 *            the node that roots the tree.
	 * @return the new root.
	 */
	private BinaryNode remove(Comparable x, BinaryNode rootNode) {   // see Cormen pg 298
		if (rootNode == null)
			return rootNode; // Item not found; do nothing
		if (x.compareTo(rootNode.element) < 0)
			rootNode.left = remove(x, rootNode.left);
		else if (x.compareTo(rootNode.element) > 0)
			rootNode.right = remove(x, rootNode.right);
        /**
         * what of a to-be-deleted node with two children? Our solution is to relabel
         this node with the key of its immediate successor in sorted order. This successor
         must be the smallest value in the right subtree, specifically the leftmost descendant
         in the right subtree (p). Moving this to the point of deletion results in a properly labeled
         binary search tree, and reduces our deletion problem to physically removing
         a node with at most one child—a case that has been resolved above.
         */
		else if (rootNode.left != null && rootNode.right != null) // Two
																	// children
		{
			rootNode.element = findMin(rootNode.right).element;
			rootNode.right = remove(rootNode.element, rootNode.right);
		} else
			rootNode = (rootNode.left != null) ? rootNode.left : rootNode.right;
		return rootNode;
	}

	/**
	 * IMPORTANT: Internal method to find the smallest item in a subtree. Keep
	 * searching for the leftmost node
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	// Iterative version
	private BinaryNode findMin(BinaryNode t) {
		// Recursive version (commented out)
		/*
		 * if (t == null) return null; else if (t.left == null) return t; return
		 * findMin(t.left);
		 */
		if (t != null) {
			while (t.left != null) {
				t = t.left;
			}
		}
		return t;
	}

	/**
	 * IMPORTANT: Internal method to find the largest item in a subtree. Keep
	 * searching for the rightmost node
	 * 
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the largest item.
	 */
	// Iterative version
	private BinaryNode findMax(BinaryNode t) {
		if (t != null)
			while (t.right != null)
				t = t.right;

		return t;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * 
	 * @param x
	 *            is item to search for.
	 * @param t
	 *            the node that roots the tree.
	 * @return node containing the matched item.
     * Run time = O(h) where h is the height of the tree
	 */
	private BinaryNode find(int x, BinaryNode t) {
		if (t == null)
			return null;
        if (x == t.data)
            return t;
		if (x < t.data)
			return find(x, t.left);
		else if (x > t.data)
			return find(x, t.right);
		else
			return t; // Match
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * 
	 * @param t
	 *            the node that roots the tree.
	 */
	private void printTree(BinaryNode t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	// TestGroovy program
	public static void main(String[] args) {
		// BinarySearchTree t = new BinarySearchTree();
		// final int NUMS = 4000;
		// final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		BinaryNode root = new BinaryNode(1);
		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);
		BinaryNode left = root.left;
		BinaryNode right = root.right;
		left.left = new BinaryNode(4);
		left.right = new BinaryNode(6);
		//left.right = new BinaryNode(4);
		//right.left = new BinaryNode(5);
		right.right = new BinaryNode(5);
		/*BinaryNode right2 = right.right;
		right2.left = new BinaryNode(7);
		right2.right = new BinaryNode(9);
		BinaryNode left2 = left.right;
		left.left = new BinaryNode(3);
		*/
		
		
		 //printTreeByLevelOneLine(root);
		 System.out.println();
		 //printInOrder(root);
		 System.out.println();
        //path = new ArrayList();
        findPathFromRootToNode(root, right.right);
        Collections.reverse(path);
        System.out.println(" Path " + path);
		 //System.out.println(findTreeHright_iterative(root));
		 //printTreeByLevelOneLineReverse(root);
		// System.out.println(getLeafCount(root));

		// printBSTKeys(root, 52, 59);
		BinarySearchTree bs = new BinarySearchTree();
		//bs.printTreeLevelWiseNewLine(root);
		//System.out.println(bs.oddEvenNodesDifference(root));
		//System.out.println(bs.findDeepestOddLevelNode(root, 1));

	}
}
