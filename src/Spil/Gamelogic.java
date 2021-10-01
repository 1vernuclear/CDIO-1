package Spil;

import java.util.Scanner;

public class Gamelogic{
    //Needed so the players can actively throw dice with user input.
    private final Scanner input = new Scanner(System.in);

    //A die object for each die.
    private final Die die1 = new Die();
    private final Die die2 = new Die();

    private Player player; //player object used by the playerTurn method

    private int throwSum;
    private boolean gameWon = false; //gameWon is true when a player wins the game.

    //Rolls Die1 and Die2 when called upon.
    public void rollDice(){
        System.out.print(" Slå med terningerne: ");
        input.next();
        die1.rollDie();
        die2.rollDie();
    }

    //calculating and setting throwsum.
    public void setThrowSum(){
        throwSum = die1.getFaceValue() + die2.getFaceValue();
    }

    /**
     * Playerturn takes a Player object as argument, and performs a turn for this player.
     * A turn consists of rolling the dice, adding the throwsum value to that players score.
     *
     * After this, there will be checked for the following criterion in following order:
     * is game won? is throw double 6? is next throw also double 6? is throw double 1?
     * is die 1 and 2 facevalue identical?
     *
     * At last there will be checked for player score > 40, if a player hasn't won.
     * If a players score is below 40, the players score will be printed.
     * If a players score is above 40, the players score will no longer be printed.
     * Instead the game will output the players win condition.
     *
     * The checks will be performed by individual methods for each case.
     * @param x: instance of player object
     */
    public void playerTurn(Player x) {
        player = x;
        //runs once unless player gets extra turn.
        for (int i = 1; i < 2; i++) {
            System.out.print(player.getName()); //prints currents players name.
            player.setScore(throwDice()); //throws dice and adds throwsum to players score.

            if(gameWon(player)) { //checks if gamewon is true.
                System.out.println("Tillyke " + player.getName() + "! Du har vundet spillet!");
            }
            //checks if throw is double six.
            else if (doubleSix(die1.getFaceValue())) {
                System.out.println("Hvis du slår dobblet 6 på dit næste slag, vinder du spillet."
                        + " Fordi du slog dobbelt får du et ekstra slag.");
                for (int j = 1; j < 2; j++) { //if doublesix = true, performs the code in the for loop once.
                    player.setScore(throwDice()); //same player throws dice
                    if(doubleDoubleSix()) //checks if new throw is also double six. If true prints the following.
                        System.out.println(player.getName() + " har vundet spillet ved at slå dobbelt 6 to gange i træk.");
                }
            }
            //if resetcheck returns true, calls the scoreReset method from the Player class.
            else if (resetCheck()) {
                System.out.println(player.getName() + " slog dobbelt 1 og mister alle sine point... :(");
                System.out.println(player.getName() + " har dermed en score på: " + player.getScore());
                player.scoreReset(); //Sets players score to 0.
            }
            //if true player gets another turn.
            else if(getEqual()){
                System.out.println("Fordi du slog to ens får du endnu en tur!");
                i--;
            }
            //if players score is below 40, name and score gets printed.
            if(player.getScore() < 40)
                System.out.println(player.getName() + " har dermed en score på: " + player.getScore());
            //if players score is above 40 win condition will be printed.
            else if(player.getScore() >= 40 && gameWon != true)
                System.out.println("Slå to ens for at vinde spillet!");
            //marks each turn or run in the loop.
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        }
    }
    public int getThrowSum(){ //returns throwsum. Used to set score.
        return throwSum;
    }
    //calls the roll dice method, sets the throwsum, prints each diefacevalue and returns the throwsum.
    public int throwDice(){
        rollDice();
        setThrowSum();
        System.out.println("Du har slået: " + die1.getFaceValue() + " og " + die2.getFaceValue());
        return getThrowSum();
    }

    /**
     * Checks if a player has won the game or not. The gamewon variable will be set to true when a player wins.
     * @param x represents each player for each turn.
     * @return if false nothing happens, if true code will be performed in playerturn for the relevant player.
     * The Game class method Play() will run the loop until the gameWon method returns true.
     */
    public boolean gameWon(Player x) {
        player = x;
        if (player.getScore() > 40)
            if (die1.getFaceValue() == die2.getFaceValue())
                gameWon = true;
        return gameWon;
    }
    //checks if gamewon has been set to true.
    public boolean checkGameWon(){
        return gameWon;
    }
    //checks if throw is double six, and returns true in that case.
    public boolean doubleSix(int faceValue){
        boolean bool = false;
        if(faceValue == 6 && getEqual()) {
            bool = true;
        }
        return bool;
    }
    //Method will be called if the previous throw was double six. Checks if next throw is also double six.
    public boolean doubleDoubleSix(){
        if(getEqual() && die1.getFaceValue() == 6) //If true gamewon var gets set to true.
            gameWon = true;
        return gameWon;
    }
    //checks if throw was double 1. In that case it sets the players score to 0. Doesn't give player another throw.
    public boolean resetCheck(){
        boolean bool = false;
        if((die1.getFaceValue() == 1) && getEqual())
            bool = true;
        return bool;
    }
    //Checks if Die 1 and 2 facevalues are the same. Gives player another throw if true.
    public boolean getEqual(){
        boolean bool = false;
        if(die1.getFaceValue() == die2.getFaceValue())
            bool = true;
        return bool;
    }

}
