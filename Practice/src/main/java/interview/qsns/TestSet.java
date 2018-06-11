package interview.qsns;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestSet {

	
	public static void main(String[] args) {
		
		Set<String> str = new LinkedHashSet<String>();
		str.add("abc");
		str.add("def");
		str.add("ghi");
		
		Iterator<String> it = str.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

        for(String s : str){
            System.out.println(s);
        }



	}

}
