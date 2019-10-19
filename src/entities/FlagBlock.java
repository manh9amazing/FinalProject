package entities;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

import java.awt.*;

public class FlagBlock extends GameObject {
    public boolean redState;
    public boolean greenState;
    public boolean pointCounted;

    public FlagBlock(){
        this.image = SpriteUtils.loadImage("assets/images/players/straight/greenState.png");
        this.position = new Vector2D(775,290);
        //775,640-365-260;
        this.boxCollider = new BoxCollider(this, 25, 25);
        this.redState = false;
        this.greenState = true;
        this.pointCounted = false;
    }

    @Override
    public void render(Graphics g) {
        if (this.redState){
            this.image = SpriteUtils.loadImage("assets/images/players/straight/redState.png");
        }
        if (this.greenState){
            this.image = SpriteUtils.loadImage("assets/images/players/straight/greenState.png");
        }
        super.render(g);
    }


    public void run() {
        this.deActiveIfNeeded();
        Player1 player1 = GameObject.checkCollider(this, Player1.class);
        if (player1 != null ){
            if (this.position.x >=  player1.position.x &&
                    this.position.x <= player1.position.x + this.image.getWidth(null)&&
                this.position.y >= player1.position.y &&
                    this.position.y <= player1.position.y + this.image.getHeight(null)){
                if(!this.pointCounted) {
                    this.FlagCaptured++;
                    this.pointCounted = true;
                }
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

                if(!this.pointCounted) {
                    this.FlagCapturedP2++;
                    this.pointCounted = true;
                }
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
