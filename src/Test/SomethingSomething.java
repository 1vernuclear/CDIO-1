package Test;

public class SomethingSomething extends EnEllerAndenKlasse{

    public void setSum(int værdiKast){
        int setSum = 0;
        setSum += værdiKast;
    }
    public int getSum(int setSum){
        return setSum;
    }
    public int dieValue(int terning1,int terning2){
        int dieValue = terning1 + terning2;
        return dieValue;
    }
    public boolean getEns(int terning1,int terning2){
        boolean bool = false;
        if(terning1 == terning2)
            bool = true;
        return bool;
    }

}
