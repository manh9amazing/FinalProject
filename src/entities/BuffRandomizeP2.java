package entities;

import bases.GameObject;

import java.util.Random;

public class BuffRandomizeP2 {
    int BuffChosen;
    public void run(){
        Random randomMachine = new Random();
        BuffChosen = randomMachine.nextInt(BuffToggle.getInstance().BuffNumber);
//        BuffChosen = 0;
//        System.out.println(BuffChosen);
        if(BuffChosen ==0){
            BuffToggleP2.getInstance().Poisoned = true;
            GameObject.player2Statuses.add("Poisoned");
            String newDescription = "Lose one health @ every specific @ amount of time";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescriptionP2.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if(BuffChosen ==1){
            BuffToggleP2.getInstance().InstantHeal = true;
            GameObject.player2Statuses.add("InstantHeal");
            String newDescription = "Increase a large @ amount of health @ in just a second";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescriptionP2.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if(BuffChosen ==2){
            BuffToggleP2.getInstance().Frozen = true;
            GameObject.player2Statuses.add("Frozen");
            String newDescription = "You cant move @ in seconds @ just that...";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescriptionP2.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if(BuffChosen ==3){
            BuffToggleP2.getInstance().PiercingSpell = true;
            GameObject.player2Statuses.add("PiercingSpell");
            String newDescription = "Your spell can  @ break through armor @ and minus directly to HP";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescriptionP2.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if(BuffChosen ==4){
            BuffToggleP2.getInstance().Excaliburn = true;
            GameObject.player2Statuses.add("Excaliburn");
            String newDescription = "HUGE SPELL  @ Nothing else @ ";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescriptionP2.add(arrOfStr[arrOfStr.length - i]);
            }
        }

    }
}
