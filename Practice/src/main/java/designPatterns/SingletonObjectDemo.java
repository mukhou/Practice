package designPatterns;


import java.util.concurrent.locks.ReentrantLock;

class SingletonClass {
	
	private static volatile SingletonClass singletonObject;
	private SingletonClass(){
		if(singletonObject != null){
		      System.out.println("Object already created....");
		}
	}
	
	public static SingletonClass getSingletonObject(){
		if(singletonObject == null){
			synchronized(SingletonClass.class){
				// double checking
				if(singletonObject == null){
					singletonObject = new SingletonClass();
				}
			}


			
		}
		return singletonObject;
	}
	public SingletonClass clone() throws CloneNotSupportedException{
		try{
			return SingletonClass.getSingletonObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}

public class SingletonObjectDemo {

	
	public static void main(String[] args) {
		SingletonClass obj = SingletonClass.getSingletonObject();
		System.out.println("Singleton object created");

	}

}
