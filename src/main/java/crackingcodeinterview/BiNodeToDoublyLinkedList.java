/* 
User: Urmi
Date: 12/26/2019 
Time: 10:06 AM
*/

/**
 * BiNode: Consider a simple data structure called BiNode, which has pointers to two other nodes. The
 * data structure BiNode could be used to represent both a binary tree (where left is the left node
 * and right is the right node) or a doubly linked list (where left is the previous node and right
 * is the next node). Implement a method to convert a binary search tree (implemented with BiNode)
 * into a doubly linked list. The values should be kept in order and the operation should be performed
 * in place (that is, on the original data structure).
 */
package crackingcodeinterview;


import crackingcodeinterview.datastructures.BiNode;

//se details on CTCI pg 572
public class BiNodeToDoublyLinkedList {

    public static void main(String[] args) {
        BiNode root = createTree();
        printAsTree(root, "");//helper method
        BiNode n = convert(root);
        printLinkedListTree(n);//helper method
    }

    private static BiNode convert(BiNode root) {
        if(root == null){
            return null;
        }

        //recursive call on left and right
        BiNode leftSubtree = convert(root.left);
        BiNode rightSubtree = convert(root.right);

        if(leftSubtree != null){
            //left -> root
            concat(getTail(leftSubtree), root);
        }

        if(rightSubtree != null){
            //root -> right
            concat(root, rightSubtree);
        }

        //part1 will be front of left subtree
        return leftSubtree == null ? root : leftSubtree;
    }

    private static BiNode getTail(BiNode node) {
        while(node != null && node.right != null){
            node = node.right;
        }
        return node;

    }

    //x = left, y = root
    //x = root, y = right
    private static void concat(BiNode x, BiNode y){
        x.right = y;
        y.left = x;
    }


    public static BiNode createTree() {
        BiNode[] nodes = new BiNode[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new BiNode(i);
        }
        nodes[4].left = nodes[2];
        nodes[4].right = nodes[5];
        nodes[2].left = nodes[1];
        nodes[2].right = nodes[3];
        nodes[5].right = nodes[6];
        nodes[1].left = nodes[0];
        return nodes[4];
    }
    public static void printAsTree(BiNode root, String spaces) {
        if (root == null) {
            System.out.println(spaces + "- null");
            return;
        }
        System.out.println(spaces + "- " + root.data);
        printAsTree(root.left, spaces + "   ");
        printAsTree(root.right, spaces + "   ");
    }

    public static void printLinkedListTree(BiNode root) {
        for (BiNode node = root; node != null; node = node.right) {
            if (node.right != null && node.right.left != node) {
                System.out.print("inconsistent node: " + node);
            }
            System.out.print(node.data + "->");
        }
        System.out.println();
    }





}
