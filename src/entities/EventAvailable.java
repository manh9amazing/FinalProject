package entities;

import bases.FrameCounter;

import java.awt.*;

public class EventAvailable {
    public boolean eventTime;
    public boolean eventActivated;
    private static final EventAvailable INSTANCE = new EventAvailable();
    private EventAvailable(){
        this.eventTime = false;
    }


    public static EventAvailable getInstance(){
        //static ko this
        return INSTANCE;
    }
}
