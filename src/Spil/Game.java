package Spil;

public class Game {
    private final Introduction intro = new Introduction();
    private final Gamelogic gamelogic = new Gamelogic();

    private int j = 1; //j is used to swap turns between the players. Value is set so player1 starts.

    public void play(){
        //kalder 'slåomstart'-metoden fra Introduktions klassen.
        intro.slåOmStart();

        Player player1 = new Player(intro.player1());
        Player player2 = new Player(intro.player2());

        //runs the game while gameWon variable is false.
        while((!gamelogic.gameWon(player1)) && (!gamelogic.gameWon(player2))){
            if(j == 1) {
                gamelogic.playerTurn(player1);
                j++;
            }
            else {
                gamelogic.playerTurn(player2);
                j--;
            }
        }
    }
}


