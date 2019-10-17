package entities;

import bases.*;

import java.awt.*;

public class Player1 extends GameObject {
    FrameCounter frameCounter;
    FrameCounter reload;
    int faceDir;
    public Player1(){
        this.ReloadTime =100;
        this.Ammo = 6;
        this.MaxAmmo = 8;
//        this.ATK = 100;
        this.MaxHP =30;
        this.HP = 15;
        this.Armor = 5;
        this.image = SpriteUtils.loadImage("assets/images/players/straight/8.png");
        this.position = new Vector2D(200,200);
        this.boxCollider = new BoxCollider(this, 50, 50);
        frameCounter = new FrameCounter(20);
        reload = new FrameCounter(this.ReloadTime);
        this.velocity.set(0,0);
    }
    @Override
    public void render(Graphics g) {

        g.setColor(Color.RED);
        g.drawString("HP: " + this.HP + " / "+ this.MaxHP, 820, 50 );
        g.setColor(Color.RED);
        g.drawString("ATK: " + Player1Spell.Spell1ATK, 820, 80 );
        if(this.Armor>0){
            g.setColor(Color.YELLOW);
        g.drawString("ARMOR: " + this.Armor, 820, 110 );}
        else {
            this.Armor = 0;
            g.setColor(Color.YELLOW);
            g.drawString("ARMOR: BROKEN", 820,110 );
        }
        if (this.Ammo>0){
        g.setColor(Color.BLUE);
        g.drawString("AMMO: " + this.Ammo + " / "+ this.MaxAmmo, 820, 140 );}
        else{
            g.setColor(Color.BLUE);
            g.drawString("AMMO: RELOADING" , 820, 140 );
        }

        super.render(g);
    }
    @Override
    public void run() {
        if (RewardCondition.getInstance().Enemy1Defeated &&
                RewardCondition.getInstance().Enemy2Defeated &&
                EventToggle.getInstance().StandTogether){
            this.MaxHP +=250;
            this.HP+=200;
            this.Spell1ATK +=100;
            RewardCondition.getInstance().Enemy1Defeated=false;
            RewardCondition.getInstance().Enemy2Defeated=false;
            EventToggle.getInstance().StandTogether = false;
        }
        if(RewardCondition.getInstance().Enemy1Defeated &&
                !RewardCondition.getInstance().Enemy2Defeated &&
                !EventToggle.getInstance().StandTogether){
            this.MaxHP +=150;
            this.HP+=100;
            this.Spell1ATK += 50;
            RewardCondition.getInstance().Enemy1Defeated=false;
        }

        this.checkTroll();
        this.EventActivator();
        this.BuffActivator();
        if (!BuffToggle.getInstance().Frozen && !EventToggle.getInstance().Troll) {
            float vx = 0, vy = 0;
            if (KeyPressed.getInstance().upPressed) {
                vy -= 5;
                faceDir = 0;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/8.png");
            }
            if (KeyPressed.getInstance().downPressed) {
                vy += 5;
                faceDir = 1;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/9.png");
            }
            if (KeyPressed.getInstance().rightPressed) {
                vx += 5;
                faceDir = 2;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/10.png");
            }
            if (KeyPressed.getInstance().leftPressed) {
                vx -= 5;
                faceDir = 3;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/11.png");
            }

            if (this.Ammo > 0) {
                if (KeyPressed.getInstance().spacePressed && frameCounter.expired) {
                    this.castSpell();
                    this.Ammo--;
                    frameCounter.reset();
                } else {
                    frameCounter.run();
                }
            } else {
                if (reload.expired) {
                    this.Ammo = this.MaxAmmo;
                    reload.reset();
                } else {
                    reload.run();
                    frameCounter.run();
                }
            }
            if (MapState.getInstance().MapReverse){
                this.position.x = Utils.clamp(this.position.x, 0, 800 - this.image.getWidth(null));
                this.position.y = Utils.clamp(this.position.y, 370, 610);
            }
            else {
                this.position.x = Utils.clamp(this.position.x, 0, 800 - this.image.getWidth(null));
                this.position.y = Utils.clamp(this.position.y, 0, 270);
            }
            this.velocity.set(vx, vy);
            super.run();
        }

    }

    private void castSpell() {
        Player1Spell newSpell = GameObject.recycle(Player1Spell.class);
        newSpell.ExistX =2;
        newSpell.ExistY = 2;
//        Player1Spell newSpell = new Player1Spell();
        newSpell.position.set(this.position.x + this.image.getWidth(null)/2-9, this.position.y);
        if (faceDir == 0){
            newSpell.velocity.set(0,-5);
        }
        if (faceDir == 1){
            newSpell.velocity.set(0,5);
        }
        if (faceDir == 2){
            newSpell.velocity.set(5,0);
        }
        if (faceDir == 3){
            newSpell.velocity.set(-5,0);
        }

    }
}
