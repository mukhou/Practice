package collectionsgenericsandstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortAHashMapByValues {

	
	public static void main(String[] args) {
		Map<String, Person> map = new HashMap<String, Person>();
		Person jim = new Person("Jim", 25);
	    Person scott = new Person("Scott", 28);
	    Person anna = new Person("Anna", 23);

	    map.put(jim.getName(), jim);
	    map.put(scott.getName(), scott);
	    map.put(anna.getName(), anna);
	    
	    // not yet sorted
	    List<Person> list = new ArrayList<Person>(map.values());

		//USING JAVA 8
		List<Integer> agesSorted = map.values().stream().
				sorted(Comparator.comparing(Person::getAge)).
				map(p -> p.getAge()).
				collect(Collectors.toList());

		//OLD WAY: USING COMPARATOR
	    // now to sort the above list, we need a Comparator
	    // which compares a Person object with another Person object
	    // we will do this using an anonymous class
	    // an Argument defined anonymous class
	    // A VERY GOOD EXAMPLE
	    
	    Collections.sort(list, new Comparator<Person>(){
	    	public int compare(Person a, Person b){
	    		return b.getAge().compareTo(a.getAge());
	    	}
	    });

	    Collections.sort(list, (a, b) -> a.getAge().compareTo(b.getAge()));
	    Collections.sort(list, Comparator.comparing(Person::getAge));
	    
	    for (Person p : list) {
	        System.out.println(p.getName() + "\t" + p.getAge());
	    }





	}

}

/*class PersonComparator implements Comparator<Person>{
	public int compare(Person a, Person b){
		return a.getAge().compareTo(b.getAge());
	}
}*/
 

class Person{
	private String name;
	private Integer age;
	
	public Person(String name, Integer age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
