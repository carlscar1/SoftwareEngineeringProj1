package game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void testDefaultConstructor() {
        Player playerOne = new Player();
        assertTrue(playerOne.getPosition() == 0);
        assertTrue(playerOne.getMoney() == 750);
        assertTrue(playerOne.getDoubleStreak() == 0);
    }

    @Test
    public void testSetName() {
        Player playerOne = new Player();
        assertTrue(playerOne.getName() == null);
        playerOne.setName("nameOfPlayer");
        assertTrue(playerOne.getName().equals("nameOfPlayer"));
    }

    @Test
    public void testSetNameTwo() {
        Player playerOne = new Player();
        assertTrue(playerOne.getName() == null);
        playerOne.setName("play");
        assertTrue(playerOne.getName().equals("play"));

        Player playerTwo = new Player();
        assertTrue(playerTwo.getName() == null);
        playerTwo.setName("p");
        assertTrue(playerTwo.getName().equals("p"));

        Player playerThree = new Player();
        assertTrue(playerThree.getName() == null);
        //assertThrows(playerThree.setName(4));
    }

    @Test
    public void testSetMoney() {
        Player playerOne = new Player();
        assertTrue(playerOne.getMoney() == 750);

        playerOne.setMoney(500);
        assertTrue(playerOne.getMoney() == 500);

        playerOne.addMoney(50);
        assertTrue(playerOne.getMoney() == 550);

        playerOne.addMoney(-70);
        assertTrue(playerOne.getMoney() == 480);
    }

    @Test
    public void testSetMoneyTwo() {
        Player playerOne = new Player();
        assertTrue(playerOne.getMoney() == 750);

        playerOne.setMoney(50);
        assertTrue(playerOne.getMoney() == 50);

        playerOne.addMoney(50);
        assertTrue(playerOne.getMoney() == 100);

        playerOne.addMoney(-70);
        assertTrue(playerOne.getMoney() == 30);

        playerOne.addMoney(0);
        assertTrue(playerOne.getMoney() == 30);
    }

    @Test
    public void testGetSetPosition() {
        Player playerOne = new Player();
        assertTrue(playerOne.getPosition() == 0);

        playerOne.setPosition(20);
        assertTrue(playerOne.getPosition() == 20);
    }

    @Test
    public void testGetSetPositionTwo() {
        Player playerOne = new Player();
        assertTrue(playerOne.getPosition() == 0);
        
        playerOne.setPosition(33);
        assertTrue(playerOne.getPosition() == 33);

        playerOne.setPosition(3);
        assertTrue(playerOne.getPosition() == 3);

        playerOne.setPosition(0);
        assertTrue(playerOne.getPosition() == 0);

        playerOne.setPosition(2);
        assertTrue(playerOne.getPosition() == 2);
    }

    @Test
    public void testDoubleStreak() {
        Player playerOne = new Player();
        assertTrue(playerOne.getDoubleStreak() == 0);

        playerOne.addToDoubleStreak();
        assertTrue(playerOne.getDoubleStreak() == 1);

        playerOne.addToDoubleStreak();
        assertTrue(playerOne.getDoubleStreak() == 2);
    }

    @Test
    public void testJailCounter() {
        Player playerOne = new Player();
        assertTrue(playerOne.getJailCounter() == 0);

        playerOne.addToJailCounter();
        assertTrue(playerOne.getJailCounter() == 1);
        
        playerOne.addToJailCounter();
        assertTrue(playerOne.getJailCounter() == 2);
    }
}