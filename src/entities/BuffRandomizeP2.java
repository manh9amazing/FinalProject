package entities;

import bases.GameObject;

import java.util.Random;

public class BuffRandomizeP2 {
    int BuffChosen;
    public void run(){
        Random randomMachine = new Random();
        BuffChosen = randomMachine.nextInt(BuffToggle.getInstance().BuffNumber);
        BuffChosen = 4;
//        System.out.println(BuffChosen);
        if(BuffChosen ==0){
            BuffToggleP2.getInstance().Poisoned = true;
            GameObject.player2Statuses.add("Poisoned");
        }
        if(BuffChosen ==1){
            BuffToggleP2.getInstance().InstantHeal = true;
            GameObject.player2Statuses.add("InstantHeal");
        }
        if(BuffChosen ==2){
            BuffToggleP2.getInstance().Frozen = true;
            GameObject.player2Statuses.add("Frozen");
        }
        if(BuffChosen ==3){
            BuffToggleP2.getInstance().PiercingSpell = true;
            GameObject.player2Statuses.add("PiercingSpell");
        }
        if(BuffChosen ==4){
            BuffToggleP2.getInstance().Excaliburn = true;
            GameObject.player2Statuses.add("Excaliburn");
        }
    }
}
