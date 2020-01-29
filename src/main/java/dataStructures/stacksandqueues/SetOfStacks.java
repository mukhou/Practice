package dataStructures.stacksandqueues;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {

    List<StackUsingArray> stacks = new ArrayList<>();
    public int capacity;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
    }

    //push to the last stack
    public void push(int item){
        StackUsingArray last = getLastStack();
        if(!last.isFull()){
            last.push(item);
        }
        else {
            StackUsingArray newStack = new StackUsingArray();
            newStack.push(item);
            stacks.add(newStack);
        }
    }

    //pop from the last stack
    public int pop(){
        StackUsingArray last = getLastStack();
        int data = last.pop();
        if(last.isEmpty()){
            stacks.remove(last);
        }
        return data;

    }

    private StackUsingArray getLastStack() {
        if(stacks.size() == 0){
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }
}
