package game;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//import jdk.jfr.Timestamp;

public class BoardTest {
    @Test
    public void testDefaultConstructor() {
        Board gameBoard = new Board();
        gameBoard.initBoard();
        //assertTrue(gameBoard.getBoard().equals(gameBoard));
    }

    @Test
    public void testGetNameOfSpace() {
        Board gameBoard = new Board();
        gameBoard.initBoard();
        assertTrue(gameBoard.getNameOfSpace(1).equals("Mediterranean Avenue"));
    }

    @Test
    public void testGetNameOfSpaceTwo() {
        Board gameBoard = new Board();
        gameBoard.initBoard();
        assertTrue(gameBoard.getNameOfSpace(33).equals("Community Chest"));
    }

    @Test 
    public void testCanBuyThisSquare() {
        Board gameBoard = new Board();
        gameBoard.initBoard();
        assertTrue(gameBoard.canBuyThisSquare(2));

        assertTrue(gameBoard.canBuyThisSquare(4));

        assertFalse(gameBoard.canBuyThisSquare(6));
    }

}
