
import java.util.Random;


public class GameLogic {
    private static Player player;
    private static String keyPress;
    private static int tempX;
    private static int tempY;
    private static boolean collisionOccurred;

    //this method does the main validation process of a players move 
    public static void validator(Player currentPlayer, String currentKeyPress){
        keyPress = currentKeyPress;
        player = currentPlayer;
        tempX = player.getX();
        tempY = player.getY();
        collisionOccurred = false;
        
        getTemporaryPosition();
        calculateScore();
        movePlayer();
        
        if(isGameEnded()){
            System.out.println("The game has been ended");   
        }
        
    }
    
    //this method calculates the new possition of the player for the validate process
    private static void getTemporaryPosition() {
         if (keyPress.equals("40")) { //key down
             tempY = (++tempY) % (Board.GRIDSIZE + 1);
        } else if (keyPress.equals("38")) { //key up
            if (--tempY < 0) {
                tempY += Board.GRIDSIZE + 1;
            }
        } else if (keyPress.equals("37")) { //key left
            if (--tempX < 0) {
                tempX += Board.GRIDSIZE + 1;
            }
        } else if (keyPress.equals("39")) { //key right
             tempX = (++tempX) % (Board.GRIDSIZE + 1);
        }
     }
  
    //this method is used to the score of the player after each move
    private static void calculateScore() {
        //calculating points for dot eats
        int dotEated = checkDotEat();
        if(dotEated != -1){
            switch (Board.dots.get(dotEated).getColor()){
                case "R" : player.adjustScore(1);
                           break;
                case "G" : player.adjustScore(2);
                           break;
                case "B" : player.adjustScore(4);
                           break;
            }
           //removing the dot eated from the board
           removeDot(dotEated);
        }
        
        //calculating points for collisions
        int collidedPlayer = checkCollision();
        
        if(collisionOccurred){
            player.adjustScore(-3);
            Board.players[collidedPlayer].adjustScore(-3);
            //resetting the collided player in to initial position
            giveRandomPosition(Board.players[collidedPlayer]);
        }
    }
    
    //this method check whether the user has eaten a dot
    private static int checkDotEat() {
      //if a dot is eaten returns the dot's index
      for ( int i = 0; i<Board.dots.size(); i++){
        Dot dot = Board.dots.get(i);
        if ((dot.getX() == tempX) && (dot.getY() == tempY)) {
            return i;
        }
        
      }
      //if no dot is eaten return -1
      return -1;
    }
       
    //this method check whether the the two users have collided
    private static int checkCollision() {
        //if a collision has happpened return the collided player's ID
        for (int i = 0 ; i< Board.playerCount; i++ ){
            if(i == player.getID()){ //ignore player himself
                continue;
            }
            
            Player otherPlayer = Board.players[i];
            if((player.getX()==otherPlayer.getX())&&(player.getY()==otherPlayer.getY())){
                collisionOccurred = true;
                return i;
            }
        }
        //if no collision has occured return -1
      return -1;
    }
    
    //this method is used to assign the initial position vales for the players
    public static void giveInitialPosition(Player player) {
        switch (player.getID()) {
            case 0:
                player.setX(0);
                player.setY(0);
                break;
            case 1:
                player.setX(Board.GRIDSIZE);
                player.setY(0);
                break;
            case 2:
                player.setX(0);
                player.setY(Board.GRIDSIZE);
                break;
            case 3:
                player.setX(Board.GRIDSIZE);
                player.setY(Board.GRIDSIZE);
                break;
            default:
                break;
        }
    }
    
    //this function gives a random position to a player when a collision occurs
    public static void giveRandomPosition(Player player) {
        Random rand = new Random();
        player.setX(rand.nextInt(Board.GRIDSIZE+1));
        player.setY(rand.nextInt(Board.GRIDSIZE+1));
    }
    
    //this function is used to remove a dot from the board
    private static void removeDot(int i){
        Board.dots.remove(i);
    }
   
    //this function is used to move the player in the board 
    private static void movePlayer() {
       if(collisionOccurred){
           giveRandomPosition(player);
       }else{
            player.setX(tempX);
            player.setY(tempY);
       }
    }
    
    //checking for the end of the game
    public static boolean isGameEnded(){
        return (Board.dots.isEmpty());
    }
    
}
