package entities;

public class BuffToggle {
    public int BuffNumber;

    public boolean Frozen;
    public boolean InstantHeal;
    public boolean Poisoned;
    public boolean PiercingSpell;
    public boolean Excaliburn;

    private static final BuffToggle INSTANCE = new BuffToggle();

    private BuffToggle(){
        this.BuffNumber = 5;

        this.Frozen = false;
        this.InstantHeal = false;
        this.Poisoned = false;
        this.PiercingSpell = false;
        this.Excaliburn = false;
    }

    public static BuffToggle getInstance(){
        //static ko this
        return INSTANCE;

    }
}
