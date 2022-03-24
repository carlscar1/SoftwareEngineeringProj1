package game;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

	
	public class Main {

		/** create a new random generator rand */
		static Random rand = new Random();

		/** create a new Board called gameBoard */
		static Board gameBoard = new Board();
		
		/*****************************************************************
		Returns the boolean if a Player has won the game. Checks the 
		number of bankrupt players using isBankrupt() and if all but one
		PLayer is bankrupt, the only Player not bankrupt wins. 
		@param players is the array list of the players in the game
		@return boolean of if any Player has won the game
    	*****************************************************************/
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
		
		/*****************************************************************
		Starts the game with a welcome message. 
    	*****************************************************************/
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
		}
		
		/*****************************************************************
		Returns a random number 1-6, used as a dice roll. 
		@return the roll number 1-6
    	*****************************************************************/
		public static int diceRoll() {
		    int roll = rand.nextInt(6)+1;
		    return roll;
		}
		
		/*****************************************************************
		Rolls two dice using diceRoll(), prints each diceRoll as an 
		integer. Then, adds the rolls together as the total movement. 
		If the rolls are equal, then the Player had rolled doubles, so add
		to the doubles streak using addToDoublesStreak(). If not equal rolls,
		reset the doubles streak.
		@param currentPlayer is a Player type that is rolling the dice
		@return integer movement of the dice rolls added together
    	*****************************************************************/
		public static int printRollTotal(Player currentPlayer) {
			int roll1 = diceRoll();
			int roll2 = diceRoll(); 
			int movement = roll1+roll2;
			System.out.println("Player rolled " + roll1 + " and " + roll2);
			System.out.println("to get " + (movement));
			
			if (roll1 == roll2) {
				System.out.println("You rolled DOUBLES!");
				currentPlayer.addToDoubleStreak();
			}
			else {
				currentPlayer.resetDoubleStreak();
			}
			return movement;
		}
		
		/*****************************************************************
		Each player turn will go through these options and print out
		various print statements. First, the Player's name is printed saying
		it's their turn, along with their amount of money.
		Then, it checks if the currentPlayer is in jail, if true
		then checks if doubles, if rolled doubles then out of jail.
		Then if in jail and did not roll doubles, then add to jail
		counter, if jail counter is 3, then charged $50. 
		If not in jail, print out position, checks if player rolls doubles,
		and then checks if player crosses go (collects $200 if so).
		Next, checks if the doubleStreak is greater than 2, and if so,
		the Player is put in jail. If the Player can buy the space,
		they buy it. This is the end of the move. 
		@param currentPlayer is the Player who's turn it is
    	*****************************************************************/
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
					currentPlayer.pos = (currentPlayer.pos + rolled) % 40; // %40 to make sure within range of board
					
					if(currentPlayer.getDoubleStreak() > 2) {
						System.out.println("Player sped to jail!");
						currentPlayer.inJail = true;
						currentPlayer.isMoving = false;
						currentPlayer.pos = 10;
					}
					else if (gameBoard.canBuyThisSquare(currentPlayer.getPosition())) {
						System.out.println(currentPlayer.getPosition());
						//currentPlayer.buySpace(gameBoard.getSpaceFromInt(currentPlayer.getPosition()), currentPlayer);
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
		  Player player1 = new Player();
		  Player player2 = new Player();
		  Player player3 = new Player();
		  Player player4 = new Player();

		  Player[] players = new Player[4];
		  int turnCount = 0;
			
			players[0] = player1;
			players[1] = player2;
			players[2] = player3;
			players[3] = player4; 
			
			player1.name = "Player 1";
			player2.name = "Player 2";
			player3.name = "Player 3";
			player4.name = "Player 4";
			while(!checkWin(players) && turnCount <= 5) {
				for(int i = 0; i < players.length; i++) {
					if(!players[i].isBankrupt()) {
						playerTurn(players[i]);
					}
				turnCount++;
				}
			}
			System.out.println("");
			System.out.println("===========================");
			System.out.println("End of Game!");
			System.out.println("===========================");
	   }
	}
	