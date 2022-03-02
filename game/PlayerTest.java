package game;
import static org.junit.Assert.assertFalse;
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
        assertTrue(playerOne.getName() == NULL);
        playerOne.setName(nameOfPlayer);
        assertTrue(playerOne.getName().equals("nameOfPlayer"));
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
	public void testGetSetPosition() {
        Player playerOne = new Player();
        assertTrue(playerOne.getPosition() == 0);
        playerOne.setPosition(20);
        assertTrue(playerOne.getPosition() == 20);
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