package Spil;

public class Player {
    private String name;
    private int score = 0;

    /**
     * Constructor that sets name of player
     * @param name: String, sets player name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Resets player score
     */
    public void scoreReset(){
        score = 0;
    }

    /**
     * Get player score
     * @return : int
     */
    public int getScore() {
        return score;
    }

    /**
     * Set score of player
     * @param score : int.
     */
    public void setScore(int score) {
        this.score += score;
    }

    /**
     * Get player name
     * @return : String
     */
    public String getName() {
        return name;
    }

    /**
     * Set player name
     * @param name
     */
    public void setName(String name){
        this.name = this.name;
    }

}