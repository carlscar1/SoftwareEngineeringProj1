package game;
import java.util.ArrayList;

public class Player {
	
	String name;
	int money = 750;
	int pos = 0;
	int doubleStreak = 0;
	Boolean inJail = false;
	
	//array list so it can be added to 
	ArrayList <String> namesOfProperties;
	
	
	public ArrayList <String> getNamesOfProperties(){
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
			// print something?
		}
	}
	
	
}
