package dataStructures;

import java.util.HashMap;

/**
 * https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * Idea is head is the least recently used and tail is the most recently used node
 */
public class LRUCache {

    private class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            next = prev = null;
        }
    }

    private int capacity;
    HashMap<Integer, Node> map = null;
    //start and end pointers of cache
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setTail(n);
            return n.value;

        }
        return -1;
    }

    private void put(int key, int value){
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);//update pointers
            setTail(old);
        }else {
            //create node
            Node created = new Node(key, value);
            if(map.size() >= capacity){
                //IMP: remove LRU, which is the head node
                map.remove(head.key);
                remove(head);
                setTail(created);
            }else {
                setTail(created);
            }
            //finally put in map
            map.put(key, created);
        }
    }

    private void remove(Node n) {
        if(n.prev != null){
            n.prev.next = n.next;
        }else {
            //set head to next
            head = n.next;
        }

        if(n.next != null){
            n.next.prev = n.prev;
        }else {
            //set tail to pre
            tail = n.prev;
        }
    }

    //ATM: at this stage, the remove(n) method has already been called
    //so the next and prev pointers of the nodes previous and next of n are already set
    //now you only need to update next and prev pointers of n so that it becomes the new tail
    private void setTail(Node n) {
        if(tail != null){
            tail.next = n;
        }
        n.prev = tail;
        n.next = null;
        tail = n;

        if(head == null){
            head = tail;
        }
    }

}
