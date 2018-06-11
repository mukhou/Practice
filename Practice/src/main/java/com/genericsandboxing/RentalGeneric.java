package com.genericsandboxing;

import java.util.List;

public class RentalGeneric<T> {

	private List<T> rentalPool;
	private int maxNum;

	public RentalGeneric(int maxNum, List<T> rentalPool) {
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}
	public T getRental(){
		return rentalPool.get(0);
	}
	public void returnRental(T rentalThing){
		rentalPool.add(rentalThing);
	}

}
