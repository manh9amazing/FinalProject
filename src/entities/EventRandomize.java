package entities;

import bases.GameObject;

import java.util.Random;

public class EventRandomize {
    int EventChosen;
    public void run(){
        Random randomMachine = new Random();
        EventChosen = randomMachine.nextInt(EventToggle.getInstance().EventNumber);
        EventChosen = 1;
//        System.out.println(EventChosen);
        if(EventChosen ==0){
           EventToggle.getInstance().Troll = true;
            GameObject.eventLogs.add("Troll");
        }
        if(EventChosen ==1){
            EventToggle.getInstance().SuddenDeath= true;
            GameObject.eventLogs.add("SuddenDeath STARTING...");
        }
        if(EventChosen==2){
            EventToggle.getInstance().StandTogether = true;
            GameObject.eventLogs.add("StandTogether STARTING...");
        }

    }
}
