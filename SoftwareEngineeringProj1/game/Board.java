package game;

public class Board {

    /**
     * Create an array of BoardSpaces called spaces with 40 BoardSpaces
     */
    static BoardSpace[] spaces = new BoardSpace[40];

    /*****************************************************************
     Initializes the board inside an array of BoardSpaces. First, creates
     each space as a new BoardSpace within a loop. Then for each space,
     set the name, description costToBuy, rent, colorSet, and owned.
     Set the ownerName to "Bank" if the space cannot be bought.
     *****************************************************************/
     public void initBoard() {
        for (int i = 0; i < 40; i++) {
            spaces[i] = new BoardSpace();
        }

        spaces[0].name = "Go";
        spaces[0].setOwned(true); 
        //Setting it to true so that nobody purchases it
        spaces[0].ownerName = "BANK"; 
        //Setting owner to BANK so that if it is ever requested,
        //it has a response

        spaces[1].name = "Mediterranean Avenue";
        spaces[1].description = "";
        spaces[1].costToBuy = 60;
        spaces[1].rent = 2;
        spaces[1].colorSet = "purple";
        spaces[1].setOwned(false);

        spaces[2].name = "Community Chest";
        spaces[2].description = "";
        spaces[2].setOwned(true);
        spaces[2].ownerName = "BANK";

        spaces[3].name = "Baltic Avenue";
        spaces[3].description = "";
        spaces[3].costToBuy = 60;
        spaces[3].rent = 4;
        spaces[3].colorSet = "purple";
        spaces[3].setOwned(false);

        spaces[4].name = "Income Tax";
        spaces[4].description = "";
        spaces[4].setOwned(true);
        spaces[4].ownerName = "BANK";

        spaces[5].name = "Reading Railroad";
        spaces[5].description = "";
        spaces[5].costToBuy = 200;
        spaces[5].setOwned(false);
        spaces[5].colorSet = "railroad";

        spaces[6].name = "Oriental Avenue";
        spaces[6].description = "";
        spaces[6].costToBuy = 100;
        spaces[6].rent = 6;
        spaces[6].colorSet = "cyan";
        spaces[6].setOwned(false);

        spaces[7].name = "Chance";
        spaces[7].description = "";
        spaces[7].setOwned(true);
        spaces[7].ownerName = "BANK";

        spaces[8].name = "Vermont Avenue";
        spaces[8].description = "";
        spaces[8].costToBuy = 100;
        spaces[8].rent = 6;
        spaces[8].colorSet = "cyan";
        spaces[8].setOwned(false);

        spaces[9].name = "Connecticut Avenue";
        spaces[9].description = "";
        spaces[9].costToBuy = 120;
        spaces[9].rent = 8;
        spaces[9].colorSet = "cyan";
        spaces[9].setOwned(false);

        spaces[10].name = "Jail";
        spaces[10].description = "";
        spaces[10].setOwned(true);
        spaces[10].ownerName = "BANK";

        spaces[11].name = "St. Charles Place";
        spaces[11].description = "";
        spaces[11].costToBuy = 140;
        spaces[11].rent = 10;
        spaces[11].colorSet = "magenta";
        spaces[11].setOwned(false);

        spaces[12].name = "Electric Company";
        spaces[12].description = "";
        spaces[12].costToBuy = 150;
        spaces[12].setOwned(false);
        spaces[12].colorSet = "utilities";

        spaces[13].name = "States Avenue";
        spaces[13].description = "";
        spaces[13].costToBuy = 140;
        spaces[13].rent = 10;
        spaces[13].colorSet = "magenta";
        spaces[13].setOwned(false);

        spaces[14].name = "Virginia Avenue";
        spaces[14].description = "";
        spaces[14].costToBuy = 160;
        spaces[14].rent = 12;
        spaces[14].colorSet = "magenta";
        spaces[14].setOwned(false);

        spaces[15].name = "Pennsylvania Railroad";
        spaces[15].description = "";
        spaces[15].costToBuy = 200;
        spaces[15].setOwned(false);
        spaces[15].colorSet = "railroad";

        spaces[16].name = "St. James Place";
        spaces[16].description = "";
        spaces[16].costToBuy = 180;
        spaces[16].rent = 14;
        spaces[16].colorSet = "orange";
        spaces[16].setOwned(false);

        spaces[17].name = "Community Chest";
        spaces[17].description = "";
        spaces[17].setOwned(true);
        spaces[17].ownerName = "BANK";

        spaces[18].name = "Tennessee Avenue";
        spaces[18].description = "";
        spaces[18].costToBuy = 180;
        spaces[18].rent = 14;
        spaces[18].colorSet = "orange";
        spaces[18].setOwned(false);

        spaces[19].name = "New York Avenue";
        spaces[19].description = "";
        spaces[19].costToBuy = 200;
        spaces[19].rent = 16;
        spaces[19].colorSet = "orange";
        spaces[19].setOwned(false);

        spaces[20].name = "Free Parking";
        spaces[20].description = "";
        spaces[20].costToBuy = 200;
        spaces[20].setOwned(true);
        spaces[20].ownerName = "BANK";

        spaces[21].name = "Kentucky Avenue";
        spaces[21].description = "";
        spaces[21].costToBuy = 220;
        spaces[21].rent = 18;
        spaces[21].colorSet = "red";
        spaces[21].setOwned(false);

        spaces[22].name = "Chance";
        spaces[22].description = "";
        spaces[22].setOwned(true);
        spaces[22].ownerName = "BANK";

        spaces[23].name = "Indiana Avenue";
        spaces[23].description = "";
        spaces[23].costToBuy = 220;
        spaces[23].rent = 18;
        spaces[23].colorSet = "red";
        spaces[23].setOwned(false);

        spaces[24].name = "Illinois Avenue";
        spaces[24].description = "";
        spaces[24].costToBuy = 240;
        spaces[24].rent = 20;
        spaces[24].colorSet = "red";
        spaces[24].setOwned(false);

        spaces[25].name = "B. & O. Railroad";
        spaces[25].description = "";
        spaces[25].costToBuy = 200;
        spaces[25].setOwned(false);
        spaces[25].colorSet = "railroad";

        spaces[26].name = "Atlantic Avenue";
        spaces[26].description = "";
        spaces[26].costToBuy = 260;
        spaces[26].rent = 22;
        spaces[26].colorSet = "yellow";
        spaces[26].setOwned(false);

        spaces[27].name = "Ventnor Avenue";
        spaces[27].description = "";
        spaces[27].costToBuy = 260;
        spaces[27].rent = 22;
        spaces[27].colorSet = "yellow";
        spaces[27].setOwned(false);

        spaces[28].name = "Water Works";
        spaces[28].description = "";
        spaces[28].costToBuy = 150;
        spaces[28].setOwned(false);
        spaces[28].colorSet = "utilities";

        spaces[29].name = "Marvin Gardens";
        spaces[29].description = "";
        spaces[29].costToBuy = 280;
        spaces[29].rent = 24;
        spaces[29].colorSet = "yellow";
        spaces[29].setOwned(false);

        spaces[30].name = "Go To Jail";
        spaces[30].description = "";
        spaces[30].setOwned(true);
        spaces[30].ownerName = "BANK";

        spaces[31].name = "Pacific Avenue";
        spaces[31].description = "";
        spaces[31].costToBuy = 300;
        spaces[31].rent = 26;
        spaces[31].colorSet = "green";
        spaces[31].setOwned(false);

        spaces[32].name = "North Carolina Avenue";
        spaces[32].description = "";
        spaces[32].costToBuy = 300;
        spaces[32].rent = 26;
        spaces[32].colorSet = "green";
        spaces[32].setOwned(false);

        spaces[33].name = "Community Chest";
        spaces[33].description = "";
        spaces[33].setOwned(true);
        spaces[33].ownerName = "BANK";

        spaces[34].name = "Pennsylvania Avenue";
        spaces[34].description = "";
        spaces[34].costToBuy = 320;
        spaces[34].rent = 28;
        spaces[34].colorSet = "green";
        spaces[34].setOwned(false);

        spaces[35].name = "Short Line";
        spaces[35].description = "";
        spaces[35].costToBuy = 200;
        spaces[35].setOwned(false);
        spaces[35].colorSet = "railroad";

        spaces[36].name = "Chance";
        spaces[36].description = "";
        spaces[36].setOwned(true);
        spaces[36].ownerName = "BANK";

        spaces[37].name = "Park Place";
        spaces[37].description = "";
        spaces[37].costToBuy = 350;
        spaces[37].rent = 35;
        spaces[37].colorSet = "blue";
        spaces[37].setOwned(false);

        spaces[38].name = "Luxury Tax";
        spaces[38].description = "";
        spaces[38].setOwned(true);
        spaces[38].ownerName = "BANK";

        spaces[39].name = "Boardwalk";
        spaces[39].description = "";
        spaces[39].costToBuy = 400;
        spaces[39].rent = 50;
        spaces[39].colorSet = "blue";
        spaces[39].setOwned(false);
    }

    /*****************************************************************
     Returns the array list of spaces that contain information on
     each BoardSpace
     @return spaces which is the array list of the BoardSpaces
     *****************************************************************/
    public BoardSpace[] getBoard() {
        return spaces;
    }

    /*****************************************************************
     Returns the name of the space at the position that is input as
     the input parameter.
     @param numSpace the integer number of the space on the board
     @return the name of the space based on the input numSpace
     *****************************************************************/
    public String getNameOfSpace(int numSpace) {
        return spaces[numSpace].name;
    }

    /*****************************************************************
     Resets all BoardSpaces through the spaces array list back to
     not being owned anymore. This is done by setting owned to false
     for all BoardSpaces on the board, as well as setting ownerName to
     "BANK."
     *****************************************************************/
    public void resetAllOwnedSpaces() {
        for (int i = 0; i < 40; i++) {
            spaces[i].setOwned(false);
            spaces[i].ownerName = "BANK";
        }
    }

    /*****************************************************************
     Pays rent from currentPlayer (input parameter) to the player
     that owns the spots that the currentPlayer is on (their position).
     @param currentPlayer is the player that is playing their turn that
     must pay rent on the space they are on.
     @return cost of the rent that the Player pays
     *****************************************************************/
    public int payRent(Player currentPlayer) {
        int cost = getBoard()[currentPlayer.getPosition()].getRent();
        currentPlayer.payToPlayer(getBoard()[currentPlayer.getPosition()].getOwner(), cost);
        return cost;
    }

    /*****************************************************************
     Returns the boolean of whether or not the space of the input
     parameter integer can be bought or if it is already owned (would
     return false).
     @param spaceNum is the integer of the position of the space on the
     board that needs to be checked if it can be bought.
     @return boolean of if the space can be bought (true if can be
     bought)
     *****************************************************************/
    public boolean canBuyThisSquare(int spaceNum) {
        try {
            return getSpaceFromInt(spaceNum).getOwned();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
        return false;
    }

    /*****************************************************************
     Returns the BoardSpace at the location of the integer input
     parameter.
     @param spaceNum the integer number that the space is at on the board
     @return the BoardSpace from the array list at the location of
     the input integer spaceNum
     *****************************************************************/
    public BoardSpace getSpaceFromInt(int spaceNum) {
        return spaces[spaceNum];
    }
}