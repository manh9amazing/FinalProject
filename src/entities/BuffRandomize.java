package entities;

import java.util.Random;

public class BuffRandomize {
    int BuffChosen;
    public void run(){
        Random randomMachine = new Random();
        BuffChosen = randomMachine.nextInt(BuffToggle.getInstance().BuffNumber);
        BuffChosen = 0;
//        System.out.println(BuffChosen);
        if(BuffChosen ==0){
            BuffToggle.getInstance().Poisoned = true;
        }
        if(BuffChosen ==1){
            BuffToggle.getInstance().InstantHeal = true;
        }
        if(BuffChosen ==2){
            BuffToggle.getInstance().Frozen = true;
        }
    }
}
