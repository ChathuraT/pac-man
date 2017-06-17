
import java.util.ArrayList;


public class Board {

    final public static int GRIDSIZE = 44;
    final public static int MAX_PLAYERS = 4;
    final public static int NO_OF_DOTS = 10;
    public static int playerCount = 0;
    public static Player[] players = new Player[MAX_PLAYERS];
    public static ArrayList<Dot> dots = new ArrayList();
    
    //initializing the board with dots
    public Board() {
        generateDots();
    }
   
    //this method adds a new player created before to the board
    public void addPlayer(Player player) {
        if(playerCount < MAX_PLAYERS) { //check if the players limit exceeds
            players[playerCount] = player;
            player.setID(playerCount);
            setInitialPosition(player);
            playerCount++;
        }
    }
    
    //this method validates a players move
    public void ValidateMove(int playerID, String keyPress){
        GameLogic.validator( players[playerID],keyPress);
    }
    
    //this method sets the initial position of a given player based on the his player ID
    public void setInitialPosition(Player player) {
       GameLogic.giveInitialPosition(player);
    }
    
    //initial dot Generation
    public void generateDots(){
        for(int i = 0; i<NO_OF_DOTS; i++){
            dots.add(new Dot());
        }
    }  
    
    //serializing the board details into a JSON object 
    @Override
    public String toString() {
        
        String output = "{   \"DOTS\":  "+ dots +" , "
                    + " \"PLAYERS\": [ ";
        for(int i = 0; i < playerCount; i++) {
            output += "[" + players[i] + "]";
            if(i < playerCount - 1) {
                output += ", ";
            }
        }
        
        output +=  "] }" + "\n\n";
        
        //Waiting for 4 players to connect
        if(playerCount<4){
            return "";
        }
        
       return output;
   
    }
    
}
