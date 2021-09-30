package Spil;
import java.util.Scanner;

public class GameLogic(){
    private Scanner scan = new Scanner(System.in);

    private Player player;

    private Die die1 = new Die();
    private Die die2 = new Die();

    private int sum;
    private boolean gameWon = false;

    /**
     * Prompt player to roll dice
     */
    public void rollDice(){
        System.out.println("Tryk på en vilkårlig tast for at slå med terningerne: ");
        scan.nextInput;
        die1.roll();
        die2.roll();
    }

    public void setSum(){
        sum += die1.getFaceValue()+die2.getFaceValue());
    }

    public int getSum() {
        return sum
    }

    public int throwDice{
        rollDice();
        System.out.println("Der er slået " + die1.getFaceValue() + " og " + die2.getFaceValue());
        setSum();
        return getSum();
    }

}