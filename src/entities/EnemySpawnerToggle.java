package entities;

public class EnemySpawnerToggle {
    public boolean Spawned;
    private static final EnemySpawnerToggle INSTANCE = new EnemySpawnerToggle();
    private EnemySpawnerToggle(){
        this.Spawned = false;
    }
    public static EnemySpawnerToggle getInstance(){
        return INSTANCE;
    }
}
