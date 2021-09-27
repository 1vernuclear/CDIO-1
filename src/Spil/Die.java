package Spil;
import java.lang.Math;

public class Die {
    private int faceValue, numberOfSides;

    public Die (int sides){
        numberOfSides = sides;
    }

    public Die {
        numberOfSides = 6;
    }

    /*
    Metoden ruller terningen og returnerer et hel tal,
    der benyttes som terningens øjne
    */
    public int roll {
        faceValue = (int)((Math.random()*numberOfSides)+1);
    }

    /*
    Metode til at sætte en specifik værdi for terningens øjne
    */
    public void setFaceValue(int value) {
        faceValue = value;
    }

    /*
    Metode til at få værdien af terningens øjne
     */
    public int getFaceValue {
        return faceValue;
    }
}