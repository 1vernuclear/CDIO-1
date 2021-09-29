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
            int j = 0;
            for(int i = 1; i <= 2; i++){
                if(i == 1) {
                    gamelogic.playerTurn(player1);
                    gamelogic.gameWon(player1);
                }
                else {
                    gamelogic.playerTurn(player2);
                }

                if(gamelogic.getEns()){
                    if(gamelogic.resetCheck()){
                        if(i == 1)
                            player1.scoreReset();
                        else
                            player2.scoreReset();
                    }
                    if(gamelogic.doubleSix(die.getFaceValue())) {
                        j++;
                        if(gamelogic.doubleDoubleSix(j)){
                            switch (i) {
                                case 1:
                                    System.out.println(player1.getName() + " har vundet spillet!");
                                case 2:
                                    System.out.println(player2.getName() + " har vunder spillet!");
                            }
                        }
                    }
                    i--;
                    }
                else {
                    j = 0;
                }


                }
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            }
        }

    }


