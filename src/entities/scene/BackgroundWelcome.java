package entities.scene;

import bases.AudioUtils;
import bases.GameObject;
import bases.KeyPressed;
import bases.SpriteUtils;
import entities.ChangeSceneCnt;

import javax.sound.sampled.Clip;
import java.awt.*;

public class BackgroundWelcome extends GameObject {
    Clip clip;
    public BackgroundWelcome(){
        this.clip = AudioUtils.loadSound("assets/music/sound effects/op.wav");
        this.image = SpriteUtils.loadImage("assets/images/players/straight/welcomeScene.png");
    }

    @Override
    public void run() {
        AudioUtils.loopForever(clip);
        if (KeyPressed.getInstance().anyKeyPressed){
            ChangeSceneCnt.getInstance().SceneChanged = false;
            SceneManager.signNewScene(new GamePlayScene());
            AudioUtils.pause(clip);
        }
    }
}
