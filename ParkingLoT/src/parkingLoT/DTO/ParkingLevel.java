package parkingLoT.DTO;
import java.util.HashMap;
import java.util.Map;

import parkingLoT.util.State;

public class ParkingLevel {
	private Map<Integer,ParkingSpot[]> vehicleTypeToSpot;
	private State state;
	
	public ParkingLevel(Map<Integer,ParkingSpot[]> vehicleTypeToSpot){
		this.vehicleTypeToSpot = vehicleTypeToSpot;
		this.state = State.EMPTY;
	}

	public Map<Integer,ParkingSpot[]> getVehicleTypeToSpot() {
		return vehicleTypeToSpot;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	

}
