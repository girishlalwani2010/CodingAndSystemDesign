package parkingLoT.DTO;
import parkingLoT.util.State;

public class ParkingSpot {
	private State state;
	
	public ParkingSpot(){
		this.state = State.EMPTY;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
