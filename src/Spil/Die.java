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

    public int roll {
        faceValue = (int)((Math.random()*numberOfSides)+1);
    }

    public void setFaceValue(int value) {
        faceValue = value;
    }

    public int getFaceValue {
        return faceValue;
    }
}