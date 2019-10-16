package entities;

import bases.GameObject;

import java.util.Random;

public class EventRandomize {
    int EventChosen;
    public void run(){
        Random randomMachine = new Random();
        EventChosen = randomMachine.nextInt(EventToggle.getInstance().EventNumber);
        EventChosen = 2;
//        System.out.println(EventChosen);
        if(EventChosen ==0){
            EventToggle.getInstance().StandTogether = false;
            EnemySpawnerToggle.getInstance().Spawned = false;
           EventToggle.getInstance().Troll = true;
            GameObject.eventLogs.add("Troll");
        }
        if(EventChosen ==1){
            EventToggle.getInstance().StandTogether = false;
            EnemySpawnerToggle.getInstance().Spawned = false;
            EventToggle.getInstance().SuddenDeath= true;
            GameObject.eventLogs.add("SuddenDeath STARTING...");
        }
        if(EventChosen==2){
            EventToggle.getInstance().StandTogether = false;
            EnemySpawnerToggle.getInstance().Spawned = false;
            EventToggle.getInstance().StandTogether = true;
            GameObject.eventLogs.add("StandTogether STARTING...");
        }
        if(EventChosen==3){
            EventToggle.getInstance().StandTogether = false;
            EnemySpawnerToggle.getInstance().Spawned = false;
            EventToggle.getInstance().WorldExchange = true;
            MapState.getInstance().MapReverse = !MapState.getInstance().MapReverse;
            EventToggle.getInstance().WorldExchangeSubCnt = 0;
            GameObject.eventLogs.add("WorldExchange...");
        }
    }
}
