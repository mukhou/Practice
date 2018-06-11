package conceptual;

public class Inheritance1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Horse h = new Horse();
		Animal a = (Animal)h;
		Animal a1 = new Horse();
		//a1.m1(); -- cannot invoke a private method
		
		

	}

}


class Animal{
	void show(){};
	private void m1(){};
}

class Horse extends Animal{
	public void show(){
		System.out.println("Interface implementation");
	}
}