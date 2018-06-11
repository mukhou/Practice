package goldmansachs;

import java.util.List;

public class FindNumberOfListInParentList {

	//private static int count = 0;
	public static int getCountOfList(List list){
		int count = 0;
		for(Object o : list){
			if(o instanceof List){
				count ++;
				getCountOfList((List)o);
			}
		}
		return count;
			
	}
	
}
