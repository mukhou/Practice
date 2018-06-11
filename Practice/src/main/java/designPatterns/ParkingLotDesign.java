package designPatterns;

import java.util.List;

public class ParkingLotDesign {

}

class ParkingLot{
	List<ParkingSpace> spaces;
}

class ParkingSpace{


	boolean available;
	int length; 
	int width;

	void setDimensions(int length,int width){
		this.length = length;
		this.width = width;
	}
	
	ParkingSpaceType parkType;
	enum ParkingSpaceType{
		REGULAR_SPOT,
		HANDICAP_SPOT,
		COMPACT_SPOT
	}
}

	
	



