package collectionsgenericsandstring;

import java.util.ArrayList;
import java.util.List;

class RentalGenericMethod{
	private List<Integer> rentalPool;
	private int maxNum;
	
	public RentalGenericMethod(int maxNum, List<Integer> rentalPool){
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}
	public <T> T genRental(){
		List<T> list = new ArrayList<>();
		return list.get(0);
		
	}
	public <T> void returnRental(T rentedThing){
		List<T> list = new ArrayList<>();
		list.add(rentedThing);
	}
}



public class GenericMethod {

	/**
	 * @param args
	 */
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
