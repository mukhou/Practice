package collectionsgenericsandstring;

import java.util.ArrayList;
import java.util.List;

class RentalGeneric<T>{
	private List<T> rentalPool;
	private int maxNum;
	
	public RentalGeneric(int maxNum, List<T> rentalPool){
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}
	public T genRental(){
		return rentalPool.get(0);
	}
	public void returnRental(T rentedThing){
		rentalPool.add(rentedThing);
	}
}

class Car{}

public class TestRental {

	
	public static void main(String[] args) {
		//make some Cars for the pool
		Car c1 = new Car();
		Car c2 = new Car();
		List<Car> carList = new ArrayList<Car>();
		carList.add(c1);
		carList.add(c2);
		RentalGeneric<Car> carRental = new RentalGeneric<Car>(2, carList);
		// now get a car out, and it won't need a cast
		Car carToRent = carRental.genRental();
		carRental.returnRental(carToRent);
		// cannot add anything other than Car to this list
		//carList.add(new Integer(5));

	}

}
