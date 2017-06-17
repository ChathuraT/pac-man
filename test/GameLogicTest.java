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
public class GameLogicTest {
    Player p1,p2,p3,p4;
    
    public GameLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         Board board = new Board();
         p1 = new Player();
         board.addPlayer(p1); 
         p2 = new Player();
         board.addPlayer(p2); 
         p3 = new Player();
         board.addPlayer(p3); 
         p4 = new Player();
         board.addPlayer(p4); 

              
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of giveInitialPosition method, of class GameLogic.
     */
    @Test
    public void testGiveInitialPosition() {
        System.out.println("giveInitialPosition");
        GameLogic.giveInitialPosition(p1);
        GameLogic.giveInitialPosition(p2);
        GameLogic.giveInitialPosition(p3);
        GameLogic.giveInitialPosition(p4);

        
      int p1_x_actual = p1.getX();
      int p1_y_actual = p1.getY();

      int p2_x_actual = p2.getX();
      int p2_y_actual = p2.getY();
      
      int p3_x_actual = p3.getX();
      int p3_y_actual = p3.getY();
     
      int p4_x_actual = p4.getX();
      int p4_y_actual = p4.getY();

      assertEquals(0,p1_x_actual);
      assertEquals(0,p1_y_actual);
      
      assertEquals(Board.GRIDSIZE,p2_x_actual);
      assertEquals(0,p2_y_actual);

      assertEquals(0,p3_x_actual);
      assertEquals(Board.GRIDSIZE,p3_y_actual);

      assertEquals(Board.GRIDSIZE,p4_x_actual);
      assertEquals(Board.GRIDSIZE,p4_y_actual);


    }
    
    /**
     * Test of isGameEnded method, of class GameLogic.
     */
    
    @Test
    public void testIsGameEnded() {
        System.out.println("isGameEnded");
        boolean expResult = false;
        boolean result = GameLogic.isGameEnded();
        assertEquals(expResult, result);
        
    }
}
