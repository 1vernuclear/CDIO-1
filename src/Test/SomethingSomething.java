package Test;

public class SomethingSomething extends Introduktion {

    static int pointSumSpiller1 = 0;
    static int pointSumSpiller2 = 0;
    static int kastSum;

    public static void rulTerninger(){
        System.out.print("Slå med terningerne: ");
        input.next();
        valueDie1 = number.nextInt(6)+1;
        valueDie2 = number.nextInt(6)+1;
    }
    public static void setKastSum(){
        kastSum = getValueDie1() + getValueDie2();
    }
    public static int getKastSum(){
        return kastSum;
    }
    public static void setPointSumSpiller1(){
        pointSumSpiller1 += getKastSum();
    }
    public static int getPointSumSpiller1(){
        return pointSumSpiller1;
    }
    public static void setPointSumSpiller2(){
        pointSumSpiller2 += getKastSum();
    }
    public static int getPointSumSpiller2(){
        return pointSumSpiller2;
    }

    public static boolean getEns(){
        boolean bool = false;
        if(getValueDie1() == getValueDie2())
            bool = true;
        return bool;
    }

}
