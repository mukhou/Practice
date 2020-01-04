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
	public static int findTreeHeight_iterative(BinaryNode rootNode) {
		if (rootNode == null) {
			return 0;
		}
		Queue<BinaryNode> queue = new java.util.LinkedList<>();
		// ENQUEUE
		queue.add(rootNode);
		int height = 0;
		while (true) {
			// find node count for every level
			int nodeCount = queue.size();
			// for each iteration, after nodeCount is emptied,
			// return the value of height
			if (nodeCount == 0) {
				return height;
			}
			// increase height for each new level
			height++;
			while (nodeCount > 0) {
				// DEQUEUE
				BinaryNode temp = queue.poll();
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
				// decrease nodeCount
				nodeCount--;
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
	 * Detailed expl: Given a Binary Tree and a number sum,
	 * WAP to see if there exists a root to leaf path in the tree whose
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
	 * given a binary tree in which each node contains an integer value, Ddsign an algorithm to count the number of paths that sum to a
	 * given value.
	 */
	public int countPathsWithSum(BinaryNode root, int sum){
		if(root == null){
			return 0;
		}

		int pathsFromRoot = countPathsWithSumFromNode(root, sum, 0);
		
		int pathsFromLeft = countPathsWithSum(root.left, sum);
		int pathsFromRight = countPathsWithSum(root.right, sum);
		
		return pathsFromRoot + pathsFromLeft + pathsFromRight;


	}

	private int countPathsWithSumFromNode(BinaryNode node, int targetSum, int curr_sum) {
		if(node == null){
			return 0;
		}

		curr_sum += node.data;
		int totalPaths = 0;
		if(curr_sum == targetSum){
			totalPaths ++;
		}
		totalPaths += countPathsWithSumFromNode(node.left, targetSum, curr_sum);
		totalPaths += countPathsWithSumFromNode(node.right, targetSum, curr_sum);

		return totalPaths;

	}

	/**
	 * GS
	 * Find the distance of a node from the root in a binary tree.Print error message if node doesn't exist. 
	 * Extend the problem to distance of any node to any other node that is below it.
	 * distance = 0,initially
	 */
	public int findDistanceBetweenTwoNodes(BinaryNode node, int key)	{
		if(node == null) return 0;
		int distance = -1;
		// Check if x is present at root or in left
		// subtree or right subtree.
		if ((root.data == key) ||
				(distance = findDistanceBetweenTwoNodes(root.left, key)) >= 0 ||
				(distance = findDistanceBetweenTwoNodes(root.right, key)) >= 0)
			return distance + 1;

		return distance;
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
	 * ALGORITHM: https://www.geeksforgeeks.org/inorder-succesor-node-binary-tree/
	 */
	public BinaryNode findInOrderSuccessor(BinaryNode n){
		if(n != null){
			// Case 1: n has right child
			if(n.right != null){
				return leftMostNode(n.right);
			}else {
				BinaryNode temp = n;
				BinaryNode p = n.parent;
				// Go up until we’re on left instead of right
				while(p != null && p.left != temp){
					temp = p;
					p = p.parent;
				}
			}
		}
		return null;
	}

	private BinaryNode findInorderRecursive(BinaryNode root, BinaryNode n) {
		if(root == null){
			return null;
		}
		BinaryNode temp = null;
		if (root==n || (temp = findInorderRecursive(root.left,n))!=null ||
				(temp = findInorderRecursive(root.right,n))!=null)
		{
			if (temp!=null)
			{
				if (root.left == temp)
				{
					System.out.print( "Inorder Successor of "+n.data);
					System.out.print( " is "+ root.data + "\n");
					return null;
				}
			}

			return root;
		}

		return null;
	}

	BinaryNode leftMostNode(BinaryNode node){
		while(node != null && node.left != null){
			node = node.left;
		}
		return node;
	}

	BinaryNode rightMostNode(BinaryNode node){
		while(node != null && node.right != null){
			node = node.right;
		}
		return node;
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
			return 1 + Math.max(maxDepth(rootNode.left, height),
					maxDepth(rootNode.right, height));
	}
	

	// Find the min depth
	public static int minDepth(BinaryNode rootNode, int height) {
		if (rootNode == null) {
			return 0;
		} else if (rootNode.left == null & rootNode.right == null) {
			return height;
		}// assuming left and right nodes are not null
		else
			return 1 + Math.min(minDepth(rootNode.left, height),
					minDepth(rootNode.right, height));
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
		if (rootNode.left == null && rootNode.right == null)
			return false;
		boolean leftOk = false;
		boolean rightOk = false;
		boolean centerOk = false;
		// check left subtree
		if (rootNode.left != null)
			leftOk = isBST(rootNode.left, rootNode.data - 1, min);
		// check root
		if (rootNode.data >= min && rootNode.data <= max)
			centerOk = true;
		else
			centerOk = false;
		// check right subtree
		if (rootNode.right != null)
			rightOk = isBST(rootNode.right, max, rootNode.data + 1);
		return leftOk && centerOk && rightOk;
	}
	

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
	 * Given large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
	 */

	public boolean containsTree(BinaryNode t1, BinaryNode t2){
		if (t2 == null) {
			return true;
		}else {
			return subTree(t1, t2);
		}
	}

	private boolean subTree(BinaryNode t1, BinaryNode t2) {
		if(t1 == null){
			return false;
		}
		if(t1.data == t2.data){
			if(matchTree(t1, t2)){
				return true;
			}
		}
		return (subTree(t1.left, t2) || subTree(t1.right, t2));
	}

	private boolean matchTree(BinaryNode t1, BinaryNode t2) {
		if(t1 == null && t2 == null){
			return true;
		}
		if(t1 == null || t2 == null){
			return false;
		}
		if(t1.data != t2.data){
			return false;
		}
		return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);

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
	public static void printInOrder(BinaryNode root){
		if(root == null)
			return;		
		BinaryNode current = root;
		while(current != null){
			// if no left subtree, print the root and then right subtree
			if(current.left == null){
				System.out.println(current.data);
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
					System.out.println(current.data);
					current = current.right;
				}				
			}
		}		
	}

	public static void inorderTraversalUsingStack(BinaryNode root){
		Stack<BinaryNode> stack = new Stack<>();

		// Start by adding left subtree to stack
		addToStack(stack, root);

		// While there are elements in the stack, pop and move the minimum
		// possible distance to the right
		while(!stack.isEmpty()){
			BinaryNode current = stack.pop();
			System.out.println(current.data);
			// Add the right child and any of its left children to the stack
			addToStack(stack, current.right);

		}

	}

	private static void addToStack(Stack<BinaryNode> stack, BinaryNode root) {
		while(root != null){
			stack.push(root);
			root = root.left;
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
		rootNode = rightMostNode(rootNode);

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
			// IMPORTANT: increase level, even if there are no new nodes at
			// present level
			level = level + 1;
			// add the nodes of this level to the result list
			if (nodeList.size() > 0) {
				resultList.add(level, nodeList);
			} else {
				break;
			}
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


		// level of maximum nodes
		int maxNodeslevel = 0, maxNodes = 0;

		// no. of nodes at the previous and current level
		int prevLevelCount_Nodes = 0, currentlevelCount_Nodes = 0;

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
			BinaryNode temp = currentQueue.poll();
			while (temp != null) {
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
			tempRight = rightMostNode(tempRight);
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

	public int bstIter(int[] arr, int key){
		int low = 0, high = arr.length - 1, mid;
		while(low < high){
			mid = (low + high) / 2;
			if(arr[mid] == key){
				return mid;
			} else if(arr[mid] < key){
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return -1;
	}

	//initially low = 0, high = arr.length - 1
	public int bstRecur(int[] arr, int low, int high, int key){
		if(low > high){
			return -1;
		}
		int mid = (low + high) / 2;
		if(arr[mid] == key){
			return mid;
		}else if(arr[mid] < key){
			return bstRecur(arr, mid + 1, high, key);
		}else {
			return bstRecur(arr, low, mid - 1, key);
		}
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
			if (current.data == data)
				return;
			if (data < current.data) {
				if (current.left == null) {
					current.left = new BinaryNode(data);
					return;
				} else {
					current = current.left;
				}
			} else {
				if (current.right == null) {
					current.right = new BinaryNode(data);
					return;
				} else {
					current = current.right;
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
			internalInsert(current, data);
		}
	}

	private void internalInsert(BinaryNode current, int data) {
		if (current.data == data) {
			return;
		} else if (data < root.data) {
			if (root.left == null) {
				root.left = new BinaryNode(data);
			} else {
				internalInsert(current.left, data);
			}
		} else {
			if (root.right == null) {
				root.right = new BinaryNode(data);
			} else {
				internalInsert(current.right, data);
			}
		}
	}
	private Comparable elementAt(BinaryNode t) {
		return t == null ? null : t.element;
	}

	//https://www.java2novice.com/java-interview-programs/delete-node-binary-search-tree-bst/
	private BinaryNode deleteNode(BinaryNode root, int data) {

		if(root == null) return root;

		if(data < root.getData()) {
			root.left = deleteNode(root.left, data);
		} else if(data > root.getData()) {
			root.right = deleteNode(root.right, data);
		} else {//data matches with root
			// node with no leaf nodes
			if(root.left == null && root.right == null) {//no children
				System.out.println("deleting "+data);
				return null;
			} else if(root.left == null) {
				// node with one node (no left node)
				System.out.println("deleting "+data);
				return root.right;
			} else if(root.right == null) {
				// node with one node (no right node)
				System.out.println("deleting "+data);
				return root.left;
			} else {
				// nodes with two nodes
				// search for min number in right sub tree
				Integer minValue = leftMostNode(root.right).data;
				root.data = minValue;
				//recursive call
				root.right = deleteNode(root.right, minValue);
				System.out.println("deleting "+data);
			}
		}

		return root;
	}


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



	// TestGroovy program
	public static void main(String[] args) {
		// BinarySearchTree t = new BinarySearchTree();
		// final int NUMS = 4000;
		// final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		//BinaryNode root = new BinaryNode(20);

		//left.right = new BinaryNode(6);
		//left.right = new BinaryNode(4);

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.root = new BinaryNode(20);
		binarySearchTree.root.left = new BinaryNode(18);
		binarySearchTree.root.right = new BinaryNode(27);
		BinaryNode left = binarySearchTree.root.left;
		BinaryNode right = binarySearchTree.root.right;
		left.left = new BinaryNode(15);
		right.left = new BinaryNode(26);
		right.right = new BinaryNode(28);
		binarySearchTree.insertIterative(19);
		printInOrder(binarySearchTree.root);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		inorderTraversalUsingStack(binarySearchTree.root);
		/*BinaryNode right2 = right.right;
		right2.left = new BinaryNode(7);
		right2.right = new BinaryNode(9);
		BinaryNode left2 = left.right;
		left.left = new BinaryNode(3);
		*/
		
		 //printTreeByLevelOneLine(root);

		 //printInOrder(root);
		 System.out.println();
        //path = new ArrayList();
       // findPathFromRootToNode(root, right.right);
       /* Collections.reverse(path);
        System.out.println(" Path " + path);*/
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
