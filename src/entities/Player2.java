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
        this.HP = 10;
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
            if(faceDir==0) {
                g.drawImage(this.shield, (int) (this.position.x - 6.25), (int) this.position.y, null);
            }
            if(faceDir==1) {
                g.drawImage(this.shield, (int) (this.position.x - 6.25), (int) (this.position.y-12.5), null);
            }
            if(faceDir==2) {
                g.drawImage(this.shield, (int) (this.position.x - 12.5), (int) (this.position.y-6.25), null);
            }
            if(faceDir==3) {
                g.drawImage(this.shield, (int) this.position.x , (int) (this.position.y-6.25), null);
            }
        }
        else{
            this.Armor =0;
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
        if(EventToggle.getInstance().Blessings){
            this.HP+= 500;
            this.MaxHP +=500;
            this.MaxAmmo+=2;
            EventToggle.getInstance().BlessingsSubCnt++;
        }

//        this.checkTroll();
        if (!EventToggle.getInstance().FlagCapture&&
                RewardCondition.getInstance().PlayerFlagBonus<2){
            this.MaxHP +=this.FlagCapturedP2*100;
            this.HP+= this.FlagCapturedP2*100;
            this.Spell2ATK +=this.FlagCapturedP2*100;
            this.Armor+=this.FlagCapturedP2*20;
            RewardCondition.getInstance().PlayerFlagBonus++;
        }

        if (RewardCondition.getInstance().Enemy2Defeated &&
                RewardCondition.getInstance().Enemy1Defeated &&
                !EventToggle.getInstance().StandTogether&&
            RewardCondition.getInstance().PlayerGivenBonus<2){
            this.MaxHP +=250;
            this.HP+=200;
            this.Spell2ATK +=100;
            RewardCondition.getInstance().PlayerGivenBonus++;
            EventToggle.getInstance().StandTogether = false;
        }
        if(RewardCondition.getInstance().Enemy2Defeated &&
                !RewardCondition.getInstance().Enemy1Defeated &&
                !EventToggle.getInstance().StandTogether){
            this.MaxHP +=150;
            this.HP+=100;
            this.Spell2ATK += 50;
            RewardCondition.getInstance().Enemy2Defeated=false;
        }

        this.checkEnemyFight();
        this.EventActivator();
        this.BuffActivatorP2();
        if(!BuffToggleP2.getInstance().Frozen && !EventToggle.getInstance().Troll) {
            float vx = 0, vy = 0;
            if (KeyPressed.getInstance().wPressed) {
                vy -= 5;
                faceDir = 0;
                if (!EventToggle.getInstance().InvisibleBattle){
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/12.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/shield.png");
                }
                else{
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                }
            }
            if (KeyPressed.getInstance().sPressed) {
                vy += 5;
                faceDir = 1;
                if (!EventToggle.getInstance().InvisibleBattle) {
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/13.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/shield.png");
                }
                else{
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                }
            }
            if (KeyPressed.getInstance().dPressed) {
                vx += 5;
                faceDir = 2;
                if (!EventToggle.getInstance().InvisibleBattle) {
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/14.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/shield.png");
                }
                else{
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                }
            }
            if (KeyPressed.getInstance().aPressed) {
                vx -= 5;
                faceDir = 3;
                if (!EventToggle.getInstance().InvisibleBattle) {
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/15.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/shield.png");
                }
                else{
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                }
            }
            if (this.Ammo > 0) {
                if (KeyPressed.getInstance().enterPressed && frameCounter.expired) {
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
            if(MapState.getInstance().MapReverse){
                this.position.x = Utils.clamp(this.position.x, 0, 800 - this.image.getWidth(null));
                this.position.y = Utils.clamp(this.position.y, 0, 270);
            }
            else {
                this.position.x = Utils.clamp(this.position.x, 0, 800 - this.image.getWidth(null));
                this.position.y = Utils.clamp(this.position.y, 370, 610);
            }
            this.velocity.set(vx, vy);
//            System.out.println("AAAAAAAAAAAAAAAA "+  this.Armor);
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
