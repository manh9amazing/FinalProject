package entities;

import bases.GameObject;

public class FlagBlockSpawner extends  GameObject {
    public FlagBlockSpawner (){
    }
    @Override
    public void run() {
        if (EventToggle.getInstance().FlagCapture && !FlagBlockSpawnerToggle.getInstance().Spawned){
            //random FlagBlock tai 2 map

            this.FlagCaptured = 0;
//            System.out.println(this.FlagCaptured);
            this.FlagCapturedP2 = 0;

            FlagBlock newFlagBLock= GameObject.recycle(FlagBlock.class);
            newFlagBLock.redState = false;
            newFlagBLock.greenState = true;
            FlagBlockSpawnerToggle.getInstance().Spawned = true;
        }
    }
}
