package Test;

import java.util.Scanner;

public class SomethingSomething extends Introduktion {
    private final Scanner input = new Scanner(System.in);
    int pointSumSpiller1 = 0;
    int pointSumSpiller2 = 0;
    int kastSum;

    public void rulTerninger(){
        System.out.print("Slå med terningerne: ");
        input.next();
        //valueDie1 = number.nextInt(6)+1;
        //valueDie2 = number.nextInt(6)+1;
    }
    public void setKastSum(){
        kastSum = getValueDie1() + getValueDie2();
    }
    public int getKastSum(){
        return kastSum;
    }
    public void setPointSumSpiller1(){
        pointSumSpiller1 += getKastSum();
    }
    public int getPointSumSpiller1(){
        return pointSumSpiller1;
    }
    public void setPointSumSpiller2(){
        pointSumSpiller2 += getKastSum();
    }
    public int getPointSumSpiller2(){
        return pointSumSpiller2;
    }

    public boolean getEns(){
        boolean bool = false;
        if(getValueDie1() == getValueDie2())
            bool = true;
        return bool;
    }

}
