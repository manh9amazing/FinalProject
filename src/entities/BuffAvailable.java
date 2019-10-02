package entities;

import bases.FrameCounter;

import java.awt.*;

public class BuffAvailable {
    public boolean buffTime;
    public boolean buffActivated;
    private static final BuffAvailable INSTANCE = new BuffAvailable();
    private BuffAvailable(){
        this.buffTime = false;
    }


    public static BuffAvailable getInstance(){
        //static ko this
        return INSTANCE;
    }
}
