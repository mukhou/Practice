package goldmansachs;

import java.util.HashMap;
import java.util.Map;

public class DifferenceBetweenTwoHashMaps {

	static HashMap<String, Double> difference(HashMap<String, Double> map1, 
			HashMap<String, Double> map2){
		
		HashMap<String,Double> result_map = new HashMap<String,Double>();
		for(Map.Entry<String, Double> entrySet: map1.entrySet()){
			// get the key
			String key = entrySet.getKey();
			if(map2.containsKey(key)){
				double diff = entrySet.getValue() - map2.get(key);
				result_map.put(key, diff);
			}
		}
		return map1;
		
	}
}
