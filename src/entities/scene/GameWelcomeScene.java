package entities.scene;

import bases.GameObject;

public class GameWelcomeScene extends Scene {
    @Override
    public void init() {
        BackgroundWelcome backgroundWelcome = new BackgroundWelcome();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
