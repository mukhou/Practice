package anything;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetIntersection {

	public static void setIntersect(Set<Integer> s1, Set<Integer> s2){
		
		
		List<Integer> list1 = new LinkedList<Integer>(s1);
		List<Integer> list2 = new LinkedList<Integer>(s2);
		int x = (list1.size() > list2.size() ? list1.size() : list2.size());
		System.out.println(x);
		/*Collections.sort(list1);
		Collections.sort(list2);*/
		System.out.println(list1);
		System.out.println(list2);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < x; i ++){
			map.put(list2.get(i), i);
		}
		for(int i = 0; i < list1.size(); i ++){
			if(map.containsKey(list1.get(i))){
				Integer key = list1.get(i);
				System.out.println("key: " + key  +" " +"value: "+ map.get(key));
			}
		}
		/*Iterator<Integer> it = s2.iterator();
		while(it.hasNext()){
			map.put(it.next(), 1);
		}
		System.out.println(map);
		Iterator<Integer> it1 = s1.iterator();
		while(it1.hasNext()){
			Integer k = it1.next();
			if(map.containsKey(k)){
				System.out.println("key: " + k.toString()  +" " +"value: "+ map.get(k).toString());
			}
		}*/
		
	}
	public static void main(String[] args) {
		Set<Integer> s1 = new LinkedHashSet<Integer>();
		s1.add(1);
		s1.add(2);
		s1.add(4);
		s1.add(3);
		
		Set<Integer> s2 = new LinkedHashSet<Integer>();
		s2.add(5);
		s2.add(2);
		s2.add(4);
		s2.add(6);
		s2.add(7);
		s2.add(8);
				
		
		
		setIntersect(s1, s2);

		
	}

}
