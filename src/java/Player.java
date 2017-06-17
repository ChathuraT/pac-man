
public class Player {

    private int id;
    private int x;
    private int y;
    private int score;

    public Player() {
        score = 0;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void adjustScore(int i) {
        this.score = score + i;
    }

    public int getID() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }

    public String toString(){
        return "\"P"+(id+1)+"\", "+score+", "+x+", "+y;
    }

}
