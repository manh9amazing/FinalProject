package entities;

import bases.*;

import java.awt.*;

public class Supporter1 extends GameObject {
    FrameCounter frameCounter;
    FrameCounter reload;
    int faceDir;
    public  int Supporter1velocityX;
    public  int Supporter1velocityY;
    public Supporter1(){
        this.ReloadTime =100;
        this.Ammo = 6;
        this.MaxAmmo = 8;
//        this.ATK = 100;
        this.MaxHP =30;
        this.HP = 15;
        this.Armor = 5;
        this.image = SpriteUtils.loadImage("assets/images/players/straight/sp1_01.png");
        this.position = new Vector2D(100,100);
        this.boxCollider = new BoxCollider(this, 27, 27);
        frameCounter = new FrameCounter(20);
        reload = new FrameCounter(this.ReloadTime);
        this.velocity.set(0,0);
        this.Supporter1velocityX = 0;
        this.Supporter1velocityY = 0;

    }
    @Override
    public void render(Graphics g) {
        super.render(g);
    }
    @Override
    public void run() {
        this.checkTroll();
        this.EventActivator();
        this.BuffActivator();
        if (!BuffToggle.getInstance().Frozen && !EventToggle.getInstance().Troll) {
            float vx = 0, vy = 0;
            if (KeyPressed.getInstance().upPressed) {
                vy += Supporter1velocityY;
                faceDir = 1;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/sp1_02.png");
            }
            if (KeyPressed.getInstance().downPressed) {
                vy -= Supporter1velocityY;
                faceDir = 0;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/sp1_01.png");
            }
            if (KeyPressed.getInstance().rightPressed) {
                vx -= Supporter1velocityX;
                faceDir = 3;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/sp1_03.png");
            }
            if (KeyPressed.getInstance().leftPressed) {
                vx += Supporter1velocityX;
                faceDir = 2;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/sp1_04.png");
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
