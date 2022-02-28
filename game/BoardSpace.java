package game;

public class BoardSpace {
	String name;
	String description;
	int costToBuy;
	int rent;
	String colorSet;
	boolean owned;
	String ownerName;
	Player owner = new Player();
	
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
	
	public Player getOwner() {
		return owner;
	}
	
	public void setName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public void setDescription(String description) {
		this.description= description;
	}
	
	public void setCostToBuy(int costToBuy) {
		this.costToBuy = costToBuy;
	}
	
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	public void setColorSet(String colorSet) {
		this.colorSet = colorSet;
	}
	
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
