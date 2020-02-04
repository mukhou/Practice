package dataStructures;


public class MyDoublyLinkedList {
    static Node head;

    static class Node {

        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    /**
     * Insert node in a sorted doubly linked list
     * @param head
     */
    Node sortedInsert(Node head,int data) {

        //create Node and set previous and next
        Node n = new Node(data);
        n.next = null;
        n.prev = null;

        if(head == null){
            head = n;
            return head;
        }

        if(head.data > data){
            n.next = head;
            head.prev = n;
            head = n;
            return head;
        }

        Node current = head;
        //current.next as head checking is already done
        // and current acts as a previous node to current.next, so have a reference to the previous
        while (current.next != null){
            if(current.next.data > data){
                current.next.prev = n;
                n.next = current.next;
                n.prev = current;
                current.next = n;
                return head;
            }
            current = current.next;
        }
        //reached end of list, now addWord anyway
        current.next = n;
        n.prev = current;
        return head;



    }



    /* Function to reverse a Doubly Linked List */
    void reverse() {
        Node temp = null;
        Node current = head;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        //IMP: finally current will be null, and temp will point to 3. so, set head to temp.prev = 4

        /* Before changing head, check for the cases like empty
         list and list with only one node */
        if (temp != null) {
            head = temp.prev;
        }
    }

    /* UTILITY FUNCTIONS */
    /* Function to addWord a node at the beginning of the Doubly Linked List */
    void push(int new_data) {
        /* allocate node */
        Node new_node = new Node(new_data);

        /* since we are adding at the begining,
         prev is always NULL */
        new_node.prev = null;

        /* link the old list off the new node */
        new_node.next = head;

        /* change prev of head node to new node */
        if (head != null) {
            head.prev = new_node;
        }

        /* move the head to point to the new node */
        head = new_node;
    }

    /* Function to print nodes in a given doubly linked list
     This function is same as printList() of singly linked lsit */
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        MyDoublyLinkedList list = new MyDoublyLinkedList();

        /* Let us create a sorted linked list to test the functions
         Created linked list will be 10->8->4->2 */
        list.push(61);
        list.push(51);
        list.push(41);
        list.push(21);

        System.out.println("Original linked list ");
        list.printList(head);
        list.sortedInsert(head, 31);

        //list.reverse();
        System.out.println("");
        System.out.println("The sorted Linked List is ");
        list.printList(head);
    }


}
