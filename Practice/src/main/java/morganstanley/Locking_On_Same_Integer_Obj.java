package morganstanley;

import java.util.HashMap;

public class Locking_On_Same_Integer_Obj {
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	String val;

	public void print(Integer obj) {
		if (map.get(obj) == null) {
			val = obj.toString();
			map.put(obj, val);
		} else {
			val = map.get(obj);
		}
		synchronized (val) {
			int i = 0;
			while (i < 1000) {
				System.out.println(Thread.currentThread().getName());
				System.out.println(obj);
				i++;
				if (i > 100)
					break;
			}
		}

	}

	public static void main(String args[]) {
		Locking_On_Same_Integer_Obj obj1 = new Locking_On_Same_Integer_Obj();
		Thread t1 = new Thread(new ThreadTest(130, obj1));
		Thread t2 = new Thread(new ThreadTest(130, obj1));
		t1.start();
		t2.start();

	}

}
class ThreadTest implements Runnable{
	Integer value;
	Locking_On_Same_Integer_Obj testObj;
	public ThreadTest(int k,Locking_On_Same_Integer_Obj lock){
		value = k;
		testObj = lock;
		//testObj.print(value);
	}
	
	@Override
	public void run(){
		testObj.print(value);
	}
}