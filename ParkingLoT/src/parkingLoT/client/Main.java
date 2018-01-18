package parkingLoT.client;

import java.util.HashMap;
import java.util.Map;

import parkingLoT.DTO.FourWheeler;
import parkingLoT.DTO.FourWheelerSpot;
import parkingLoT.DTO.ParkingLevel;
import parkingLoT.DTO.ParkingSpot;
import parkingLoT.DTO.ParkingStructure;
import parkingLoT.DTO.ThreeWheeler;
import parkingLoT.DTO.ThreeWheelerSpot;
import parkingLoT.DTO.TwoWheeler;
import parkingLoT.DTO.TwoWheelerSpot;
import parkingLoT.DTO.Vehicle;

public class Main {

	public static void main(String[] args) {
		
		
		
		ParkingLevel[] parkingLevels = new ParkingLevel[1];
		for(int i=0; i<parkingLevels.length; i++){
			ParkingSpot[] twoWheelerSpots = new TwoWheelerSpot[5];
			ParkingSpot[] threeWheelerSpots = new ThreeWheelerSpot[5];
			ParkingSpot[] fourWheelerSpots = new FourWheelerSpot[5];
			for(int j=0;j<twoWheelerSpots.length;j++){
				twoWheelerSpots[j] = new TwoWheelerSpot();
				threeWheelerSpots[j] = new ThreeWheelerSpot();
				fourWheelerSpots[j] = new FourWheelerSpot();
			}
			Map<Integer,ParkingSpot[]> vehicleTypeToSpot = new HashMap<Integer,ParkingSpot[]>();
			vehicleTypeToSpot.put(2, twoWheelerSpots);
			vehicleTypeToSpot.put(3, threeWheelerSpots);
			vehicleTypeToSpot.put(4, fourWheelerSpots);
			
			parkingLevels[i] = new ParkingLevel(vehicleTypeToSpot);
		}
		
		ParkingStructure parkingStructure = new ParkingStructure(parkingLevels);
		
		
		//Now Vehicle comes in picture that we need to park
		Vehicle firstTwoWheeler = new TwoWheeler();
		Vehicle firstThreeWheeler = new ThreeWheeler();
		Vehicle firstFourWheeler = new FourWheeler();
		
		//Parking of Vehicles
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		firstTwoWheeler.park(parkingStructure);
		/*firstThreeWheeler.park();
		firstFourWheeler.park();
		
		//Unparking
		firstFourWheeler.unpark();
		firstThreeWheeler.unpark();
		firstTwoWheeler.unpark();*/
	}
	
}
