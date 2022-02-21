package game;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

	
	public class Main {
		public void gameStart( ) {
			Random rand = new Random();
			resetAllOwnedSpaces();
			boolean gameOver = false;
			   
			Player player1 = new Player();
			Player player2 = new Player();
			Player player3 = new Player();
			Player player4 = new Player();
			
			Player[] players = new Player[4];
			
			players[0] = player1;
			players[1] = player2;
			players[2] = player3;
			players[3] = player4; 
			
			player1.name = "Player 1";
			player2.name = "Player 2";
			player3.name = "Player 3";
			player4.name = "Player 4";
			
			System.out.println("Welcome to Monopoly: Player 1!")
		}
		
		public int diceRoll() {
			// fixME add the dice roll functions!
			
		    int roll = rand.nextInt(6)+1;
		    return roll;
		}
		
		public int printRollTotal() {
			int roll1 = diceRoll();
			int roll2 = diceRoll(); 
			System.out.println("Player rolled " + roll1 + " and " + roll2;
			System.out.println("to get " + (roll1 + roll2));
			
			if (roll1 == roll2) {
				System.out.println("You rolled DOUBLES!"); // fixME do more?
				currentPlayer.addToDoubleStreak();
			}
		}
		
		
		public void playerTurn(Player currentPlayer) {
			System.out.println("\n It's " + currentPlayer.getName() + "'s turn!");
			System.out.println("Money: " + currentPlayer.getMoney());
			
			if (currentPlayer.inJail == true) {
				// fixMe fill!
				System.out.println("Player is in jail!");
			}
			else {
				// normal turn if player is NOT in jail
				System.out.println("Player position: " + currentPlayer.getPosition());
				
				while (currentPlayer.getDoubleStreak() < 3) { // fixME is that it for the while loop?
					// fixMe move!
					int move = currentPlayer.pos() + // fixME NOT DONE
				}
			}
		}
		
	  public static void main(String[] args){
	  
	   
	   //player1.name = "test p1";
	   //System.out.println(player1.name);
	     	   
	   String[] why = new String[40];
	   why[0] = "Go";
	   why[1] = "Mediterranean Avenue";
	   why[2] = "Community Chest";
	   why[3] = "Baltic Avenue";
	   why[4] = "Income Tax";
	   why[5] = "Reading Railroad";
	   why[6] = "Oriental Avenue";
	   why[7] = "Chance";
	   why[8] = "Vermont Avenue";
	   why[9] = "Conneticut Avenue";
	   why[10] = "Jail";
	   why[11] = "St. Charles Place";
	   why[12] = "Electric Company";
	   why[13] = "States Avenue";
	   why[14] = "Virginia Avenue";
	   why[15] = "Pennsylvania Railroad";
	   why[16] = "St. James Place";
	   why[17] = "Community Chest";
	   why[18] = "Tennessee Avenue";
	   why[19] = "New York Avenue";
	   why[20] = "Free Parking";
	   why[21] = "Kentucky Avenue";
	   why[22] = "Chance";
	   why[23] = "Indiana Avenue";
	   why[24] = "Illinois Avenue";
	   why[25] = "B. & O. Railroad";
	   why[26] = "Atlantic Avenue";
	   why[27] = "Ventnor Avenue";
	   why[28] = "Water Works";
	   why[29] = "Marvin Gardens";
	   why[30] = "Go To Jail";
	   why[31] = "Pacific Avenue";
	   why[32] = "North Carolina Avenue";
	   why[33] = "Community Chest";
	   why[34] = "Pennsylvania Avenue";
	   why[35] = "Short Line";
	   why[36] = "Chance";
	   why[37] = "Park Place";
	   why[38] = "Luxury Tax";
	   why[39] = "Boardwalk";
	   
	   // 0  = go
	   // 10 = jail
	   // 20 = free
	   // 30 = go to jail
	   // 39 = 1
	   // 40 = in jail
	   
	   //Boolean doubles = false;
	   int laps = 0;
	   Boolean move = true;
	   
	   while(laps < 2) {
	       System.out.println("Player Current Position: " + players[0].pos + " or " + why[players[0].pos]);
	       System.out.println();
	       
	       
	       //Dice Rolls
	       //if(doubles == true && player1.doublesCount < 3) {}
	       int dice1 = rand.nextInt(6)+1;
	       //System.out.println("Player Dice 1: " + dice1);
	       int dice2 = rand.nextInt(6)+1;
	       //System.out.println("Player Dice 2: " + dice2);
	       int roll = dice1+dice2;
	       if(dice1 == dice2) {
	           doubles = true; 
	           players[0].doubleStreak++;
	       }
	       
	       else {
	           players[0].doubleStreak = 0; 
	           doubles = false;
	       }
	       
	       if(players[0].inJail) { 
	           move = false;
	       }
	           
	       else { 
	           move = true;
	       }
	           
	       //System.out.println(dice1);
	       //System.out.println(dice2);
	       System.out.println("Roll: " + roll);
	       System.out.println("Doubles + Doubles Streak: " + doubles + " " + players[0].doubleStreak);
	       //System.out.println(doubles);
	   
	   
	       //Moving around the board
	   
	      //If current player is in jail, wait for doubles
	       if(players[0].inJail) {
	           if(doubles == true) {
	               players[0].inJail = false;
	               move = true;
	           }
	       }
	   
	       //If current player has rolled too many doubles
	       if(players[0].doubleStreak >= 3) {
	           players[0].doubleStreak = 0; 
	           players[0].pos = 10; 
	           move = false; 
	           players[0].inJail = true; 
	           System.out.println("Sped to jail");
	       }
	   
	       //Movement option 1, not crossing go
	       else if(players[0].pos+roll > 39 && move == true) {
	           players[0].pos = (players[0].pos+roll)%40; 
	           laps++;
	           move = false;
	       }
	   
	       //Movement option 2, crossing go
	       else if(move == true) {
	           players[0].pos = (players[0].pos+roll)%40;
	           move = false;
	       }
	   
	       //Landing on 'Go to jail', send to jail
	       if(players[0].pos == 30) {
	           System.out.println("Sent to jail");
	           players[0].pos = 10;
	           players[0].inJail = true;
	       }
	       
	       //everything else goes here
	       //buying and selling 
	   }
	   System.out.println("Final Position " + players[0].pos + " or " + why[players[0].pos]);
	   
	   
	   
	   }
	}
	