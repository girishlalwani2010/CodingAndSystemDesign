package parkingLoT.DTO;

import parkingLoT.util.State;

public class TwoWheeler extends Vehicle{

	private void updateLevelState(ParkingLevel parkingLevel, int spotType){
		ParkingSpot[] parkingSpots = parkingLevel.getVehicleTypeToSpot().get(spotType);
		boolean areAllSpotsFull=true;
		for(int i=0; i<parkingSpots.length; i++){
			if(parkingSpots[i].getState().equals(State.EMPTY)){
				areAllSpotsFull = false;
				break;
			}
		}
		if(areAllSpotsFull && spotType<=4)
		{
			if(spotType==4){
				parkingLevel.setState(State.FULL);
			}
			else{
				updateLevelState(parkingLevel, spotType+1);
			}
		}
	}
	
	
	@Override
	public void park(ParkingStructure parkingStructure) {
		if(parkingStructure.getState().equals(State.FULL)){
			System.out.println("Parking is Full");
		}
		else{
			ParkingLevel[] parkingLevels = parkingStructure.getLevels();
			int i;
			boolean isLastLevel = false;
			for(i=0;i<parkingLevels.length; i++){
				if(parkingLevels[i].getState().equals(State.EMPTY)){
					this.setLevelIndex(i);
					if(i==parkingLevels.length-1){
						isLastLevel = true;
					}
					break;
				}
				
			}
			
			//need to check level is full
			ParkingSpot[] parkingSpots = parkingLevels[i].getVehicleTypeToSpot().get(2);
			int j;
			boolean isVehicleParked=false;
			for(j=0;j<parkingSpots.length;j++){
				if(parkingSpots[j].getState().equals(State.EMPTY)){
					isVehicleParked=true;
					this.setSpotIndex(j);
					this.setSpotType(2);
					ParkingSpot parkingSpot = parkingSpots[j];
					parkingSpot.setState(State.FULL);
					if(j==parkingSpots.length-1){
						//need to be update
						updateLevelState(parkingLevels[i],2);
						if(isLastLevel){
							updateParkingStructure(parkingLevels[i],parkingStructure);
						}
					}
					System.out.println("Vehicle is Parked in Two Wheeler Spot");
					break;
				}
			}
			if(!isVehicleParked){
				ParkingSpot[] threeWheelerParkingSpots = parkingLevels[i].getVehicleTypeToSpot().get(3);
				for(j=0;j<threeWheelerParkingSpots.length;j++){
					if(threeWheelerParkingSpots[j].getState().equals(State.EMPTY)){
						isVehicleParked=true;
						this.setSpotIndex(j);
						this.setSpotType(3);
						ParkingSpot parkingSpot = threeWheelerParkingSpots[j];
						parkingSpot.setState(State.FULL);
						if(j==threeWheelerParkingSpots.length-1){
							updateLevelState(parkingLevels[i],3);
							if(isLastLevel){
								updateParkingStructure(parkingLevels[i],parkingStructure);
							}
						}
						System.out.println("Vehicle is Parked in Three Wheeler Spot");
						break;
					}
				}
				
			}
			
			if(!isVehicleParked){
				ParkingSpot[] fourWheelerParkingSpots = parkingLevels[i].getVehicleTypeToSpot().get(4);
				for(j=0;j<fourWheelerParkingSpots.length;j++){
					if(fourWheelerParkingSpots[j].getState().equals(State.EMPTY)){
						isVehicleParked=true;
						this.setSpotIndex(j);
						this.setSpotType(4);
						ParkingSpot parkingSpot = fourWheelerParkingSpots[j];
						parkingSpot.setState(State.FULL);
						if(j==fourWheelerParkingSpots.length-1){
							updateLevelState(parkingLevels[i],4);
							if(isLastLevel){
								updateParkingStructure(parkingLevels[i],parkingStructure);
								}
						}
						System.out.println("Vehicle is Parked in Four Wheeler Spot");
						break;
					}
				}
				
			}
			
		}
		
		
		
	}

	private void updateParkingStructure(ParkingLevel parkingLevel, ParkingStructure parkingStructure) {
		
		if(parkingLevel.getState().equals(State.FULL)){
			parkingStructure.setState(State.FULL);
		}
		
	}


	@Override
	public void unpark() {
		
		
		
	}

}
