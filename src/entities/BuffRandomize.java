package entities;

import bases.GameObject;

import java.util.Random;

public class BuffRandomize {
    int BuffChosen;
    public void run(){
        Random randomMachine = new Random();
        BuffChosen = randomMachine.nextInt(BuffToggle.getInstance().BuffNumber);
        BuffChosen = 4;
//        System.out.println(BuffChosen);
        if(BuffChosen ==0){
            BuffToggle.getInstance().Poisoned = true;
            GameObject.player1Statuses.add("Poisoned");
        }
        if(BuffChosen ==1){
            BuffToggle.getInstance().InstantHeal = true;
            GameObject.player1Statuses.add("InstantHeal");
        }
        if(BuffChosen ==2){
            BuffToggle.getInstance().Frozen = true;
            GameObject.player1Statuses.add("Frozen");
        }
        if(BuffChosen ==3){
            BuffToggle.getInstance().PiercingSpell = true;
            GameObject.player1Statuses.add("PiercingSpell");
        }
        if(BuffChosen ==4){
            BuffToggle.getInstance().Excaliburn = true;
            GameObject.player1Statuses.add("Excaliburn");
        }
    }
}
