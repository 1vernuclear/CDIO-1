package Spil;
import java.lang.Math;

public class Die {
    private int faceValue, numberOfSides;

    /**
     * Konstruktør der sætter antal sider for terningen
     * @param sides int der definere antal sider
     */
    public Die (int sides){
        numberOfSides = sides;
    }

    /**
     * Konstruktør der sætter antal sidder til 6 for terningen
     */
    public Die {
        numberOfSides = 6;
    }

    /**
     * Metoden ruller terningen og returnerer et hel tal,
     *     der benyttes som terningens øjne
     */
    public int roll {
        faceValue = (int)((Math.random()*numberOfSides)+1);
    }

    /**
     * Metode til at sætte en specifik værdi for terningens øjne
     * @param value int der definerer den nye faceValue.
     */
    public void setFaceValue(int value) {
        faceValue = value;
    }

    /**
     *  Metode returnere værdien af terningens øjne
     */
    public int getFaceValue {
        return faceValue;
    }
}