package entities.scene;

import bases.AudioUtils;
import bases.GameObject;
import bases.KeyPressed;
import bases.SpriteUtils;
import entities.MatchResult;

import javax.sound.sampled.Clip;

public class BackgroundEnding extends GameObject {
    Clip clip;
    public BackgroundEnding() {
        this.clip = AudioUtils.loadSound("assets/music/sound effects/ending.wav");
        if (MatchResult.getInstance().YellowWin){
            this.image = SpriteUtils.loadImage("assets/images/players/straight/yellow_win.png");
        }
        if (MatchResult.getInstance().GreenWin){
            this.image = SpriteUtils.loadImage("assets/images/players/straight/green_win.png");
        }
    }
    @Override
    public void run() {
        //c2 frameCounter
        AudioUtils.pause(bossMusic);
        AudioUtils.loopForever(clip);
        if (KeyPressed.getInstance().anyKeyPressed){
            AudioUtils.pause(clip);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SceneManager.signNewScene(new GameWelcomeScene());
        }
    }
}
