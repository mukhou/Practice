package dataStructures;
public class Node{

    Node next;
    Object data;
    Node down;
    Object o1;
    Object o2;
    // this field is required only for doubly linked list
    Node prev;

    //this field is used for special linked lists with an additional random pointer
    Node random;

    Node(Object _data){
        next = null;
        data = _data;
    }

    public Node(int data){
        this.data = data;
    }

    public Node(){

    }

    Node(Object _data, Node _next){
        next = _next;
        data = _data;
    }

    Node(int data, Object o1, Object o2){
        this.data = data;
        this.o1 = o1;
        this.o2 = o2;
    }

    public Object getData(){
        return data;
    }
    public Integer getData1(){
        return (Integer) data;
    }

    public void setData(Object _data){
        data = _data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node _next){
        next = _next;
    }

}
