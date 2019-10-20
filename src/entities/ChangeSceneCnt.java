package entities;

public class ChangeSceneCnt {
    public boolean SceneChanged;
    private static final ChangeSceneCnt INSTANCE = new ChangeSceneCnt();
    private ChangeSceneCnt(){
        this.SceneChanged = true;
    }
    public static ChangeSceneCnt getInstance(){
        return INSTANCE;
    }
}
