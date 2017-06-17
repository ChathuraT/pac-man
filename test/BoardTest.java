/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class BoardTest {
    Player p1,p2,p3,p4;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addPlayer method, of class Board.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
         Board instance = new Board();
         p1 = new Player();
         instance.addPlayer(p1); 
         p2 = new Player();
         instance.addPlayer(p2); 
         p3 = new Player();
         instance.addPlayer(p3); 
         p4 = new Player();
         instance.addPlayer(p4); 

        assertEquals(Board.players[0], p1);
        assertEquals(Board.players[1], p2);
        assertEquals(Board.players[2], p3);
        assertEquals(Board.players[3], p4);

    }

    
    /**
     * Test of setInitialPosition method, of class Board.
     */
    @Test
    public void testSetInitialPosition() {
        System.out.println("setInitialPosition");
        Player p1 = new Player();
        Board instance = new Board();
        instance.addPlayer(p1);
        instance.setInitialPosition(p1);
        
        int p1_x_actual = p1.getX();
        int p1_y_actual = p1.getY();
      
        assertEquals(0,p1_x_actual);
        assertEquals(0,p1_y_actual);
    }

    /**
     * Test of generateDots method, of class Board.
     */
    @Test
    public void testGenerateDots() {
        System.out.println("generateDots");
        Board instance = new Board();

        assertEquals( instance.NO_OF_DOTS,instance.dots.size());

    }

  
}
