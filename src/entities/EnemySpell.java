package entities;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;


public class EnemySpell extends GameObject {
    int spellDist = 2;
    double createAngle;

    public EnemySpell (){
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png");
        this.boxCollider = new BoxCollider(this, 16,16);
    }
    public void run(){
        this.deActiveIfNeeded();
        this.position.x -= spellDist*Math.cos(this.createAngle);
        this.position.y -= spellDist*Math.sin(this.createAngle);
        Player1 player1 = GameObject.checkCollider(this, Player1.class);
        if (player1 != null ){
            this.deActive();
            if (player1.Armor==0) {
                player1.HP--;
            }
            else{
                player1.Armor-=2;
            }
        }
        Player2 player2 = GameObject.checkCollider(this, Player2.class);
        if (player2 != null ){
            this.deActive();
            if (player2.Armor==0) {
                player2.HP--;
            }
            else{
                player2.Armor-=2;
            }
        }

    }

    public void deActiveIfNeeded(){
        if (this.position.y >600| this.position.y<0 | this.position.x <0 | this.position.x>770){
            deActive();
        }
    }

    @Override
    public void reset() {
        super.reset();
    }
}