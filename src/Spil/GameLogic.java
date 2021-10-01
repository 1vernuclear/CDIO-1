package Spil;

import java.util.Scanner;

public class GameLogic {
    //Needed so the players can actively throw dice with user input.
    private final Scanner input = new Scanner(System.in);

    //A die object for each die.
    private final Die die1 = new Die();
    private final Die die2 = new Die();

    private int throwSum;
    private boolean gameWon = false; //gameWon is true when a player wins the game.

    //Rolls Die1 and Die2 when called upon and setting throwSum.
    public void rollDice() {
        System.out.print(" Slå med terningerne: ");
        input.next();
        die1.rollDie();
        die2.rollDie();
        throwSum = die1.getFaceValue() + die2.getFaceValue();
    }


    /**
     * PlayerTurn takes a Player object as argument, and performs a turn for this player.
     * A turn consists of rolling the dice, adding the throwSum value to that players score.
     * <p>
     * After this, there will be checked for the following criterion in following order:
     * is game won? is throw double 6? is next throw also double 6? is throw double 1?
     * is die 1 and 2 faceValue identical?
     * <p>
     * At last there will be checked for player score > 40, if a player hasn't won.
     * If a players score is below 40, the players score will be printed.
     * If a players score is above 40, the players score will no longer be printed.
     * Instead, the game will output the players win condition.
     * <p>
     * The checks will be performed by individual methods for each case.
     *
     * @param player the player object added whose turn it is
     */
    public void playerTurn(Player player) {
        boolean turnOngoing = true;
        //runs once unless player gets extra turn.
        while (turnOngoing) {
            System.out.print(player.getName()); //prints currents players name.
            player.addScore(throwDice()); //throws dice and adds throwSum to players score.
            turnOngoing = false;

            if (gameWon(player)) { //checks if gameWon is true.
                System.out.println("Tillyke " + player.getName() + "! Du har vundet spillet!");
            }

            //Checks if two matching dice are thrown, and acts accordingly for the double 6, double 1, or double 2-5.
            else if (getEqual()) {
                //checks if throw is double six.
                if (die1.getFaceValue() == 6) {
                    System.out.println("Hvis du slår dobblet 6 på dit næste slag, vinder du spillet."
                            + " Fordi du slog dobbelt får du et ekstra slag.");
                    player.addScore(throwDice()); //same player throws dice
                    if (doubleDoubleSix()) { //checks if new throw is also double six. If true prints the following.
                        System.out.println(player.getName() + " har vundet spillet ved at slå dobbelt 6 to gange i træk.");
                    }

                    //Checks if the double roll is 1, calls the scoreReset method from the Player class.
                } else if (die1.getFaceValue() == 1) {
                    System.out.println(player.getName() + " slog dobbelt 1 og mister alle sine point... :(");
                    System.out.println(player.getName() + " har dermed en score på: " + player.getScore());
                    player.scoreReset(); //Sets players score to 0.
                }

                //if neither, double 2-5, the player gets another turn.
                else {
                    System.out.println("Fordi du slog to ens får du endnu en tur!");
                    turnOngoing = true;
                }
            }
            //if players score is below 40, name and score gets printed.
            if (player.getScore() < 40)
                System.out.println(player.getName() + " har dermed en score på: " + player.getScore());
                //if players score is above 40 win condition will be printed.
            else if (player.getScore() >= 40 && !gameWon)
                System.out.println("Slå to ens for at vinde spillet!");
            //marks each turn or run in the loop.
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        }
    }

    private int getThrowSum() { //returns throwSum. Used to set score.
        return throwSum;
    }

    //calls the roll dice method, sets the throwSum, prints each dieDaceValue and returns the throwSum.
    private int throwDice() {
        rollDice();
        System.out.println("Du har slået: " + die1.getFaceValue() + " og " + die2.getFaceValue());
        return getThrowSum();
    }

    /**
     * Checks if a player has won the game or not. The gameWon variable will be set to true when a player wins.
     *
     * @param player represents each player for each turn.
     * @return if false nothing happens, if true code will be performed in playerTurn for the relevant player.
     * The Game class method Play() will run the loop until the gameWon method returns true.
     */
    private boolean gameWon(Player player) {
        if (player.getScore() > 40)
            if (die1.getFaceValue() == die2.getFaceValue())
                gameWon = true;
        return gameWon;
    }

    //checks if gameWon has been set to true.
    public boolean checkGameWon() {
        return gameWon;
    }

    //Method will be called if the previous throw was double six. Checks if next throw is also double six.
    private boolean doubleDoubleSix() {
        if (die1.getFaceValue() == 6) //If true gameWon var gets set to true.
            gameWon = true;
        return gameWon;
    }

    //Checks if Die 1 and 2 faceValues are the same. Gives player another throw if true.
    private boolean getEqual() {
        return die1.getFaceValue() == die2.getFaceValue();
    }

}

