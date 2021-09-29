package Spil;
import java.util.Random;

public class Die {
    private Random random = new Random();
    private int faceValue, numberOfSides;

    public Die (int sides){
        numberOfSides = sides;
    }

    public Die() {
        numberOfSides = 6;
    }

    public void rollDie() {
        faceValue = random.nextInt(numberOfSides)+1;
    }

    public void setFaceValue(int value) {
        faceValue = value;
    }

    public int getFaceValue(){
        return faceValue;
    }
}