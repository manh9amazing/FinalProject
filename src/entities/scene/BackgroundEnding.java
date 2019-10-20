package entities.scene;

import bases.GameObject;
import bases.KeyPressed;
import bases.SpriteUtils;
import entities.MatchResult;

public class BackgroundEnding extends GameObject {
    public BackgroundEnding() {
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
        if (KeyPressed.getInstance().anyKeyPressed){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SceneManager.signNewScene(new GameWelcomeScene());
        }
    }
}
