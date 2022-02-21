package game;
import java.util.ArrayList;

public class Player {
	
	String name;
	int money = 750;
	int pos = 0;
	int doubleStreak = 0;
	Boolean inJail = false;
	
	//array list so it can be added to 
	ArrayList <BoardSpace> namesOfProperties;
	
	
	public ArrayList <BoardSpace> getNamesOfProperties(){
		return namesOfProperties;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getPosition() {
		return pos;
	}
	
	public int getDoubleStreak() {
		return doubleStreak;
	}
	
	public void addToDoubleStreak() {
		doubleStreak++;
	}
	
	public void addMoney(int priceOfProperty) {
		this.money = money + (priceOfProperty);
		//if the player is paying the money, just use a negative input instead
	}
	
	public void payToPlayer(Player recipient, int amountOfMoney) {
		recipient.addMoney(amountOfMoney);
		//amount is negatively "added" to the player paying
		addMoney(-amountOfMoney)
	}
	
	public void buySpace(BoardSpace occupied) {
		if (occupied.owned == false) {
			namesOfProperties.add(occupied.name);
			occupied.ownerName = getName();
			addMoney(-occupied.costToBuy);
		}
		else {
			// do something?
		}
	}
	
	public void printProperties() {
		if (namesOfProperties.isEmpty()) {
			System.out.println("You own no properties");
		}
	}
	
	public boolean doesPlayerOwn (BoardSpace property) {
		return namesOfProperties.contains(property);
	}
	
	public int payRent() {
		//		
	}
	
	public boolean isBankrupt() {
		//
	}
	
	public boolean ownsColorGroup () {
		// fixME not sure on input
	}
	
	
	
	
	
}
