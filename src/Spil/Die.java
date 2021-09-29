package Spil;
import java.lang.Math;

public class Die {
    private int faceValue, numberOfSides;

    /**
     * Constructor sets amount of sides of die
     * @param sides: int, defines number of sides
     */
    public Die (int sides){
        numberOfSides = sides;
    }

    /**
     * Constructor sets number of sides to 6
     */
    public Die {
        numberOfSides = 6;
    }

    /**
     * Rolls die and returns integer
     */
    public int roll {
        faceValue = (int)((Math.random()*numberOfSides)+1);
    }

    /**
     * Sets specific value of eyes on die
     * @param value: int, sets new value of faceValue.
     */
    public void setFaceValue(int value) {
        faceValue = value;
    }

    /**
     *  Return face value of die
     */
    public int getFaceValue {
        return faceValue;
    }
}