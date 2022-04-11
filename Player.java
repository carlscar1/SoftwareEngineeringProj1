package game;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    /** holds the string name of each Player */
    String name;

    /** gives each Player $750 as an integer to begin and keeps track of their money throughout game */
    int money = 750;

    /** starts each player at space 0 and keeps track of their position throughout game */
    int pos = 0;

    /** keeps track of the number of doubles rolled starts player with 0 */
    int doubleStreak = 0;

    /** boolean to show if a player is currently in jail starts at false */
    boolean inJail = false;

    /** counts the amount of turns a player is in jail for */
    int inJailCounter = 0;

    /** boolean to show if a player is able to move spaces, start at true */
    boolean isMoving = true;

    /** array list holds the names of properties that a player owns */
    ArrayList <BoardSpace> namesOfProperties = new ArrayList();

    int outOfJailFree = 0;
    
    boolean isPlayer = false;

    /*****************************************************************
     Returns the names of properties that the player owns.
     @return namesOfProperties: array list of the properties
     the Player owns
     *****************************************************************/
    public ArrayList <BoardSpace> getNamesOfProperties(){
        return namesOfProperties;
    }

    /*****************************************************************
     Returns the name of the player.
     @return name of Player
     *****************************************************************/
    public String getName() {
        return name;
    }

    /*****************************************************************
     Returns the integer amount of money a player has.
     @return money as an integer
     *****************************************************************/
    public int getMoney() {
        return money;
    }

    /*****************************************************************
     Returns the position the Player is at on the board.
     @return pos as an integer
     *****************************************************************/
    public int getPosition() {
        return pos;
    }

    /*****************************************************************
     Returns the doubles streak a Player has as an integer.
     @return doubleStreak as an integer, the amount of doubles a
     Player has rolled
     *****************************************************************/
    public int getDoubleStreak() {
        return doubleStreak;
    }

    /*****************************************************************
     Returns the integer number of turns a player is in jail for.
     @return inJailCounter as an integer of the number of turns
     a Player is in jail for
     *****************************************************************/
    public int getJailCounter() {
        return inJailCounter;
    }

    public int getOutOfJailFree() {
        return outOfJailFree;
    }

    /*****************************************************************
     Sets the Player name to the input parameter name.
     @param name as a string that the name is changed to
     *****************************************************************/
    public void setName(String name) {
        this.name = name;
    }

    /*****************************************************************
     Sets the Player's amount of money to the input parameter amount.
     @param money as an integer amount of the money a player will have
     *****************************************************************/
    public void setMoney(int money) {
        this.money = money;
    }
    
    public void changeMoney(int money) {
    	this.money+=money;
    }

    /*****************************************************************
     Sets the Player's position to the input parameter position.
     @param pos changes the Player's position on the board to this number
     *****************************************************************/
    public void setPosition(int pos) {
        this.pos = pos;
    }
    
    
    public void setPlayerType(String playerType) {
    	if(playerType == "Player")
    		this.isPlayer = true;
    	else
    		this.isPlayer = false;
    }
    
    public boolean getIsPlayer() {
    	return isPlayer;
    }
    
    public void changeJailFree(int cardsGained) {
    	this.outOfJailFree += cardsGained;
    }

    /*****************************************************************
     Adds one to the doubleStreak of a Player
     *****************************************************************/
    public void addToDoubleStreak() {
        doubleStreak++;
    }

    /*****************************************************************
     Resets the doubleStreak of a Player to 0
     *****************************************************************/
    public void resetDoubleStreak() {
        doubleStreak = 0;
    }

    /*****************************************************************
     Adds one to the inJailCounter of a Player
     *****************************************************************/
    public void addToJailCounter() {
        inJailCounter++;
    }

    /*****************************************************************
     Resets the inJailCounter of a Player to 0
     *****************************************************************/
    public void resetJailCounter() {
        inJailCounter = 0;
    }

    /*****************************************************************
     Adds the input paramenter amount of money to Player's money
     variable. If money needs to be subtracted, just use a negative
     amount in the input parameter.
     @param priceOfProperty is the money amount that is added to a
     Player's money
     *****************************************************************/
    public void addMoney(int priceOfProperty) {
        money += priceOfProperty;
        //if the player is paying the money, just use a negative input instead
    }

    /*****************************************************************
     Pays the input amount of money to the Player recipient (first param).
     Also subtracts the paid amout from the "paying" Player's money amount.
     @param recipient is type Player and is the Player that is being paid
     @param amountOfMoney is integer amount of money being paid to recipient
     *****************************************************************/
    public void payToPlayer(Player recipient, int amountOfMoney) {
        recipient.addMoney(amountOfMoney);
        //amount is negatively "added" to the player paying
        addMoney(-amountOfMoney);
    }
    
    public void addProperty(BoardSpace occupied) {
    	this.namesOfProperties.add(occupied);
    }

    /*****************************************************************
     Buys space if it is not already owned. Gives player option to buy
     or refuse to buy.
     @param occupied is the space the player is on, gets checked to
     see if already owned or available to buy
     @param currentPlayer is the Player that is able to buy because
     it is their turn. They will have the property and the property
     name is added to their namesOfProperties. They also must pay
     the amount needed to buy that property space.
     *****************************************************************/
    public void buySpace(BoardSpace occupied, Player currentPlayer) {
        Scanner scan = new Scanner(System.in);
        //System.out.println("Post Scan Call");
        //System.out.println(occupied.getOwned());
        //System.out.println(occupied.getOwnerName());
        if (occupied.getOwned() == false) {
            System.out.println("Player can buy this property for $" + occupied.getCostToBuy() + ".");
            if(currentPlayer.getMoney() < occupied.getCostToBuy()) {
            	System.out.println("This space is too expensive!");
            }
            else if (currentPlayer.getIsPlayer()) { // only giving option to non-computer player
            	//System.out.println("We are looking at a space and I am a player");
            	//System.out.println();
            	System.out.println();
                System.out.println("Does player want to buy this space?");
                System.out.println("Type: 'y' for yes or 'n' for no");
                String yesOrNo = scan.next();
                //System.out.println(yesOrNo);
                String tempYes = "y";
                if(yesOrNo.equalsIgnoreCase(tempYes)) {
                	System.out.println("Space bought for $" + occupied.getCostToBuy() + " by " + currentPlayer.getName() + "!");
                	System.out.println();
                    currentPlayer.addProperty(occupied);
                    occupied.setOwnerName(currentPlayer.getName());
                    currentPlayer.changeMoney(-occupied.getCostToBuy());
                }
                else {
                    System.out.println("Space is not bought.");
                }
            }
            else {
            	System.out.println("Space bought for $" + occupied.getCostToBuy() + " by " + currentPlayer.getName() + "!");
            	System.out.println();
                currentPlayer.addProperty(occupied);
                occupied.setOwnerName(currentPlayer.getName());
                currentPlayer.changeMoney(-occupied.getCostToBuy());
            }
        }
        else {
            System.out.println("Space is owned by " + occupied.getOwnerName());
        }
    }

    /*****************************************************************
     Prints out the names of the properties that Player owns. If they
     do not own any spaces, it prints that they do not have any
     spaces that they own.
     *****************************************************************/
    public void printProperties() {
        if (namesOfProperties.isEmpty()) {
            System.out.println("You own no properties");
        }
        else {
            for(int i = 0; i < namesOfProperties.size(); i++) {
                System.out.println(namesOfProperties.get(i).name);
            }
        }
    }

    /*****************************************************************
     Returns a boolean showing if this player owns the input parameter
     space by checking if the space name is in the list of the names
     of properties for that player.
     @param property the BoardSpace being checked to see if the player
     owns that space
     @return boolean true/false if the player owns the BoardSpace
     *****************************************************************/
    public boolean doesPlayerOwn (BoardSpace property) {
        return namesOfProperties.contains(property);
    }

    /*****************************************************************
     Pays the appropriate amount of rent to the owner Player of the space
     that the currentPlayer (input parameter) is occupying. Returns the
     amount that the rent costs.
     @param currentPlayer which is the player that is paying the rent to
     the owner of whatever space they landed on.
     @return cost of rent that the player paid for the space
     *****************************************************************/
    public int payRent(Player currentPlayer) {
        int cost = Board.spaces[currentPlayer.pos].rent;
        payToPlayer(Board.spaces[currentPlayer.pos].owner, cost);
        return cost;
    }

    /*****************************************************************
     Returns a boolean showing if a player has zero or less money.
     If they do, they are bankrupt and the function returns true.
     @return boolean if the player has no money, then bankrupt so true
     *****************************************************************/
    public boolean isBankrupt() {
        if(money <= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /*****************************************************************
     Returns a boolean displaying if a Player owns every property in the
     input color's color group.
     @param color is the color group being checked against the Player's
     properties
     @return boolean to show if a Player owns an entire color group
     of properties
     *****************************************************************/
    public boolean ownsColorGroup (String color) {
        int tempColor = 0;
        int maxTemp;
        if(color == "purple" || color == "blue" || color == "utilities") {
            maxTemp = 2;
        }
        else if(color == "railroad") {
            maxTemp = 4;
        }
        else {
            maxTemp = 3;
        }
        for(int i = 0; i < getNamesOfProperties().size(); i++) {
            if((getNamesOfProperties().get(i)).getColorSet() == color) {
                tempColor++;
            }
        }
        if(tempColor < maxTemp) {
            return false;
        }
        else {
            return true;
        }
    }

    /*****************************************************************
     Returns the integer amount of properties that a player owns that is within
     the input parameter color's color group.
     @param color string of the color group that is being counted
     through the Player's owned properties list (namesOfProperties)
     @return integer amount of properties a Player owns in the input
     color group
     *****************************************************************/
    public int amountOfColor (String color) {
        int colorNum = 0;
        for(int i = 0; i < namesOfProperties.size(); i++) {
            if((namesOfProperties.get(i)).getColorSet() == color) {
                colorNum++;
            }
        }
        return colorNum;
    }
}