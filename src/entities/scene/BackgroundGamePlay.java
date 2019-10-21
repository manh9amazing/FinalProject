package entities.scene;

import bases.AudioUtils;
import bases.FrameCounter;
import bases.GameObject;
import entities.EventToggle;

import javax.sound.sampled.Clip;

public class BackgroundGamePlay extends GameObject {
    Clip bossMusic;
    Clip suddenDeath;
    Clip flagCapture;
    Clip invisible;

    FrameCounter soundWorld;
    public BackgroundGamePlay(){
        this.bossMusic = AudioUtils.loadSound("assets/music/sound effects/bossMusic.wav");
        this.suddenDeath = AudioUtils.loadSound("assets/music/sound effects/suddenDeath.wav");
        this.flagCapture = AudioUtils.loadSound("assets/music/sound effects/flagCapture.wav");
        this.invisible = AudioUtils.loadSound("assets/music/sound effects/invisible.wav");
    }

    @Override
    public void run() {
        if (EventToggle.getInstance().StandTogether){
            AudioUtils.play(bossMusic);
        }
        else {
            AudioUtils.pause(bossMusic);
        }

        if (EventToggle.getInstance().SuddenDeath){
            AudioUtils.play(suddenDeath);
        }
//        else {
//            AudioUtils.pause(suddenDeath);
//        }

        if (EventToggle.getInstance().FlagCapture){
            AudioUtils.play(flagCapture);
        }
        else {
            AudioUtils.pause(flagCapture);
        }

        if (EventToggle.getInstance().InvisibleBattle){
            AudioUtils.play(invisible);
        }

    }
}
