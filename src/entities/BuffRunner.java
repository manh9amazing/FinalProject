package entities;

import bases.FrameCounter;

import java.awt.*;

public class BuffRunner {
    FrameCounter buffTimeComing;
    FrameCounter littleDelay;
    public BuffRunner(){
        this.buffTimeComing = new FrameCounter(100);
        this.littleDelay = new FrameCounter(50);
    }

    public void run() {
        if(buffTimeComing.expired){
            if(littleDelay.expired){
                BuffAvailable.getInstance().buffTime = false;
                littleDelay.reset();
                buffTimeComing.reset();
            }
            else {
                littleDelay.run();
                buffTimeComing.run();
                BuffAvailable.getInstance().buffTime = true;
            }
        }
        else{
            buffTimeComing.run();
        }
    }
}
