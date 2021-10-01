package Spil;

public class Game {
    private final Introduction intro = new Introduction();
    private final GameLogic gamelogic = new GameLogic();

    public void play(){

        //Call 'findPlayer1'-method from Introduction class.
        intro.findPlayer1();
        intro.rulesGame();

        Player player1 = new Player(intro.player1());
        Player player2 = new Player(intro.player2());

        //runs the game while gameWon variable is false.
        while((!gamelogic.checkGameWon())){
            gamelogic.playerTurn(player1);
            if(!gamelogic.checkGameWon()) {
                gamelogic.playerTurn(player2);
            }
        }
    }
}


