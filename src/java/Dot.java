
import java.util.Random;

// creating a data structure for dots
public class Dot{
    private final String color;
    private final int x;
    private final int y;
    private final String[] colors = {"R","G","B"};

    public Dot(){
        Random rand = new Random();
        this.color = colors[rand.nextInt(3)];
        this.x = rand.nextInt(Board.GRIDSIZE+1);
        this.y = rand.nextInt(Board.GRIDSIZE+1);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String getColor(){
        return color;
    }
    @Override
    public String toString(){
        return "[\""+color+"\", "+x+", "+y+"]";
    }
}