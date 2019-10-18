package entities;

public class BuffToggle {
    public int BuffNumber;

    public boolean Frozen;
    public boolean InstantHeal;
    public boolean Poisoned;
    public boolean PiercingSpell;
    public boolean Excaliburn;
    public boolean SupporterSummon;
    public boolean Berserk;
    public boolean ArmorUP;

    private static final BuffToggle INSTANCE = new BuffToggle();

    private BuffToggle(){
        this.BuffNumber = 8;

        this.Frozen = false;
        this.InstantHeal = false;
        this.Poisoned = false;
        this.PiercingSpell = false;
        this.Excaliburn = false;
        this.SupporterSummon = false;
        this.Berserk = false;
        this.ArmorUP = false;

    }

    public static BuffToggle getInstance(){
        //static ko this
        return INSTANCE;

    }
}
