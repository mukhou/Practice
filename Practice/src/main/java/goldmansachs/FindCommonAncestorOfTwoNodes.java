package goldmansachs;

import dataStructures.BinaryNode;
import dataStructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

public class FindCommonAncestorOfTwoNodes {
    public static ArrayList path;

    public static void main(String[] args){
        path = new ArrayList();
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        BinaryNode left = root.left;
        BinaryNode right = root.right;
        left.left = new BinaryNode(4);
        left.right = new BinaryNode(6);
        right.right = new BinaryNode(5);
        //findAncestor(root, left.right);
        BinarySearchTree.findPathFromRootToNode(root, right.right);
        Collections.reverse(BinarySearchTree.path);
        ArrayList l1 = BinarySearchTree.path;
        System.out.println(l1);
        System.out.println(" Path " + BinarySearchTree.path);

        BinarySearchTree.findPathFromRootToNode(root, left.right);
        Collections.reverse(BinarySearchTree.path);
        ArrayList l2 = BinarySearchTree.path;
        System.out.println(l2);
        System.out.println(" Path " + BinarySearchTree.path);
        int i = 0, count = 0;
        while (i < l2.size()) {
            if (l1.contains(l2.get(i))) {
                count = i;
            }
            i++;

        }

        System.out.println(count);


    }
	// ALGORITHM
	/**
	 * Lets say there are two node given 'F' and 'P' 

	-Find the traversing path for 'F' 
	[Path_1] Root => 'A' => 'B' => 'D' => 'F' 

	-Find the traversing path for 'P' 
	[Path_2] Root => 'A' => 'B' => 'G' => 'L' =>'P' 

	-Compare both of the path and find the last same node in both path 
	---- A and B are common in both of the path, hence B is the common parent
	 for both node 'F' and 'P'

	 */

    public static void findAncestor(BinaryNode root, BinaryNode n){


        BinarySearchTree.findPathFromRootToNode(root, n);
        Collections.reverse(BinarySearchTree.path);
        System.out.println(" Path " + BinarySearchTree.path);


    }
	
}
