package entities;

public class BuffToggleP2 {
    public int BuffNumber;

    public boolean Frozen;
    public boolean InstantHeal;
    public boolean Poisoned;
    public boolean PiercingSpell;
    public boolean Excaliburn;
    public boolean SupporterSummon;
    public boolean Berserk;
    public boolean ArmorUP;

    private static final BuffToggleP2 INSTANCE = new BuffToggleP2();

    private BuffToggleP2(){
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

    public static BuffToggleP2 getInstance(){
        //static ko this
        return INSTANCE;
    }
}
