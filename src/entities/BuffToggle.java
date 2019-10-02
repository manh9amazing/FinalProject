package entities;

public class BuffToggle {
    public int BuffNumber;

    public boolean Frozen;
    public boolean InstantHeal;
    public boolean Poisoned;

    private static final BuffToggle INSTANCE = new BuffToggle();

    private BuffToggle(){
        this.BuffNumber = 2;

        this.Frozen = false;
        this.InstantHeal = false;
        this.Poisoned = false;
    }

    public static BuffToggle getInstance(){
        //static ko this
        return INSTANCE;
    }
}
