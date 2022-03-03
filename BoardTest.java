package game;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jdk.jfr.Timestamp;

public class BoardTest {
    @Test
    public void testDefaultConstructor() {
        Board gameBoard = new Board();
        assertTrue(gameBoard.getBoard());
    }

    @Test
    public void testGetNameOfSpace() {
        Board gameBoard = new Board();
        assertTrue(getNameOfSpace(1).equals("Mediterranean Avenue"));
    }

    @Test
    public void testGetNameOfSpaceTwo() {
        Board gameBoard = new Board();
        assertTrue(getNameOfSpace(33).equals("Community Chest"));
    }

    @Test 
    public void testCanBuyThisSquare() {
        Board gameBoard = new Board();
        assertFalse(canBuyThisSquare(2));

        assertFalse(canBuyThisSquare(4));

        assertTrue(canBuyThisSquare(6));
    }

}

