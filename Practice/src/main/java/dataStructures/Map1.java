package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Map1 {

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Map m1 = new HashMap();

		
		// If use TreeMap, o/p will be in sorted order ascending(alphabetically)
		m1.put("Urmi", "Jhini");
		m1.put("Sharmi", "Rini");
		m1.put("Abhi", "Bantu");

        List l = (List) m1.values();
		
		Iterator it = m1.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry e = (Map.Entry)it.next();
			System.out.println(e.getKey() + " " + e.getValue());
		}
		
		List<String> list = new ArrayList<String>();
		list.add("Urmi");
		list.add("Sharmi");
		
		Iterator it1 = list.iterator();
		while(it1.hasNext()){
			//System.out.println(it1.next());
		}

	}

}
