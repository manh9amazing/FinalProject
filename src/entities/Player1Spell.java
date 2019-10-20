package entities;

import bases.*;

import java.awt.*;

public class Player1Spell extends GameObject {
    public Player1Spell() {
        this.ExistX = 2;
        this.ExistY = 2;
        this.Spell1ATK = 25;
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.position = new Vector2D();
        this.velocity.set(0, -20);
        this.boxCollider = new BoxCollider(this, 16, 16);
    }

    @Override
    public void render(Graphics g) {
        if(BuffToggle.getInstance().InvisibleBullet){
            this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_bullet.png");
        }
        else{
            this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        }
        super.render(g);
//        g.setColor(Color.RED);
//        g.drawString("ATK: " + this.Spell1ATK, 820, 80 );
    }

    @Override
    public void run() {
        if (MapState.getInstance().MapReverse){
            if (this.position.x<=0 || this.position.x >=800){
                this.position.x = SpellClampX.clampX(this.position.x);
                this.position.y = 700 -30- this.position.y;
                this.ExistX--;
            }
        }
        else {
            if (this.position.x <= 0 || this.position.x >= 800) {
                this.position.x = SpellClampX.clampX(this.position.x);
                this.position.y = 700 - this.position.y;
                this.ExistX--;
            }
        }


        if (this.position.y <=0 || (this.position.y >=340 && this.position.y <=360) || this.position.y >=700 ){
            this.position.y = SpellClampY.clampY(this.position.y);
            this.velocity = ReverseMethod.reverse(this.velocity);
            this.ExistY--;
        }
        this.deActiveIfNeeded();
        Player2 player2 = GameObject.checkCollider(this, Player2.class);
        if (player2 != null ){
            if (BuffToggle.getInstance().PoisonousBullet){
                BuffToggleP2.getInstance().Poisoned = true;
            }
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

        Enemy enemy = GameObject.checkCollider(this, Enemy.class);
        if (enemy != null ){
                enemy.HP-= this.Spell1ATK;
                this.deActive();
                if (enemy.HP<=0){
                    enemy.deActive();
                    RewardCondition.getInstance().Enemy1Defeated= true;
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