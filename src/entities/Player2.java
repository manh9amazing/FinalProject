package entities;

import bases.*;

import java.awt.*;

public class Player2 extends GameObject {
    FrameCounter frameCounter;
    FrameCounter reload;
    int faceDir;
    public Player2(){
        this.ReloadTime =100;
        this.Ammo = 7;
        this.MaxAmmo =10;
        this.Armor = 9;
//        this.ATK = 100;
        this.MaxHP =30;
        this.HP = 30;
        this.image = SpriteUtils.loadImage("assets/images/players/straight/12.png");
        this.position = new Vector2D(500,500);
        this.boxCollider = new BoxCollider(this, 50, 50);
        frameCounter = new FrameCounter(20);
        reload = new FrameCounter(this.ReloadTime);
        this.velocity.set(0,0);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("HP: " + this.HP + " / "+ this.MaxHP, 820, 400 );
        g.setColor(Color.RED);
        g.drawString("ATK: " + Player1Spell.Spell2ATK, 820, 430 );
        if (this.Armor > 0) {
            g.setColor(Color.YELLOW);
            g.drawString("ARMOR: " + this.Armor, 820, 460 );
        }
        else{
            g.setColor(Color.YELLOW);
            g.drawString("ARMOR: BROKEN" , 820, 460 );
        }
        if (this.Ammo>0){
            g.setColor(Color.BLUE);
            g.drawString("AMMO: " + this.Ammo + " / "+ this.MaxAmmo, 820, 490 );}
        else{
            g.setColor(Color.BLUE);
            g.drawString("AMMO: RELOADING" , 820, 490 );
        }
        super.render(g);
    }
    @Override
    public void run() {
        float vx=0 , vy=0;
        if (KeyPressed.getInstance().wPressed){
            vy-=5;
            faceDir = 0;
            this.image = SpriteUtils.loadImage("assets/images/players/straight/12.png");
        }
        if (KeyPressed.getInstance().sPressed){
            vy+=5;
            faceDir = 1;
            this.image = SpriteUtils.loadImage("assets/images/players/straight/13.png");
        }
        if (KeyPressed.getInstance().dPressed){
            vx+=5;
            faceDir = 2;
            this.image = SpriteUtils.loadImage("assets/images/players/straight/14.png");
        }
        if (KeyPressed.getInstance().aPressed){
            vx-=5;
            faceDir = 3;
            this.image = SpriteUtils.loadImage("assets/images/players/straight/15.png");
        }
        if (this.Ammo>0) {
            if (KeyPressed.getInstance().enterPressed && frameCounter.expired) {
                this.castSpell();
                this.Ammo--;
                frameCounter.reset();
            } else {
                frameCounter.run();
            }
        }
        else {
            if (reload.expired){
                this.Ammo = this.MaxAmmo;
                reload.reset();
            }
            else {
                reload.run();
                frameCounter.run();
            }
        }
        this.position.x = Utils.clamp(this.position.x,0,800-this.image.getWidth(null));
        this.position.y = Utils.clamp(this.position.y,370,610);
        this.velocity.set(vx,vy);
        super.run();
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
