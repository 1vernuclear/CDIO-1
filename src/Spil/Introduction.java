package Test;

import java.util.Random;
import java.util.Scanner;

public class Introduktion{
    private final Scanner input = new Scanner(System.in);
    private final Random number = new Random();

    private Player player1;
    private Player player2;
    private String userinput; //The variable ensures the user has to actively roll the dice

    private int i = 0; // The variable is taken into use, in case of a change of player

    private int valueDie1 = 0;
    private int valueDie2 = 0;

    public void slåOmStart(){
        player1 = new Player(inputName());
        System.out.println("Spiller1 = " + player1.getName());
        player2 = new Player(inputName());
        System.out.println("Spiller2 = " + player2.getName());
        System.out.println("Velkommen til terningespillet " + player1.getName() + " og " + player2.getName());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("I slår om at starte. Dertil bruges en terning. Spilleren med det"
                + " største slag starter." + "\n" + "Ved lige store slag, slår spillerne om indtil en vinder er fundet.");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Hver spiller skal selv rulle terningen ved sin tur. For at rulle terningen"
                + "\ntastes et tilfældigt tal bogstav ind i konsolen. Derefter trykkes der på enter.");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.print("Når i er klar til at starte: skriv \"start\" og tast enter: ");
        userinput = input.next();

        for(int j = 0; j < 1; j++) {
            // Player 1 rolls the dice
            System.out.print(player1.getName() + " rul terning: ");
            rulTerning1();
            System.out.print(player1.getName() + " slog: " + getValueDie1() + "\n");
            // Player 2 rolls the dice
            System.out.print(player2.getName() + " rul terning: ");
            rulTerning2();
            System.out.println(player2.getName() + " slog: " + getValueDie2());

            if(getValueDie1() != getValueDie2()){ // Checks if the value of the rolls are different from one another

                // If the rolls are different, it checks which roll was highest, if player 1 rolled the highest, no changes are made.
                if(getValueDie1() > getValueDie2()){
                    System.out.println(player1.getName() + " slog højest og starter derfor.");
                }else{
                    // If Player 2 rolled the highest, the players are swapped around
                    System.out.println(player2.getName() + " slog højest og starter derfor.");
                    System.out.println("Hermed er " + player2.getName() + " Spiller1 og vice versa.");
                    i++;
                }
            }// In the case of both players rolling the same, they are prompted to roll again
            else{
                System.out.println("I slog begge: " + getValueDie1() + "\nSlå igen..!" );
                j--; // In case of rerolls, the process is repeated for j untill a winner is found
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        }
    }
    // If player 2 rolled the highest, then i=1. Hvis in turn makes player 2 the new player 1, and vice versa.
    // The metode is used to initialize the player-constructor from the game class
    public String player1(){
        String name;
        if(i == 1)
            name = player2.getName();
        else
            name = player1.getName();
        return name;
    }

    public String player2(){
        String name;
        if(i == 1)
            name = player1.getName();
        else
            name = player2.getName();
        return name;
    }
    public String inputName(){ // Metode to help the player-constructor
        System.out.print("Spiller indtast navn: ");
        return input.next();
    }

    public int getValueDie2(){
        return valueDie2;
    }
    public int getValueDie1(){
        return valueDie1;
    }

    // Rolls the dice and returns the value
    public void rulTerning1(){
        userinput = input.next();
        valueDie1 = number.nextInt(6)+1;
    }

    public void rulTerning2(){
        userinput = input.next();
        valueDie2 = number.nextInt(6)+1;
    }

}
