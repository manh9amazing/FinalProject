package entities;

import bases.FrameCounter;
import entities.EventAvailable;
import entities.EventToggle;

import java.awt.*;

public class EventRunner {
    FrameCounter eventTimeComing;
    FrameCounter littleDelay;
    public EventRunner (){
        this.eventTimeComing = new FrameCounter(500);
        this.littleDelay = new FrameCounter(50);
    }

    public void run() {
        if(eventTimeComing.expired){
            if(littleDelay.expired){
                EventAvailable.getInstance().eventTime = false;
                littleDelay.reset();
                eventTimeComing.reset();
            }
            else {
                littleDelay.run();
                eventTimeComing.run();
                EventAvailable.getInstance().eventTime = true;
            }
        }
        else{
            eventTimeComing.run();
        }
    }
}
