package parkingLoT.DTO;

public abstract class Vehicle {

	private String id;
	private int size;
	private int levelIndex;
	private int spotIndex;
	private int spotType;
	
	public int getLevelIndex() {
		return levelIndex;
	}
	public void setLevelIndex(int levelIndex) {
		this.levelIndex = levelIndex;
	}
	public int getSpotIndex() {
		return spotIndex;
	}
	public void setSpotIndex(int spotIndex) {
		this.spotIndex = spotIndex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public int getSpotType() {
		return spotType;
	}
	public void setSpotType(int spotType) {
		this.spotType = spotType;
	}
	
	public abstract void unpark();
	public abstract void park(ParkingStructure parkingStructure);
	
	
	
}
