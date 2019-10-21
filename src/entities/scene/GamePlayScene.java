package entities.scene;

import bases.AudioUtils;
import bases.GameObject;
import bases.SpriteUtils;
import entities.*;

import javax.sound.sampled.Clip;
import java.awt.*;

public class GamePlayScene extends Scene{
    public BackgroundGamePlay backgroundGamePlay;

    Image troll;
    Image trollMessage;
    Image test;

    Player1 player1;
    Player1Spell player1Spell;
    Player2 player2;
    Player2Spell player2Spell;
    Supporter1Spawner supporter1Spawner;
    Supporter2Spawner supporter2Spawner;
    //    Enemy enemy;
    EnemySpawner enemySpawner;
    FlagBlockSpawner flagBlockSpawner;

    BuffAvailable buffNotiAndCnt;
    @Override
    public void init() {
        this.player1 = new Player1();
        this.player1Spell = new Player1Spell();
        this.player2 = new Player2();
        this.player2Spell = new Player2Spell();
        this.supporter1Spawner = new Supporter1Spawner();
        this.supporter2Spawner = new Supporter2Spawner();
        this.enemySpawner = new EnemySpawner();
        this.flagBlockSpawner = new FlagBlockSpawner();
        BackgroundGamePlay backgroundGamePlay = new BackgroundGamePlay();
        MatchResult.getInstance().GreenWin = false;
        MatchResult.getInstance().YellowWin = false;
    }

    @Override
    public void clear() {
//        AudioUtils.pause(backgroundGamePlay.bossMusic);
        GameObject.clear();
    }
}
