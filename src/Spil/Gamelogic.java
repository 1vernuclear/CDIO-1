package Spil;

import java.util.Scanner;

public class Gamelogic{
    private final Scanner input = new Scanner(System.in);

    private Player player;
    private Die die1 = new Die();
    private Die die2 = new Die();
    private int sum;
    private boolean gameWon = false;


    public void rollDice(){
        System.out.print(" Slå med terningerne: ");
        input.next();
        die1.rollDie();
        die2.rollDie();
    }
    public void setThrowSum(){
        sum = die1.getFaceValue() + die2.getFaceValue();
    }
    public void playerTurn(Player x) {
        player = x;
        for (int i = 1; i < 2; i++) {
            System.out.print(player.getName());
            player.setScore(throwDice());

            if (doubleSix(die1.getFaceValue())) {
                System.out.println("Hvis du slår dobblet 6 på dit næste slag, vinder du spillet."
                        + " Fordi du slog dobbelt får du et ekstra slag.");
                for (int j = 1; j < 2; j++) {
                    player.setScore(throwDice());
                    if(doubleDoubleSix())
                        System.out.println(player.getName() + " har vundet spillet ved at slå dobbelt 6 to gange i træk.");
                }
            }else if(gameWon(player)){
                System.out.println("Tillyke " + player.getName() + "! Du har vundet spillet!");
            }else if(getEns()){
            }
        }
    }
    public int getThrowSum(){
        return sum;
    }
    public int throwDice(){
        rollDice();
        setThrowSum();
        System.out.println("Du har slået: " + die1.getFaceValue() + " og " + die2.getFaceValue());
        return getThrowSum();
    }
    public boolean gameWon(Player x){
        player = x;
        boolean bool = false;
        if(player.getScore() > 40){
            if(die1.getFaceValue() == die2.getFaceValue())
                bool = true;
        }else if(gameWon)
            bool = true;
        return bool;
    }
    public boolean doubleSix(int faceValue){
        boolean bool = false;
        if(faceValue == 6 && getEns()) {
            bool = true;
        }
        return bool;
    }
    public boolean doubleDoubleSix(){
        boolean bool = false;
        if(doubleSix(die1.getFaceValue()))
            gameWon = true;
            bool = true;
        return bool;
    }
    public boolean resetCheck(){
        boolean bool = false;
        if(die1.getFaceValue() == 1)
            bool = true;
        return bool;
    }

    public boolean getEns(){
        boolean bool = false;
        if(die1.getFaceValue() == die2.getFaceValue() && die1.getFaceValue() != 1)
            bool = true;
        return bool;
    }

}
