package game;

public class BoardSpace {
	String name;
	String description;
	int costToBuy;
	int rent;
	String colorSet;
	boolean owned;
	String ownerName;
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getCostToBuy() {
		return costToBuy;
	}
	
	public int getRent() {
		return rent;
	}
	
	public String getColorSet() {
		return colorSet;
	}
	
	public boolean getOwned() {
		return owned;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
}
