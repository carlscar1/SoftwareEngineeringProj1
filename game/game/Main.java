package game;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

	
	public class Main {
		static Random rand = new Random();
		static Board gameBoard = new Board();
		public static boolean checkWin(Player[] players) {
			int totalPlayers = players.length;
			int winCon = totalPlayers-1;
			int bankruptPlayers = 0;
			for(int i = 0; i < totalPlayers; i++) {
				if(players[i].isBankrupt()) {
					bankruptPlayers++;
				}
			}
			if(winCon == bankruptPlayers) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public static void gameStart() {
			//Board gameBoard = new Board();
			//gameBoard.resetAllOwnedSpaces();
			
			// Player player1 = new Player();
			// Player player2 = new Player();
			// Player player3 = new Player();
			// Player player4 = new Player();
			
			// Player[] players = new Player[4];
			
			// players[0] = player1;
			// players[1] = player2;
			// players[2] = player3;
			// players[3] = player4; 
			
			// player1.name = "Player 1";
			// player2.name = "Player 2";
			// player3.name = "Player 3";
			// player4.name = "Player 4";
			
			System.out.println("Welcome to Monopoly: Player 1!");
			gameBoard.initBoard();
		}
		
		public static int diceRoll() {
		    int roll = rand.nextInt(6)+1;
		    return roll;
		}
		
		public static int printRollTotal(Player currentPlayer) {
			int roll1 = diceRoll();
			int roll2 = diceRoll(); 
			int movement = roll1+roll2;
			System.out.println("Player rolled " + roll1 + " and " + roll2 + " to get " + (movement));
			if (roll1 == roll2) {
				System.out.println("You rolled DOUBLES!");
				currentPlayer.addToDoubleStreak();
			}
			else {
				currentPlayer.resetDoubleStreak();
			}
			return movement;
		}
		
		public static void playerTurn(Player currentPlayer) {
			System.out.println("\n----It's " + currentPlayer.getName() + "'s turn!----");
			System.out.println("Money: " + currentPlayer.getMoney());
			int rolled;
			if (currentPlayer.inJail == true) {
				if(currentPlayer.doubleStreak > 0) {
					currentPlayer.isMoving = true;
					System.out.println("Player rolled doubles!");
					currentPlayer.resetJailCounter();
					currentPlayer.inJail = false;
				}
				else {
					System.out.println("Player did not roll doubles!");
					currentPlayer.addToJailCounter();
					if(currentPlayer.getJailCounter() == 3) {
						System.out.println("Player did not roll doubles in time, charged �50.");
						currentPlayer.setMoney(currentPlayer.getMoney()-50);
						currentPlayer.isMoving = true;
						currentPlayer.inJail = false;
						currentPlayer.resetJailCounter();
					}
				}
				System.out.println("Player is in jail!");
				
			}
			else {
				while (/*currentPlayer.getDoubleStreak() < 3 && currentPlayer.getDoubleStreak() > 0*/ currentPlayer.isMoving == true) {
					System.out.println("Player position: " + currentPlayer.getPosition());
					rolled = printRollTotal(currentPlayer);
					if(currentPlayer.doubleStreak > 0) {
						currentPlayer.isMoving = true;
					}
					else {
						currentPlayer.isMoving = false;
					}
					if(currentPlayer.pos + rolled > 40) {
						System.out.println("Player crosses go! Collects $200!");
						currentPlayer.money += 200;					
					}
					currentPlayer.pos = (currentPlayer.pos + rolled)%40;
					if(currentPlayer.getDoubleStreak() > 2) {
						System.out.println("Player sped to jail!");
						currentPlayer.inJail = true;
						currentPlayer.isMoving = false;
						currentPlayer.pos = 10;
					}
					else if (!gameBoard.canBuyThisSquare(currentPlayer.getPosition())) {
						//System.out.println(currentPlayer.getPosition());
						currentPlayer.buySpace(gameBoard.getSpaceFromInt(currentPlayer.getPosition()), currentPlayer);
						currentPlayer.printProperties(currentPlayer.getProperties());
					}
					else {
						System.out.println("End of players move!");
						currentPlayer.isMoving = false;
					}
				}
			}
			if(currentPlayer.inJail == false) {
				currentPlayer.isMoving = true;
			}
		}
		
	  public static void main(String[] args){  
		  gameStart();
		  //int laps = 0;
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
			while(!checkWin(players)) {
			//while(laps < 2) {
				for(int i = 0; i < players.length; i++) {
					if(!players[i].isBankrupt())
						playerTurn(players[i]);
				}
				//laps++;
			}
	   }
	}
	