package morganstanley;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

 class GenericComparator<T extends Comparable<T>> implements Comparator<T> {
	@Override
	public int compare(T o1, T o2){
		return o1.compareTo(o2);
	}

	
}

 class Person implements Comparable<Person>{
	 private String name;
	 public Person(String name){
		 this.name = name;
	 }
	 
	
	 
	 public int compareTo(Person p){
		 return this.getName().compareTo(p.getName());
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
 }


public class TestGenericComparator{
	
	public static void main(String args[]) {
		Person p1 = new Person("urmi");
		Person p2 = new Person("sharmi");
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		GenericComparator<Person> gc = new GenericComparator<Person>();
		Collections.sort(list);
		System.out.println(list);
	}
	
	
	
}