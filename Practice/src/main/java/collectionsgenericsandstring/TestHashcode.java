package collectionsgenericsandstring;

import java.util.HashMap;

class MyTest{
	public int i = 1;
	public int hashCode(){
		return i;
	}
}
public class TestHashcode {

	
	public static void main(String[] args) {
		HashMap<MyTest, String> map = new HashMap<MyTest, String>();
		MyTest t1 = new MyTest();
		map.put(t1, "success");
		System.out.println(map.get(t1));
		t1.i = 10;
		// VERY IMPOTANT POINT: 
		// Because the variable i is used to create the hashcode, 
		//changing the value, changed the value of the 	hashcode
		// and the get invocation returned null
		// Refre SCJP book pg 585(of book)
		System.out.println(map.get(t1));

	}

}
