package entities;

public class EventToggle {
    public int EventNumber;

    public boolean Troll;
    public boolean SuddenDeath;
    public boolean StandTogether;
    public boolean WorldExchange;
    public boolean FlagCapture;
    public int WorldExchangeSubCnt;


    private static final EventToggle INSTANCE = new EventToggle();

    private EventToggle(){
        this.EventNumber = 5;

        this.Troll = false;
        this.SuddenDeath = false;
        this.StandTogether = false;
        this.WorldExchange = false;
        this.FlagCapture = false;
        this.WorldExchangeSubCnt = 0;


    }

    public static EventToggle getInstance(){
        //static ko this
        return INSTANCE;

    }
}
