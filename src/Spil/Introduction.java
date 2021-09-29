package Test;

import java.util.Random;
import java.util.Scanner;

public class Introduktion{
    static Scanner input = new Scanner(System.in);
    static Random number = new Random();

    private static Player player1;
    private static Player player2;
    private static String userinput; //variablen sørger for at brugeren aktivt skal slå med terningerne.

    private static int i = 0; //variablen tages i brug i tilfælde af spillerskift

    private static int valueDie1 = 0;
    private static int valueDie2 = 0;

    public static void slåOmStart(){
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
            //Spiller 1 ruller terning
            System.out.print(player1.getName() + " rul terning: ");
            rulTerning1();
            System.out.print(player1.getName() + " slog: " + getValueDie1() + "\n");
            //Spiller 2 ruller terning
            System.out.print(player2.getName() + " rul terning: ");
            rulTerning2();
            System.out.println(player2.getName() + " slog: " + getValueDie2());

            if(getValueDie1() != getValueDie2()){ //tester om slagene er forskellige.

                //hvis slagene er forskellige testes for størst slag. Hvis spiller1 slår højest sker ingen ændringer.
                if(getValueDie1() > getValueDie2()){
                    System.out.println(player1.getName() + " slog højest og starter derfor.");
                }else{
                    //hvis spiller2 har slået højest byttes der om på de to spillere.
                    System.out.println(player2.getName() + " slog højest og starter derfor.");
                    System.out.println("Hermed er " + player2.getName() + " Spiller1 og vice versa.");
                    i++;
                }
            }//I tilfælde af ens slag skal spillerne slå om.
            else{
                System.out.println("I slog begge: " + getValueDie1() + "\nSlå igen..!" );
                j--; //ved omslag tælles j ned, så der bliver slået om til en vinder er fundet.
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        }
    }
    //Hvis player2 slog højest er i=1. Hermed vil player2 blive til player1 i Spillet-klassen og vice versa.
    //metoden bliver brugt til at initierer Player-constructoren fra Spillet-klassen.
    public static String player1(){
        String name;
        if(i == 1)
            name = player2.getName();
        else
            name = player1.getName();
        return name;
    }

    public static String player2(){
        String name;
        if(i == 1)
            name = player1.getName();
        else
            name = player2.getName();
        return name;
    }
    public static String inputName(){ //Hjælpemetode til Player-constructor
        System.out.print("Spiller indtast navn: ");
        return input.next();
    }

    public static int getValueDie2(){
        return valueDie2;
    }
    public static int getValueDie1(){
        return valueDie1;
    }

    //ruller terning og returnerer værdien
    public static void rulTerning1(){
        userinput = input.next();
        valueDie1 = number.nextInt(6)+1;
    }

    public static void rulTerning2(){
        userinput = input.next();
        valueDie2 = number.nextInt(6)+1;
    }

}