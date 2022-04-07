package game;

public class BoardSpace {

    /** holds the string name of each BoardSpace */
    String name;

    /** holds the description name of each BoardSpace */
    String description;

    /** holds the integer cost to buy the BoardSpace */
    int costToBuy;

    /** holds the integer cost of rent for the BoardSpace */
    int rent;

    /** holds the string color that the BoardSpace is */
    String colorSet;

    /** boolean to show if the BoardSpace is owned or not */
    boolean owned = false;

    /** holds the ownerName of the BoardSpace */
    String ownerName;

    /** create a new Player called owner */
    Player owner = new Player();

    /*****************************************************************
     Returns the name of the BoardSpace
     @return string name of the BoardSpace
     *****************************************************************/
    public String getName() {
        return name;
    }

    /*****************************************************************
     Returns the string description of the BoardSpace
     @return the string description of the BoardSpace
     *****************************************************************/
    public String getDescription() {
        return description;
    }

    /*****************************************************************
     Returns the integer cost that the BoardSpace costs to buy
     @return costToBuy which is an integer of the cost to buy that BoardSpace
     *****************************************************************/
    public int getCostToBuy() {
        return costToBuy;
    }

    /*****************************************************************
     Returns the intger rent cost of the BoardSpace
     @return rent which is the integer cost of the rent of that BoardSpace
     *****************************************************************/
    public int getRent() {
        return rent;
    }

    /*****************************************************************
     Returns the string color set that the BoardSpace is part of
     @return colorSet which is the string color that the BoardSpace
     is colored as
     *****************************************************************/
    public String getColorSet() {
        return colorSet;
    }

    /*****************************************************************
     Returns a boolean if the BoardSpace is owned
     @return owned which is the boolean that says if a BoardSpace is owned
     *****************************************************************/
    public boolean getOwned() {
        return owned;
    }

    /*****************************************************************
     Returns the string name of the owner of the BoardSpace
     @return ownerName which is the string name of the owner of the
     BoardSpace
     *****************************************************************/
    public String getOwnerName() {
        return ownerName;
    }

    /*****************************************************************
     Returns the Player from the Player class that owned the BoardSpace
     @return owner, returning the Player which is the owner
     *****************************************************************/
    public Player getOwner() {
        return owner;
    }

    /*****************************************************************
     Returns the string color set that the BoardSpace is part of
     @return colorSet which is the string color that the BoardSpace
     is colored as
     *****************************************************************/
    public void setName(String ownerName) {
        this.ownerName = ownerName;
    }

    /*****************************************************************
     Sets the description of the BoardSpace to the input parameter
     description
     @param description of the BoardSpace
     *****************************************************************/
    public void setDescription(String description) {
        this.description = description;
    }

    /*****************************************************************
     Sets the BoardSpace cost to buy the input parameter costToBuy
     @param costToBuy is the integer of the cost of the BoardSpace
     *****************************************************************/
    public void setCostToBuy(int costToBuy) {
        this.costToBuy = costToBuy;
    }

    /*****************************************************************
     Sets the rent to the input parameter integer value
     @param rent the cost of rent for the BoardSpace
     *****************************************************************/
    public void setRent(int rent) {
        this.rent = rent;
    }

    /*****************************************************************
     Sets the BoardSpace colorSet to the input parameter color
     @param colorSet string color of the BoardSpace
     *****************************************************************/
    public void setColorSet(String colorSet) {
        this.colorSet = colorSet;
    }

    /*****************************************************************
     Sets the owned boolean to the input parameter value of owned
     @param owned is the boolean value that changes the BoardSpace
     owned value
     *****************************************************************/
    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    /*****************************************************************
     Sets the ownerName of the BoardSpace to the value of the string
     input parameter value
     @param ownerName changes the ownerName of the BoardSpace to
     the input parameter ownerName value
     *****************************************************************/
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /*****************************************************************
     Sets the Player owner to the input parameter that is a Player
     @param owner who is the new Player/owner
     *****************************************************************/
    public void setOwner(Player owner) {
        this.owner = owner;
    }

}