package entities;

public class FlagBlockSpawnerToggle {
    public boolean Spawned;
    private static final FlagBlockSpawnerToggle INSTANCE = new FlagBlockSpawnerToggle();
    private FlagBlockSpawnerToggle(){
        this.Spawned = false;
    }
    public static FlagBlockSpawnerToggle getInstance(){
        return INSTANCE;
    }
}
