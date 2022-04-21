package game;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Main {

    /** create a new random generator rand */
    static Random rand = new Random();

    /** create a new Board called gameBoard */
    static Board gameBoard = new Board();
    
    static JTextArea area = new JTextArea();

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
     public static Player outputWinner(Player[] players) {
    	 int maxMoney = 0;
    	 Player currentWinner = new Player();
    	 for(int i = 0; i < players.length; i++) {
             if(players[i].getMoney() > maxMoney) {
                 maxMoney = players[i].getMoney();
                 currentWinner = players[i];
             }
         }
    	 return currentWinner;
     }

    /*****************************************************************
     Starts the game with a welcome message.
     *****************************************************************/
    public static void gameStart() {
        gameBoard.initBoard();
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
        System.out.println("Player rolled " + roll1 + " and " + roll2 + " to get " + (movement));

        if (roll1 == roll2) {
        	System.out.println();
            System.out.println("You rolled DOUBLES!");
            System.out.println();
            currentPlayer.addToDoubleStreak();
        }
        else {
            currentPlayer.resetDoubleStreak();
        }
        return movement;
    }
    
    /*****************************************************************
     Uses a random number to choose a chance card for the currentPlayer
     that determines the amount of money they gain/lose or if they
     gain spaces or a get out of jail free card. Changes their money
     as well as changes their position based on the card picked up.
     Prints out the text for each card.
     @param currentPlayer is a Player type that is rolling the dice
     *****************************************************************/
    public static void chanceCard(Player currentPlayer) {
    	Random rad = new Random();
        int Chance = rad.nextInt(10);
        String Chance_Text;
        int moneyChange = 0;
        int newPosition = 0;
        switch (Chance) {
            case 0:
                Chance_Text = "Gain 1 Get Out of Jail Free Card!";
                break;
            case 1:
                Chance_Text = "GO TO JAIL! GO DIRECTLY TO JAIL! DO NOT PASS GO! DO NOT COLLECT 200!";
                break;
            case 2:
                Chance_Text = "Advance to Illinois Avenue. If you pass Go, collect $200";
                if (currentPlayer.pos > 24) {
                    moneyChange = 200;
                    newPosition = 24;
                } else {
                    newPosition = 24;
                }
                break;
            case 3:
                Chance_Text = "Advance to St. Charles Place. If you pass Go, collect $200";
                if (currentPlayer.pos > 11) {
                    moneyChange = 200;
                    newPosition = 11;
                }
                else {
                    newPosition = 11;
                }
                break;
            case 4:
                Chance_Text = "Go Back 3 Spaces";
                if(currentPlayer.pos > 2) {
                    newPosition = currentPlayer.pos - 3;
                }
                else{
                    newPosition = 40;
                }
                break;
            case 5:
                Chance_Text = "Advance to Go Collect $200";
                moneyChange = 200;
                newPosition = 0;
                break;
            case 6:
                Chance_Text = "Take a trip to Reading Railroad. If you pass Go, collect $200";
                if (currentPlayer.pos > 5) {
                    moneyChange = 200;
                    newPosition = 5;
                } else {
                    newPosition = 5;
                }

                break;
            case 7:
                Chance_Text = "Make general repairs on all your property. Pay $175";
                moneyChange = -175;
                break;
            case 8:
                Chance_Text = "You have lost in a beauty contest. Lose $300";
                moneyChange = -300;
                break;
            case 9:
                Chance_Text = "Your building loan matures. Collect $150";
                moneyChange = 150;
                break;
            default:
                Chance_Text = "Advance to Go Collect $200";
                moneyChange = 200;
                newPosition = 0;
                break;

        }
        System.out.println(Chance_Text);
        currentPlayer.changeMoney(moneyChange);
        currentPlayer.setPosition(newPosition);
    }
    
    /*****************************************************************
     Uses a random number generator to choose a card for the 
     currentPlayer that determines the the amount of money they gain
     or lose or if they gain spaces or a get out of jail free card. 
     Changes their money as well as changes their position based on 
     the card picked up. Prints out the card message.
     @param currentPlayer is a Player type that is rolling the dice
     *****************************************************************/
    public static void communityChest(Player currentPlayer) {

        Random rad = new Random();
        int CC = rad.nextInt(10);
        int moneyChange = 0;
        int freeJail = 0;
        int newPosition = 0;
        String CC_Text;
        switch (CC) {
            case 0:
                CC_Text = "Gain 1 Get Out of Jail Free Card!";
                freeJail = 1;
                break;
            case 1:
                CC_Text = "GO TO JAIL! GO DIRECTLY TO JAIL! DO NOT PASS GO! DO NOT COLLECT 200!";
                newPosition = 10;
                break;
            case 2:
                CC_Text = "Bank error in your favor. Collect $200";
                moneyChange = 200;
                break;
            case 3:
                CC_Text = "Doctor's fee. Pay $50";
                moneyChange = -50;

                break;
            case 4:
                CC_Text = "From sale of stock you get $50";
                moneyChange = 50;
                break;
            case 5:
                CC_Text = "Advance to Go Collect $200";
                moneyChange = 200;
                break;
            case 6:
                CC_Text = "Pay hospital fees of $100";
                moneyChange = -100;
                break;
            case 7:
                CC_Text = "Pay school fees of $50";
                moneyChange = 50;
                break;
            case 8:
                CC_Text = "You have won second prize in a beauty contest. Collect $10";
                moneyChange = 10;
                break;
            case 9:
                CC_Text = "Make general repairs on all your property. Pay $375";
                moneyChange = -375;
                break;
            default:
                CC_Text = "Advance to Go Collect $200";
                moneyChange = 200;
                break;

        }
        System.out.println(CC_Text);
        currentPlayer.changeMoney(moneyChange);
        currentPlayer.setPosition(newPosition);
        currentPlayer.changeJailFree(freeJail);
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
        rolled = printRollTotal(currentPlayer);
    	area.selectAll();
    	area.replaceSelection("");
    	area.append("Current Player Statistics: \n");
    	area.append("Name: " + currentPlayer.getName() + "\n");
    	area.append("Position: " + gameBoard.getNameOfSpace((currentPlayer.getPosition()+rolled)%40) + "\n");
    	area.append("Money: " + currentPlayer.getMoney() + "\n");

        if (currentPlayer.inJail == true) {
            if(currentPlayer.outOfJailFree > 0){
                currentPlayer.inJail = false;
                currentPlayer.outOfJailFree -= 1;
            }
            else if(currentPlayer.doubleStreak > 0) {
                currentPlayer.isMoving = true;
                System.out.println("Player rolled doubles!");
                currentPlayer.resetJailCounter();
                currentPlayer.inJail = false;
            }
            else {
                System.out.println("Player did not roll doubles!");
                currentPlayer.addToJailCounter();
                if(currentPlayer.getJailCounter() == 3) {
                    System.out.println("Player did not roll doubles in time, charged $50.");
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
                if(currentPlayer.doubleStreak > 0) {
                    currentPlayer.isMoving = true;
                    //System.out.println("Hit A");
                }
                
                else {
                    currentPlayer.isMoving = false;
                    //System.out.println("Hit B");
                }
                
                if(currentPlayer.pos + rolled > 40) {
                	//System.out.println("Hit C");
                    System.out.println("Player crosses go! Collects $200!");
                    currentPlayer.money += 200;
                }
                
                currentPlayer.pos = (currentPlayer.pos + rolled) % 40; // %40 to make sure within range of board
                    if(currentPlayer.pos == 2 || currentPlayer.pos == 17 || currentPlayer.pos == 33) {
                    	//System.out.println("Hit D");
                    		communityChest(currentPlayer);
                    }

                    if(currentPlayer.pos == 7 || currentPlayer.pos == 22 || currentPlayer.pos == 36){
                    	//System.out.println("Hit E");
                            chanceCard(currentPlayer);
                        }

                if(currentPlayer.getDoubleStreak() > 2) {
                	//System.out.println("Hit F");
                    System.out.println("Player sped to jail!");
                    currentPlayer.inJail = true;
                    currentPlayer.isMoving = false;
                    currentPlayer.pos = 10;
                }
                
                //Player hit Income Tax
                else if (currentPlayer.getPosition() == 4) {
                	int tempChoice = 0;
                	if(currentPlayer.getIsPlayer())
                		tempChoice = Integer.parseInt(JOptionPane.showInputDialog(null,"Player landed on Income Tax! Would you like to pay $200 or 10%? Say '200' for $200 or '10' for 10%. You currently have $" + currentPlayer.getMoney()));
                	int tempLoop = 1;
                	while(tempLoop == 1) {
                		if(tempChoice == 200) {
                			currentPlayer.changeMoney(-200);
                			tempLoop = 0;
                		}
                		
                		else if (tempChoice == 10) {
                			currentPlayer.changeMoney(-(currentPlayer.getMoney()/10));
                			tempLoop = 0;
                		}
                		System.out.println("Player charged accordingly!");
                	}
                }
                
                //Player hit Luxury Tax
                else if (currentPlayer.getPosition() == 38) {
                	System.out.println("Player landed on Luxury Tax! Player charged $100");
                	currentPlayer.changeMoney(-75);
                }
                	
                else if (gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwned() == false) {
                    //System.out.println(currentPlayer.getPosition());
                    currentPlayer.buySpace(gameBoard.getSpaceFromInt(currentPlayer.getPosition()), currentPlayer);
                }
                
                else if (gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwnerName() != "BANK" || gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwnerName() != gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwnerName()){
                	System.out.println("Player landed on another player's square!");
                	 //Player hit Railroad
                    if (currentPlayer.getPosition() == 5 || currentPlayer.getPosition() == 15 || currentPlayer.getPosition() == 25 || currentPlayer.getPosition() == 35) {
                    	int tempCost = 0;
                    	int railroadNum = gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwner().amountOfColor("railroad");
                    	if(railroadNum == 1) {
                    		tempCost = 25;
                    	}
                    	else if (railroadNum == 2)  {
                    		tempCost = 50;
                    	}
                    	else if (railroadNum == 3) {
                    		tempCost = 100;
                    	}
                    	else if (railroadNum == 4) {
                    		tempCost = 200;
                    	}
                    	currentPlayer.payToPlayer(gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwner(), tempCost);
                    }
                    
                    //Player hit Electric Company
                    else if (currentPlayer.getPosition() == 12 || currentPlayer.getPosition() == 28) {
                    	int tempCost = 0;
                    	int utilityNum = gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwner().amountOfColor("utilities");
                    	if(utilityNum == 1) {
                    		tempCost = rolled*4;
                    	}
                    	if(utilityNum == 2) {
                    		tempCost = rolled*10;
                    	}
                    	currentPlayer.payToPlayer(gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwner(), tempCost);
                    }
                    
                    else
                    	currentPlayer.payToPlayer(gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getOwner(), gameBoard.getSpaceFromInt(currentPlayer.getPosition()).getRent());
                }
                
                    System.out.println("End of players move!");
                    currentPlayer.isMoving = false;
            }
        }
        if(currentPlayer.inJail == false) {
            currentPlayer.isMoving = true;
        }
    }

    public static void main(String[] args) throws IOException{
    	runGui();
    	//final JOptionPane outPut= new JOptionPane();
    	//JOptionPane.showOptionDialog("The only way to close this dialog is by pressing one of the following buttons. Do you understand?", "No", "Yes", );
    	//int testing = Integer.parseInt(JOptionPane.showInputDialog(null, "What is going on?"));
    	//System.out.println(testing+3);
        gameStart();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        Player[] players = new Player[4];
        int turnCount = 0;
        boolean infGame = false;

        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;

        player1.name = "Player 1";
        player2.name = "Player 2";
        player3.name = "Player 3";
        player4.name = "Player 4";
        int numOfPlayers = Integer.parseInt(JOptionPane.showInputDialog(null,"How many players? Up to 4 total players. Enter 0 for only computers."));
     	for(int i = 0; i < numOfPlayers; i++) {
     		players[i].setPlayerType("Player");
     		System.out.println(players[i].getName() + " is now a Player!");
     	}
     	System.out.println();
     	int totalCount = Integer.parseInt(JOptionPane.showInputDialog(null, "Maximum turns until game automatically ends? Enter 0 for infinite game length."));
     	if(totalCount == 0)
     		infGame = true;
        while(!checkWin(players) && turnCount <= totalCount || !checkWin(players) && infGame) {
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
        System.out.println(outputWinner(players).getName() + " won!");
        System.out.println("===========================");
    }

	private static void runGui() throws IOException {
		// TODO Auto-generated method stub

        File file = new File("src/ImageOfBoard.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jFrame.setLayout(new FlowLayout());
        //835, 845
        jFrame.setSize(1000, 1000);
        
        JLabel jLabel = new JLabel();
        jFrame.add(area);
        area.append("Current Player Statistics\n");
        //
        //area.selectAll();
        //area.replaceSelection("");
        //
        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
      
    }
}
