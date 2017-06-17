/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setID method, of class Player.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int id = 2;
        Player instance = new Player();
        instance.setID(id);
        assertEquals(2,instance.getID());

    }

    /**
     * Test of setX method, of class Player.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 10;
        Player instance = new Player();
        instance.setX(x);
        assertEquals(10,instance.getX());

    }

    /**
     * Test of setY method, of class Player.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 10;
        Player instance = new Player();
        instance.setY(y);
        assertEquals(10,instance.getY());

    }

    /**
     * Test of adjustScore method, of class Player.
     */
    @Test
    public void testAdjustScore() {
        System.out.println("adjustScore");
        int i = 5;
        Player instance = new Player();
        instance.adjustScore(i);
        
        assertEquals(5,instance.getScore());
    }

    /**
     * Test of getID method, of class Player.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Player instance = new Player();
        instance.setID(2);
        int result = instance.getID();
        assertEquals(2, result);
        
    }

    /**
     * Test of getX method, of class Player.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Player instance = new Player();
        instance.setX(10);
        int result = instance.getX();
        assertEquals(10, instance.getX());

    }

    /**
     * Test of getY method, of class Player.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Player instance = new Player();
        instance.setY(10);
        int result = instance.getY();
        assertEquals(10, result);
        
    }


  
}
