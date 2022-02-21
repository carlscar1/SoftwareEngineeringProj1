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
	
	public void buySpace(BoardSpace occupied) {
		if (occupied.owned == false) {
			namesOfProperties.add(occupied.name);
			occupied.ownerName = getName();
		}
		else {
			// do something?
		}
	}
	
	public int payRent() {
		//		
	}
	
	public boolean isBankrupt() {
		//
	}
	
	
	
	
	
}
