package collectionsgenericsandstring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyMap {

	
	public static void main(String[] args) {
		
		Map<String, String> smap = new HashMap<String, String>();
		smap.put("Boston", "Logan");
		smap.put("Lubbock", "Houston");
		smap.put("NY", "JFK");
		
		/*Iterator it = smap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry me = (Map.Entry)it.next();
			System.out.println(me.getKey() + " "+ me.getValue());
		}*/
		
		for(Map.Entry<String, String> entrySet : smap.entrySet()){
			System.out.println(entrySet.getKey() + " " + entrySet.getValue());
		}
		
		

	}

}
