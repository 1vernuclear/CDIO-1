package Test;

import java.util.Random;
import java.util.Scanner;

public class Introduktion {
    static Scanner input = new Scanner(System.in);
    static Random number = new Random();

    static String spiller1;
    static String spiller2;
    static String rulTerning;

    static int valueDie1 = 0;
    static int valueDie2 = 0;

    public static void slåOmStart(){
        System.out.println("Velkommen til terningespillet " + getName1() + " og " + getName2());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("I slår om at starte. Dertil bruges en terning. Spilleren med det"
                + " største slag starter." + "\n" + "Ved lige store slag, slår spillerne om indtil en vinder er fundet.");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Hver spiller skal selv rulle terningen ved sin tur. For at rulle terningen"
                + "\ntastes et tilfældigt tal bogstav ind i konsolen. Derefter trykkes der på enter");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.print("Når i er klar til at starte: skriv \"start\" og tast enter: ");
        rulTerning = input.next();

        while(true) {
            //Spiller 1 ruller terning
            System.out.print(getName1() + " rul terning: ");
            rulTerning1();
            System.out.print(getName1() + " slog: " + getValueDie1() + "\n");
            //Spiller 2 ruller terning
            System.out.print(getName2() + " rul terning: ");
            rulTerning2();
            System.out.println(getName2() + " slog: " + getValueDie2());
            //Når spillerne ikke har slået det samme bliver en "starter" fundet til det rigtige spil.
            //getValueDie metoden returnerer terningens værdi efter seneste slag.
            if(getValueDie1() != getValueDie2()){
                if(getValueDie1() > getValueDie2()){
                    System.out.println(getName1() + " slog højest og starter derfor.");
                    break;
                }else{
                    System.out.println(getName2() + " slog højest og starter derfor.");
                    System.out.println("Hermed er " + getName2() + " Spiller1 og vice versa.");
                    spillerSkift();
                    break;
                }
            }//I tilfælde af ens slag skal spillerne slå om.
            else{
                System.out.println("I slog begge: " + getValueDie1() + "\nSlå igen..!" );
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        }
    }
    public static void spillerSkift(){
        String placeholder = getName1();
        spiller1 = getName2();
        spiller2 = placeholder;
    }
    public static int getValueDie2(){
        return valueDie2;
    }
    public static int getValueDie1(){
        return valueDie1;
    }
    //ruller terning og returnerer værdien
    public static void rulTerning1(){
        rulTerning = input.next();
        valueDie1 = number.nextInt(6)+1;
    }
    public static void rulTerning2(){
        rulTerning = input.next();
        valueDie2 = number.nextInt(6)+1;
    }
    public static void setName2(){
        System.out.print("Spiller 2 indtast dit navn: ");
        spiller2 = input.next();
    }
    public static String getName2(){
        return spiller2;
    }
    public static void setName1(){
        System.out.print(("Spiller 1 indtast dit navn: "));
        spiller1 = input.next();
    }
    public static String getName1(){
        return spiller1;
    }

}
