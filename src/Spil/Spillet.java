package Spil;
import Test.*;

public class Spillet{

    public static void main(String[] args) {
        //kalder 'slåomstart'-metoden fra Introduktions klassen.
        Introduktion.slåOmStart();

        //Introduktionen fordeler spiller 1 og 2, således at player1 og player initieres med angivne navne fra Introduktion.
        Player player1 = new Player(Introduktion.player1());
        Player player2 = new Player(Introduktion.player2());


    }
}
