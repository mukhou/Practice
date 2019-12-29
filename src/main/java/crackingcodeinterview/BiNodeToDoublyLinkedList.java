/* 
User: Urmi
Date: 12/26/2019 
Time: 10:06 AM
*/

/**
 * BiNode: Consider a simple data structure called BiNode, which has pointers to two other nodes. The
 * data structure BiNode could be used to represent both a binary tree (where nodel is the left node
 * and node2 is the right node) or a doubly linked list (where nodel is the previous node and node2
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
        BiNode part1 = convert(root.node1);
        BiNode part2 = convert(root.node2);

        if(part1 != null){
            concat(getTail(part1), root);
        }

        if(part2 != null){
            concat(root, part2);
        }

        return part1 == null ? root : part1;
    }

    private static BiNode getTail(BiNode node) {
        if(node == null){
            return null;
        }
        while(node.node2 != null){
            node = node.node2;
        }
        return node;

    }

    private static void concat(BiNode x, BiNode y){
        x.node2 = y;
        y.node1 = x;
    }


    public static BiNode createTree() {
        BiNode[] nodes = new BiNode[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new BiNode(i);
        }
        nodes[4].node1 = nodes[2];
        nodes[4].node2 = nodes[5];
        nodes[2].node1 = nodes[1];
        nodes[2].node2 = nodes[3];
        nodes[5].node2 = nodes[6];
        nodes[1].node1 = nodes[0];
        return nodes[4];
    }
    public static void printAsTree(BiNode root, String spaces) {
        if (root == null) {
            System.out.println(spaces + "- null");
            return;
        }
        System.out.println(spaces + "- " + root.data);
        printAsTree(root.node1, spaces + "   ");
        printAsTree(root.node2, spaces + "   ");
    }

    public static void printLinkedListTree(BiNode root) {
        for (BiNode node = root; node != null; node = node.node2) {
            if (node.node2 != null && node.node2.node1 != node) {
                System.out.print("inconsistent node: " + node);
            }
            System.out.print(node.data + "->");
        }
        System.out.println();
    }





}
