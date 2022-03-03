package game;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jdk.jfr.Timestamp;

public class BoardSpaceTest {
    @Test
    public void testDefaultConstructor() {
        BoardSpace spaceOne = new BoardSpace();
        assertFalse(getOwned());
    }

    @Test
    public void testSetName() {
        BoardSpace spaceOne = new BoardSpace();
        spaceOne.setName("oneSpace");
        assertTrue(spaceOne.getName().equals("oneSpace"));

        spaceOne.setName("two");
        assertTrue(spaceOne.getName().equals("two"));

        BoardSpace spaceTwo = new BoardSpace();
        spaceTwo.setName("twoSpace");
        assertTrue(spaceTwo.getName().equals("twoSpace"));

        spaceTwo.setName("three");
        assertTrue(spaceTwo.getName().equals("three"));

        assertThrows(spaceTwo.setName(4));
    }

    @Test
    public void testSetNameTwo() {
        BoardSpace spaceOne = new BoardSpace();
        spaceOne.setName("Space");
        assertTrue(spaceOne.getName().equals("Space"));
        
        BoardSpace spaceTwo = new BoardSpace();
        spaceTwo.setName("pSpace");
        assertTrue(spaceTwo.getName().equals("pSpace"));
    }

    @Test 
    public void testGetCostToBuy(){
        BoardSpace spaceOne = new BoardSpace();
        spaceOne.setCostToBuy(920);
        assertTrue(spaceOne.getCostToBuy() == 920);

        BoardSpace spaceTwo = new BoardSpace();
        spaceTwo.setCostToBuy(1);
        assertTrue(spaceTwo.getCostToBuy() == 1);

        BoardSpace spaceThree = new BoardSpace();
        spaceThree.setCostToBuy(30);
        assertTrue(spaceThree.getCostToBuy() == 30);
    }

    @Test 
    public void testGetRent(){
        BoardSpace spaceOne = new BoardSpace();
        spaceOne.setRent(292);
        assertTrue(spaceOne.getRent() == 292);

        BoardSpace spaceTwo = new BoardSpace();
        spaceTwo.setRent(9);
        assertTrue(spaceTwo.getRent() == 9);

        BoardSpace spaceThree = new BoardSpace();
        spaceThree.setRent(0);
        assertTrue(spaceThree.getRent() == 0);
    }

    @Test 
    public void testGetColorSet(){
        BoardSpace spaceOne = new BoardSpace();
        spaceOne.setColorSet("red");
        assertTrue(spaceOne.getColorSet() == "red");

        BoardSpace spaceTwo = new BoardSpace();
        spaceTwo.setColorSet("blue");
        assertTrue(spaceTwo.getColorSet() == "blue");

        BoardSpace spaceThree = new BoardSpace();
        spaceThree.setColorSet("purple");
        assertTrue(spaceThree.getColorSet() == "purple");
    }

    @Test 
    public void testGetOwned(){
        BoardSpace spaceOne = new BoardSpace();
        spaceOne.setOwned(true);
        assertTrue(spaceOne.getOwned());

        BoardSpace spaceTwo = new BoardSpace();
        spaceTwo.setOwned(false);
        assertFalse(spaceTwo.getOwned());

        BoardSpace spaceThree = new BoardSpace();
        spaceThree.setOwned(true);
        assertTrue(spaceThree.getOwned());
    }

    @Test 
    public void testGetOwner(){
        BoardSpace spaceOne = new BoardSpace();
        Player playerOne = new Player();
        spaceOne.setOwner(playerOne);
        assertTrue(spaceOne.getOwner().equals(playerOne));

        BoardSpace spaceTwo = new BoardSpace();
        Player playerTwo = new Player();
        spaceTwo.setOwner(playerTwo);
        assertTrue(spaceTwo.getOwner().equals(playerTwo));
    }

}


