package dataStructures;

// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of package DataStructures

public class BinaryNode {

	// Friendly data; accessible by other package routines
	Comparable element; // The data in the node
	public BinaryNode left; // Left child
	public BinaryNode right; // Right child
	public BinaryNode parent;
	public int data;
	// this field is required for special BST with an additional random pointer
	public BinaryNode random;

	// Constructors
	BinaryNode(Comparable theElement) {
		this(theElement, null, null);
	}

	BinaryNode(Comparable theElement, BinaryNode lt, BinaryNode rt) {
		element = theElement;
		left = lt;
		right = rt;
	}

	public BinaryNode(int i) {
		data = i;
	}



	public int getData() {
		return data;
	}
}

