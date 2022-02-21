package game;

public class Board {

	
	//BUYING AND SELLING rent and cost to buy 
	public static void main(String[] args){
	
		BoardSpace[] spaces = new BoardSpace[40];
	
	//fixME set ALL boolean owned to false at beginning of game
	//and all ownername to null
	spaces[0].name = "Go";
	spaces[0].description = ""; //fixME--add ALL descriptions
	//spaces[0].costToBuy = NULL; // cannot buy
	
	spaces[1].name = "Mediterranean Avenue";
	spaces[1].description = "";
	spaces[1].costToBuy = 60;
	spaces[1].rent = 2;
	spaces[1].colorSet = "purple";
	
	
	spaces[2].name = "Community Chest";
	spaces[2].description = "";
	
	
	spaces[3].name = "Baltic Avenue";
	spaces[3].description = "";
	spaces[3].costToBuy = 60;
	spaces[3].rent = 4;
	spaces[3].colorSet = "purple";
	
	spaces[4].name = "Income Tax";
	spaces[4].description = "";
	
	spaces[5].name = "Reading Railroad";
	spaces[5].description = "";
	
	spaces[6].name = "Oriental Avenue";
	spaces[6].description = "";
	spaces[6].costToBuy = 100;
	spaces[6].rent = 6;
	spaces[6].colorSet = "cyan";
	
	spaces[7].name = "Chance";
	spaces[7].description = "";
	
	spaces[8].name = "Vermont Avenue";
	spaces[8].description = "";
	spaces[8].costToBuy = 100;
	spaces[8].rent = 6;
	spaces[8].colorSet = "cyan";
	
	spaces[9].name = "Conneticut Avenue";
	spaces[9].description = "";
	spaces[9].costToBuy = 120;
	spaces[9].rent = 8;
	spaces[9].colorSet = "cyan";
	
	spaces[10].name = "Jail";
	spaces[10].description = "";
	
	spaces[11].name = "St. Charles Place";
	spaces[11].description = "";
	spaces[11].costToBuy = 140;
	spaces[11].rent = 10;
	spaces[11].colorSet = "magenta";
	
	spaces[12].name = "Electric Company";
	spaces[12].description = "";
	
	spaces[13].name = "States Avenue";
	spaces[13].description = "";
	spaces[13].costToBuy = 140;
	spaces[13].rent = 10;
	spaces[13].colorSet = "magenta";
	
	spaces[14].name = "Virginia Avenue";
	spaces[14].description = "";
	spaces[14].costToBuy = 160;
	spaces[14].rent = 12;
	spaces[14].colorSet = "magenta";
	
	spaces[15].name = "Pennsylvania Railroad";
	spaces[15].description = "";
	
	spaces[16].name = "St. James Place";
	spaces[11].description = "";
	spaces[11].costToBuy = 180;
	spaces[11].rent = 14;
	spaces[11].colorSet = "orange";
	
	spaces[17].name = "Community Chest";
	spaces[17].description = "";
	
	spaces[18].name = "Tennessee Avenue";
	spaces[18].description = "";
	spaces[18].costToBuy = 180;
	spaces[18].rent = 14;
	spaces[18].colorSet = "orange";
	
	spaces[19].name = "New York Avenue";
	spaces[18].description = "";
	spaces[18].costToBuy = 200;
	spaces[18].rent = 16;
	spaces[18].colorSet = "orange";
	
	spaces[20].name = "Free Parking";
	spaces[20].description = "";
	
	spaces[21].name = "Kentucky Avenue";
	spaces[21].description = "";
	spaces[21].costToBuy = 220;
	spaces[21].rent = 18;
	spaces[21].colorSet = "red";
	
	spaces[22].name = "Chance";
	spaces[22].description = "";
	
	spaces[23].name = "Indiana Avenue";
	spaces[23].description = "";
	spaces[23].costToBuy = 220;
	spaces[23].rent = 18;
	spaces[23].colorSet = "red";
	
	spaces[24].name = "Illinois Avenue";
	spaces[24].description = "";
	spaces[24].costToBuy = 240;
	spaces[24].rent = 20;
	spaces[24].colorSet = "red";
	
	spaces[25].name = "B. & O. Railroad";
	spaces[25].description = "";
	
	spaces[26].name = "Atlantic Avenue";
	spaces[26].description = "";
	spaces[26].costToBuy = 260;
	spaces[26].rent = 22;
	spaces[26].colorSet = "yellow";
	
	spaces[27].name = "Ventnor Avenue";
	spaces[27].description = "";
	spaces[27].costToBuy = 260;
	spaces[27].rent = 22;
	spaces[27].colorSet = "yellow";
	
	spaces[28].name = "Water Works";
	spaces[28].description = "";
	
	spaces[29].name = "Marvin Gardens";
	spaces[29].description = "";
	spaces[29].costToBuy = 280;
	spaces[29].rent = 24;
	spaces[29].colorSet = "yellow";
	
	spaces[30].name = "Go To Jail";
	spaces[30].description = "";
	
	spaces[31].name = "Pacific Avenue";
	spaces[31].description = "";
	spaces[31].costToBuy = 300;
	spaces[31].rent = 26;
	spaces[31].colorSet = "green";
	
	spaces[32].name = "North Carolina Avenue";
	spaces[32].description = "";
	spaces[32].costToBuy = 300;
	spaces[32].rent = 26;
	spaces[32].colorSet = "green";
	
	spaces[33].name = "Community Chest";
	spaces[33].description = "";
	
	spaces[34].name = "Pennsylvania Avenue";
	spaces[34].description = "";
	spaces[34].costToBuy = 320;
	spaces[34].rent = 28;
	spaces[34].colorSet = "green";
	
	spaces[35].name = "Short Line";
	spaces[35].description = "";
	
	spaces[36].name = "Chance";
	spaces[36].description = "";
	
	spaces[37].name = "Park Place";
	spaces[37].description = "";
	spaces[37].costToBuy = 350;
	spaces[37].rent = 35;
	spaces[37].colorSet = "blue";
	
	spaces[38].name = "Luxury Tax";
	spaces[38].description = "";
	
	spaces[39].name = "Boardwalk";
	spaces[39].description = "";
	spaces[39].costToBuy = 400;
	spaces[39].rent = 50;
	spaces[39].colorSet = "blue";
	
	
	}
	
	public void resetAllOwnedSpaces() {
		for(int i=0; i < 40; i++) {
			spaces[i].owned = false;
			spaces[i].ownerName = "NONE";
		}
	}
	
	//fixME
//	public boolean canBuyThisSquare() {
//		if (spaces[squareNum].owned == false) {
//			return true;
//		}
//	}
	
	public boolean checkWin() {
		//
	}
	
	public void rollDice() {
		
	}
	
	
	
	}
