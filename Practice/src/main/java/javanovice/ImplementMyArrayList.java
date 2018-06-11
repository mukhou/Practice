package javanovice;

import dataStructures.LinkedList;

import java.util.Arrays;

public class ImplementMyArrayList {

	private Object[] myArrayList;
	private int listSize = 0;
	
	public ImplementMyArrayList(){
		myArrayList = new Object[10];
	}
	
	public void add(Object o){
		if(myArrayList.length - listSize <= 5){
			increaseListSize();
		}
		myArrayList[listSize++] = o;
	}
	public Object get(int index){
		if(index < listSize){
			return myArrayList[index];
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}	
	
	public Object remove(int index){
		// check if index falls within the list size
		// if yes, remove the elements and shift up the others
		if(index < listSize){
			Object o = myArrayList[index];
			myArrayList[index] = null;
			int temp = index;
			while(temp < listSize){
				myArrayList[temp] = myArrayList[temp+1];
				myArrayList[temp+1] = 0;
				temp++;
			}
			listSize --;
			return o;
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public int size(){
		return listSize;
	}
	public void increaseListSize(){
		myArrayList = Arrays.copyOf(myArrayList, myArrayList.length * 2);
		System.out.println("New length is " + myArrayList.length);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
