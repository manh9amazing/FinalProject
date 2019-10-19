package entities;

import bases.GameObject;

public class FlagBlockSpawner extends  GameObject {
    public FlagBlockSpawner (){
    }
    @Override
    public void run() {
        if (EventToggle.getInstance().FlagCapture && !FlagBlockSpawnerToggle.getInstance().Spawned){
            //random FlagBlock tai 2 map


            FlagBlockSpawnerToggle.getInstance().Spawned = true;
        }
    }
}
