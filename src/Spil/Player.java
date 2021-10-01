package Spil;

public class Player {
    private String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void scoreReset(){
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}
