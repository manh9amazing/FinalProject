package entities;

public class RewardCondition {
    public boolean Enemy1Defeated;
    public boolean Enemy2Defeated;
    public int PlayerGivenBonus;
    public int PlayerFlagBonus;
    private static final RewardCondition INSTANCE = new RewardCondition();
    private RewardCondition(){
        this.Enemy1Defeated = false;
        this.Enemy2Defeated = false;
        this.PlayerGivenBonus = 0;
        this.PlayerFlagBonus = 0;
    }
    public static RewardCondition getInstance(){
        return INSTANCE;
    }
}
