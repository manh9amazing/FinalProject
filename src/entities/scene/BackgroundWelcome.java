package entities.scene;

import bases.GameObject;
import bases.KeyPressed;
import bases.SpriteUtils;
import entities.ChangeSceneCnt;

import java.awt.*;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome(){
        this.image = SpriteUtils.loadImage("assets/images/players/straight/welcomeScene.png");
    }

    @Override
    public void run() {
        if (KeyPressed.getInstance().anyKeyPressed){
            ChangeSceneCnt.getInstance().SceneChanged = false;
            SceneManager.signNewScene(new GamePlayScene());
        }
    }
}
