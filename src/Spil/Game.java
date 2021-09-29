package Spil;

public class Game {
    private Introduction intro = new Introduction();
    private Gamelogic gamelogic = new Gamelogic();
    private String userinput; //The variable ensures the user has to actively roll the dice

    private Die die = new Die();

    public void play(){
        //kalder 'slåomstart'-metoden fra Introduktions klassen.
        intro.slåOmStart();

        Player player1 = new Player(intro.player1());
        Player player2 = new Player(intro.player2());

        while((!gamelogic.gameWon(player1)) && (!gamelogic.gameWon(player2))){
            for(int i = 1; i <= 2; i++){
                if(i == 1)
                    gamelogic.playerTurn(player1);
                else
                    gamelogic.playerTurn(player2);

                if(gamelogic.checkGameWon())
                    i++;
                }
            }
        }

    }


