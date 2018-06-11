package arraysandstrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleList {
	public static void shuffleList(List<Integer> list) {
	    int n = list.size();
	    Random random = new Random();
	    //random.nextInt();
	    for (int i = 0; i < n; i++) {
	      int new_index = i + random.nextInt(n - i);
	      swap(list, i, new_index);
	    }
	  }

	  private static void swap(List<Integer> list, int i, int new_index) {
	    int temp = list.get(i);
	    list.set(i, list.get(new_index));
	    list.set(new_index, temp);
	  }

	  public static void main(String[] args) {
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    list.add(5);
	    list.add(6);
	    list.add(7);
	    shuffleList(list);
	    for (int i : list) {
	      System.out.println(i);
	    }
	  }

}
