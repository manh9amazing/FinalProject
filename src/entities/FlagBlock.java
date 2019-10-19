package entities;

import bases.GameObject;
import bases.SpriteUtils;

import java.awt.*;

public class FlagBlock extends GameObject {
    public boolean redState;
    public boolean greenState;
    public FlagBlock(){
        this.image = SpriteUtils.loadImage("");
        this.redState = false;
        this.greenState = true;
    }

    @Override
    public void render(Graphics g) {
        if (this.redState){
            this.image = SpriteUtils.loadImage("");
        }
        if (this.greenState){
            this.image = SpriteUtils.loadImage("");
        }
        super.render(g);
    }

    @Override
    public void run() {
        this.deActiveIfNeeded();
        Player1 player1 = GameObject.checkCollider(this, Player1.class);
        if (player1 != null ){
            if (this.position.x >=  player1.position.x &&
                    this.position.x <= player1.position.x + this.image.getWidth(null)&&
                this.position.y >= player1.position.y &&
                    this.position.y <= player1.position.y + this.image.getHeight(null)){
                this.redState = true;
                this.greenState = false;
            }
        }
        Player2 player2 = GameObject.checkCollider(this, Player2.class);
        if (player2 != null ){
            if (this.position.x >=  player2.position.x &&
                    this.position.x <= player2.position.x + this.image.getWidth(null)&&
                    this.position.y >= player2.position.y &&
                    this.position.y <= player2.position.y + this.image.getHeight(null)){
                this.redState = true;
                this.greenState = false;
            }
        }
    }

    public void deActiveIfNeeded(){
        if (!EventToggle.getInstance().FlagCapture){
            this.deActive();
        }
    }
}
