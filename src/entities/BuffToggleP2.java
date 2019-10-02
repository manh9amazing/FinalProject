package entities;

public class BuffToggleP2 {
    public int BuffNumber;

    public boolean Frozen;
    public boolean InstantHeal;
    public boolean Poisoned;
    public boolean PiercingSpell;
    public boolean Excaliburn;

    private static final BuffToggleP2 INSTANCE = new BuffToggleP2();

    private BuffToggleP2(){
        this.BuffNumber = 5;

        this.Frozen = false;
        this.InstantHeal = false;
        this.Poisoned = false;
        this.PiercingSpell = false;
        this.Excaliburn = false;
    }

    public static BuffToggleP2 getInstance(){
        //static ko this
        return INSTANCE;
    }
}