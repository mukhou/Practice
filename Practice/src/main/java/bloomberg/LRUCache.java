package bloomberg;

import java.util.HashMap;

/**
 * https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * Idea is the head is the most recently used node and the tail is the least recently used
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
        }
    }

    private int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;

    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;

        }
        return -1;
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


    private void setHead(Node n) {
        n.next = head;
        n.prev = null;

        if(head != null){
            head.prev = n;
        }
        head = n;
        //IMP: SET TAIL AFTER HEAD IS SET
        if(tail == null){
            tail = head;
        }
    }



    private void set(int key, int value){
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else {
            //create node
            Node created = new Node(key, value);
            if(map.size() >= capacity){
                //remove LRU, which is the tail node
                map.remove(tail.key);
                remove(tail);
                setHead(created);
            }else {
                setHead(created);
            }
            //put in map
            map.put(key, created);
        }
    }
}
