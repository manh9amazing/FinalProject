package entities;

import bases.GameObject;

import java.util.Random;

public class BuffRandomize {
    int BuffChosen;
    public void run() {
        Random randomMachine = new Random();
        BuffChosen = randomMachine.nextInt(BuffToggle.getInstance().BuffNumber);
        BuffChosen = 7;
//        System.out.println(BuffChosen);
        if (BuffChosen == 0) {
            BuffToggle.getInstance().Poisoned = true;
            GameObject.player1Statuses.add("Poisoned");
            String newDescription = "Lose one health @every specific @amount of time@";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if (BuffChosen == 1) {
            BuffToggle.getInstance().InstantHeal = true;
            GameObject.player1Statuses.add("InstantHeal");
            String newDescription = "Increase a large @amount of health @in just a second@";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if (BuffChosen == 2) {
            BuffToggle.getInstance().Frozen = true;
            GameObject.player1Statuses.add("Frozen");
            String newDescription = "You cant move @in seconds @just that...@";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if (BuffChosen == 3) {
            BuffToggle.getInstance().PiercingSpell = true;
            GameObject.player1Statuses.add("PiercingSpell");
            String newDescription = "Your spell can  @break through @armor and minus @directly to HP";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if (BuffChosen == 4) {
            BuffToggle.getInstance().Excaliburn = true;
            GameObject.player1Statuses.add("Excaliburn");
            String newDescription = "HUGE SPELL  @Nothing else @ @ ";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }

        if (BuffChosen == 5){
            BuffToggle.getInstance().SupporterSummon = true;
            GameObject.player1Statuses.add("SupporterSummon");
            String newDescription = "Hey you have @a NEW friend @ @";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }

        if (BuffChosen == 6){
            BuffToggle.getInstance().Berserk = true;
            GameObject.player1Statuses.add("Berserk");
            String newDescription = "Sacrifice your HP @for devastating ATK @CHARGE!!!@";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }

        if (BuffChosen == 7){
            BuffToggle.getInstance().ArmorUP = true;
            GameObject.player1Statuses.add("ArmorUP");
            String newDescription = "Who likes @more Armor? @You?@";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }

        if (BuffChosen == 8){
            BuffToggle.getInstance().PoisonousBullet = true;
            GameObject.player1Statuses.add("PoisonousBullet");
            String newDescription = "Your bullets have @err..... @POISON@";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }
        if (BuffChosen == 9){
            BuffToggle.getInstance().InvisibleBullet = true;
            GameObject.player1Statuses.add("InvisibleBullet");
            String newDescription = "Enemy cant see @your bullets @Hahaha!!!@";
            String[] arrOfStr = newDescription.split("@", 5);
            for (int i = 1; i < arrOfStr.length + 1; i++) {
                GameObject.buffDescription.add(arrOfStr[arrOfStr.length - i]);
            }
        }
    }
}
