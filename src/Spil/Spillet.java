package Spil;
import Test.*;

public class Spillet extends SomethingSomething {
    public static void main(String[] args) {
        //Spillerne indtaster deres ig names for den resterende del af spillet
        setName1();
        setName2();
        //Halv intro til spil + slå om at starte
        Introduktion.slåOmStart();

        while(getPointSumSpiller1() < 40 && getPointSumSpiller2() < 40){
            int i = 1;
            while(i < 3){
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                rulTerninger();
                setKastSum();
                if(i % 2 == 0){
                    System.out.print(getName2() + " har slået " + getValueDie1() + " og " + getValueDie2());
                    System.out.print(" og scorer dermed " + getKastSum() + " point." + "\n");
                    setPointSumSpiller2();
                    System.out.println(getName2() + " har nu en score på: " + getPointSumSpiller2());
                    if(getEns()){
                        System.out.println("Fordi du slog 2 ens må du slå igen.");
                        i--;
                    }
                }else{
                    System.out.print(getName1() + " har slået " + getValueDie1() + " og " + getValueDie2());
                    System.out.print(" og scorer dermed " + getKastSum() + " point." + "\n");
                    setPointSumSpiller1();
                    System.out.println(getName1() + " har nu en score på: " + getPointSumSpiller1());
                    if(getEns()){
                        System.out.println("Fordi du slog 2 ens må du slå igen.");
                        i--;
                    }
                }
                i++;
            }

        }
    }
}
