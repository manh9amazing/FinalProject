package entities;

import bases.*;

import java.awt.*;

public class Player2Spell extends GameObject {
    public Player2Spell() {
        this.ExistX = 2;
        this.ExistY = 2;
        this.Spell2ATK = 10;
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        this.position = new Vector2D();
        this.velocity.set(0, -20);
        this.boxCollider = new BoxCollider(this, 16, 16);
    }

    @Override
    public void render(Graphics g) {
        if(BuffToggleP2.getInstance().InvisibleBullet){
            this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_bullet.png");
        }
        else{
            this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        }
        super.render(g);
//        g.setColor(Color.RED);
//        g.drawString("ATK: " + this.Spell2ATK, 820, 430 );
    }

    @Override
    public void run() {
        if(MapState.getInstance().MapReverse){
            if (this.position.x <= 0 || this.position.x >= 800) {
                this.position.x = SpellClampX.clampX(this.position.x);
                this.position.y = 700 - this.position.y;
                this.ExistX--;
            }
        }
        else {
            if (this.position.x <= 0 || this.position.x >= 800) {
                this.position.x = SpellClampX.clampX(this.position.x);
                this.position.y = 700 - 30 - this.position.y;
                this.ExistX--;
            }
        }
        if (this.position.y <=0 || (this.position.y >=340 && this.position.y <=360) || this.position.y >=700 ){
            this.position.y = SpellClampY.clampY(this.position.y);
            this.velocity = ReverseMethod.reverse(this.velocity);
            this.ExistY--;
        }
        this.deActiveIfNeeded();
        Player1 player1 = GameObject.checkCollider(this, Player1.class);
        if (player1 != null ){
            if (BuffToggleP2.getInstance().PoisonousBullet){
                BuffToggle.getInstance().Poisoned = true;
            }

            if(!BuffToggleP2.getInstance().PiercingSpell) {
                if (player1.Armor <= 0) {
                    player1.HP -= this.Spell2ATK;
                } else {
                    player1.Armor -= this.Spell2ATK;
                }
                this.deActive();
            }
            else{
                player1.HP-= this.Spell2ATK;
                this.deActive();
            }
        }
        else{
//            System.out.println("ko phat hien");
        }

        Enemy2 enemy2 = GameObject.checkCollider(this, Enemy2.class);
        if (enemy2 != null ){
            enemy2.HP-= this.Spell2ATK;
            this.deActive();
            if (enemy2.HP<=0){
                enemy2.deActive();
                RewardCondition.getInstance().Enemy2Defeated= true;
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