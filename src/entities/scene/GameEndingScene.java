package entities.scene;

import bases.GameObject;

public class GameEndingScene extends  Scene{
    @Override
    public void init() {
        BackgroundEnding backgroundEnding = new BackgroundEnding();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
