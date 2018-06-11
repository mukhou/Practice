package hackerrank;

import dataStructures.Node;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximum-element/problem
 */

public class MaximumElementStack {

    private static Node head;
    private static int max = Integer.MIN_VALUE;


    private static class Node {
        int data;
        Node next;

        Node(int data){
            this.data =data;
        }
    }

    private static Node head() {
        return head;
    }

    private static int max() {
        return max;
    }

    //idea is the head contains the max value
    private static Node push(int data){
        Node temp = new Node(data);
        temp.next = head;
        if(head == null){
            max = data;
        }else {
            max = (data > head.data ? data : head.data);
        }
        head = temp;

        return head;

    }


    private static Node pop(){
        Node temp = head;
        if(head != null){
            head = head.next;
        }
        temp.next = null;
        // find new max
        Node current = head;
        if(current != null){
            //reset max
            max = current.data;
        }
        while(current!= null){
            max = (max > current.data ? max : current.data);
            current = current.next;
        }
        return head;


    }

    private static void printMaxValue() {
        System.out.println(max);

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        for(int i = 0; i < lines; i++){
            int option;
            try{
                option = in.nextInt();
            }catch (Exception e){
                option = 3;
            }
            switch (option){
                case 1:
                    int item = in.nextInt();
                    push(item);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    if (head() != null) {
                        System.out.println(max());
                    }
                    break;


            }

        }
    }



}
