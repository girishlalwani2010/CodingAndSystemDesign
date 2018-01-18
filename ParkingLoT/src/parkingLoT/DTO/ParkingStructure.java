package parkingLoT.DTO;
import java.util.ArrayList;
import java.util.List;

import parkingLoT.util.Security;
import parkingLoT.util.State;
import parkingLoT.util.ParkingSignal;

public class ParkingStructure {

	private ParkingLevel[] levels;
	public ParkingLevel[] getLevels() {
		return levels;
	}
	private List<Security> securityList;
	private ParkingSignal parkingSignal;
	private State state;
	
	public ParkingStructure(ParkingLevel[] levels){
		this.levels = levels;
		securityList = new ArrayList<Security>();
		state = State.EMPTY;
	}
	
	public List<Security> getSecurityList() {
		return securityList;
	}
	public void setSecurityList(List<Security> securityList) {
		this.securityList = securityList;
	}
	public ParkingSignal getParkingSignal() {
		return parkingSignal;
	}
	public void setParkingSignal(ParkingSignal parkingSignal) {
		this.parkingSignal = parkingSignal;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	
	
}
