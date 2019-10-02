package entities;

public class EventToggle {
    public int EventNumber;

    public boolean Troll;
    public boolean SuddenDeath;
    public boolean StandTogether;


    private static final EventToggle INSTANCE = new EventToggle();

    private EventToggle(){
        this.EventNumber = 3;

        this.Troll = false;
        this.SuddenDeath = false;
        this.StandTogether = false;


    }

    public static EventToggle getInstance(){
        //static ko this
        return INSTANCE;

    }
}
