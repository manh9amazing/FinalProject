package entities;

import bases.GameObject;

import java.util.Random;

public class EventRandomize {
    int EventChosen;
    public void run(){
        Random randomMachine = new Random();
        EventChosen = randomMachine.nextInt(EventToggle.getInstance().EventNumber);
//        EventChosen = 5;
//        System.out.println(EventChosen);
        if(EventChosen ==0){
            EventToggle.getInstance().Troll = true;
            GameObject.eventLogs.add("Troll ");
        }
        if(EventChosen ==1){

            EventToggle.getInstance().SuddenDeath= true;
            GameObject.eventLogs.add("SuddenDeath ");
        }
        if(EventChosen==2){
            RewardCondition.getInstance().Enemy1Defeated=false;
            RewardCondition.getInstance().Enemy2Defeated=false;
            RewardCondition.getInstance().PlayerGivenBonus = 0;
            EventToggle.getInstance().StandTogether = true;
            GameObject.eventLogs.add("StandTogether ");
        }
        if(EventChosen==3){
            EventToggle.getInstance().WorldExchange = true;
            MapState.getInstance().MapReverse = !MapState.getInstance().MapReverse;
            EventToggle.getInstance().WorldExchangeSubCnt = 0;
            GameObject.eventLogs.add("WorldExchange ");
        }
        if(EventChosen==4){
            EventToggle.getInstance().FlagCapture = true;
            GameObject.eventLogs.add("FlagCapture ");
        }
        if(EventChosen==5){
            EventToggle.getInstance().Blessings = true;
            GameObject.eventLogs.add("Blessings ");
        }
        if(EventChosen==6){
            EventToggle.getInstance().InvisibleBattle = true;
            GameObject.eventLogs.add("InvisibleBattle ");
        }

    }
}
