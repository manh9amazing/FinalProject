package entities;

import bases.*;

import java.awt.*;

public class Player1Spell extends GameObject {
    public Player1Spell() {
        this.ExistX = 2;
        this.ExistY = 2;
        this.Spell1ATK = 1;
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.position = new Vector2D();
        this.velocity.set(0, -20);
        this.boxCollider = new BoxCollider(this, 24, 24);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
//        g.setColor(Color.RED);
//        g.drawString("ATK: " + this.Spell1ATK, 820, 80 );
    }

    @Override
    public void run() {

        if (this.position.x<=0 || this.position.x >=800){
            this.position.x = SpellClampX.clampX(this.position.x);
            this.position.y = 700 - this.position.y;
            this.ExistX--;
        }
        if (this.position.y <=0 || (this.position.y >=340 && this.position.y <=360) || this.position.y >=700 ){
            this.position.y = SpellClampY.clampY(this.position.y);
            this.velocity = ReverseMethod.reverse(this.velocity);
            this.ExistY--;
        }
        this.deActiveIfNeeded();
        Player2 player2 = GameObject.checkCollider(this, Player2.class);
        if (player2 != null ){
            if (!BuffToggle.getInstance().PiercingSpell) {
                if (player2.Armor <= 0) {
                    player2.HP -= this.Spell1ATK;
                } else {
                    player2.Armor -= this.Spell1ATK;
                }
                this.deActive();
            }
            else{
                player2.HP -= this.Spell1ATK;
                this.deActive();
            }
        }
        super.run();
    }


    public void deActiveIfNeeded() {
        if (this.ExistX == 0 || this.ExistY == 0) {
            this.deActive();
        }
    }

    @Override
    public void deActive() {
        super.deActive();
    }
}