package entities;

import bases.*;

import java.awt.*;

public class Supporter2 extends GameObject {
    FrameCounter frameCounter;
    FrameCounter reload;
    int faceDir;
    public  int Supporter2velocityX;
    public  int Supporter2velocityY;
    public Supporter2(){
        this.ReloadTime =100;
        this.Ammo = 7;
        this.MaxAmmo =10;
        this.Armor = 9;
//        this.ATK = 100;
        this.MaxHP =30;
        this.HP = 10;
        this.image = SpriteUtils.loadImage("assets/images/players/straight/sp2_01.png");
        this.position = new Vector2D(650,650);
        this.boxCollider = new BoxCollider(this, 27, 27);
        frameCounter = new FrameCounter(20);
        reload = new FrameCounter(this.ReloadTime);
        this.velocity.set(0,0);
        this.Supporter2velocityX = 0;
        this.Supporter2velocityY = 0;

    }
    @Override
    public void render(Graphics g) {
        super.render(g);
    }
    @Override
    public void run() {
        this.checkTroll();
        this.EventActivator();
        this.BuffActivatorP2();
        if (!BuffToggleP2.getInstance().Frozen && !EventToggle.getInstance().Troll) {
            float vx = 0, vy = 0;
            if (KeyPressed.getInstance().wPressed) {
                vy += Supporter2velocityY;
                faceDir = 1;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/sp2_02.png");
            }
            if (KeyPressed.getInstance().sPressed) {
                vy -= Supporter2velocityY;
                faceDir = 0;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/sp2_01.png");
            }
            if (KeyPressed.getInstance().dPressed) {
                vx -= Supporter2velocityX;
                faceDir = 3;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/sp2_03.png");
            }
            if (KeyPressed.getInstance().aPressed) {
                vx += Supporter2velocityX;
                faceDir = 2;
                this.image = SpriteUtils.loadImage("assets/images/players/straight/sp2_04.png");
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
                this.position.y = Utils.clamp(this.position.y, 0, 270);
            }
            else {
                this.position.x = Utils.clamp(this.position.x, 0, 800 - this.image.getWidth(null));
                this.position.y = Utils.clamp(this.position.y, 370, 610);
            }
            this.velocity.set(vx, vy);
            super.run();
        }

    }

    private void castSpell() {
        Player2Spell newSpell = GameObject.recycle(Player2Spell.class);
        newSpell.ExistX =2;
        newSpell.ExistY = 2;
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
