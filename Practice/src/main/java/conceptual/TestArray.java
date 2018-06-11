package conceptual;

import java.util.Arrays;
import java.util.List;

public class TestArray {

	int[] arr = new int[5];
	public void show(){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		
	}
	public void display(){
		int[] arr1 = new int[5];
		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		TestArray a = new TestArray();
		//a.show();
		System.out.println();
		//a.display();
		String str = "abc";
		//String[] strArr = {str, 1, "mno"};
        String[] sa = {"one", "two", "three", "four"};
        List sList = Arrays.asList(sa); // make a List
        System.out.println("size " + sList.size());
        System.out.println("idx2 " + sList.get(2));
        sList.set(3,"six"); // change List
        sa[1] = "five"; // change array
        for(String s : sa)
            System.out.print(s + " ");
        System.out.println("\nsl[1] " + sList.get(1));
        System.out.println(sList);
        //UNSUPPORTED OPERATION EXCEPTION
        sList.add(99);
        System.out.println(sList);
		

	}

}
