package entities;

public class EventToggle {
    public int EventNumber;

    public boolean Troll;
    public boolean SuddenDeath;
    public boolean StandTogether;
    public boolean WorldExchange;
    public boolean FlagCapture;
    public boolean Blessings;
    public boolean InvisibleBattle;
    public int WorldExchangeSubCnt;
    public int BlessingsSubCnt;

    private static final EventToggle INSTANCE = new EventToggle();

    private EventToggle(){
        this.EventNumber = 7;

        this.Troll = false;
        this.SuddenDeath = false;
        this.StandTogether = false;
        this.WorldExchange = false;
        this.FlagCapture = false;
        this.Blessings = false;
        this.InvisibleBattle = false;
        this.WorldExchangeSubCnt = 0;
        this.BlessingsSubCnt = 0;


    }

    public static EventToggle getInstance(){
        //static ko this
        return INSTANCE;

    }
}
