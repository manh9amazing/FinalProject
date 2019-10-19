package entities;

import bases.GameObject;

import java.util.Random;

public class FlagBlockSpawner extends  GameObject {
    public FlagBlockSpawner (){
    }
    @Override
    public void run() {
        if (EventToggle.getInstance().FlagCapture && !FlagBlockSpawnerToggle.getInstance().Spawned){
            //random FlagBlock tai 2 map
            this.FlagCaptured = 0;
            this.FlagCapturedP2 = 0;
            for (int i = 0 ; i<5; i++) {
                FlagBlock newFlagBLock = GameObject.recycle(FlagBlock.class);
                Random rd = new Random();
                int X = rd.nextInt(775);
                int Y = rd.nextInt(260);
                newFlagBLock.position.x = X;
                newFlagBLock.position.y = Y;
                newFlagBLock.redState = false;
                newFlagBLock.greenState = true;
                newFlagBLock.pointCounted = false;
            }
            for (int i = 0 ; i<5; i++) {
                FlagBlock newFlagBLock = GameObject.recycle(FlagBlock.class);
                Random rd = new Random();
                int X = rd.nextInt(775);
                int Y = rd.nextInt(640-365)+365;
                newFlagBLock.position.x = X;
                newFlagBLock.position.y = Y;
                newFlagBLock.redState = false;
                newFlagBLock.greenState = true;
                newFlagBLock.pointCounted = false;
            }
            FlagBlockSpawnerToggle.getInstance().Spawned = true;
//            RewardCondition.getInstance().PlayerFlagBonus = 0;
        }
    }
}
