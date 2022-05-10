package anything;

import java.util.*;


public class SetOperations {

	public static void setIntersect(Set<Integer> g1, Set<Integer> g2) {
		  java.util.List<Integer> list1 = new LinkedList<Integer>(g1);
		  java.util.List<Integer> list2 = new LinkedList<Integer>(g2);
		  System.out.println(list1);
		  System.out.println(list2);
		  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		  for (int i = 0; i < list1.size(); i++) {
		   map.put(list1.get(i), i);
		  }
		  int j = 0;
		  for (int i = 0; i < list2.size(); i++) {
		   if (map.containsKey(list2.get(i))) {
		   // temp[j] = list2.get(i);
		    //idx_sig[j] = list1.indexOf(list2.get(i));
		   }
		   j++;
		  }
		  System.out.println(map);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
