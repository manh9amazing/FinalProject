package entities;

import bases.*;
import entities.scene.GameEndingScene;
import entities.scene.SceneManager;
import org.w3c.dom.events.Event;

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
        this.MaxHP =1600;
        this.HP = 1400;
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
        g.setFont(new Font("TimesRoman", Font.BOLD, 15));
        g.setColor(Color.RED);
        g.drawString("HP: " + this.HP + " / "+ this.MaxHP, 820, 50 );
        g.setFont(new Font("TimesRoman", Font.BOLD, 15));
        g.setColor(Color.RED);
        g.drawString("ATK: " + Player1Spell.Spell1ATK, 820, 80 );
        if(this.Armor>0){
            g.setColor(Color.YELLOW);
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.drawString("ARMOR: " + this.Armor, 820, 110 );
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
        else {
            this.Armor = 0;
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.setColor(Color.YELLOW);
            g.drawString("ARMOR: BROKEN", 820,110 );
        }
        if (this.Ammo>0){ g.setFont(new Font("TimesRoman", Font.BOLD, 15));
        g.setColor(Color.BLUE);
        g.drawString("AMMO: " + this.Ammo + " / "+ this.MaxAmmo, 820, 140 );}
        else{
            g.setFont(new Font("TimesRoman", Font.BOLD, 15));
            g.setColor(Color.BLUE);
            g.drawString("AMMO: RELOADING" , 820, 140 );
        }
        super.render(g);
    }
    @Override
    public void run() {
        this.deActiveIfNeeded();
        this.checkBlessings();
        this.checkInvisible();
        if(EventToggle.getInstance().Blessings){
            this.HP+= 500;
            this.MaxHP+= 500;
            this.MaxAmmo+=2;
            EventToggle.getInstance().BlessingsSubCnt++;
        }

        if (!EventToggle.getInstance().FlagCapture&&
                RewardCondition.getInstance().PlayerFlagBonus<2){
//            System.out.println(this.FlagCaptured);
            this.MaxHP +=this.FlagCaptured*100;
            this.HP+= this.FlagCaptured*100;
            this.Spell1ATK +=this.FlagCaptured*100;
            this.Armor+=this.FlagCaptured*20;
            RewardCondition.getInstance().PlayerFlagBonus++;
        }

        if (RewardCondition.getInstance().Enemy1Defeated &&
                RewardCondition.getInstance().Enemy2Defeated &&
                !EventToggle.getInstance().StandTogether&&
            RewardCondition.getInstance().PlayerGivenBonus<2){
            this.MaxHP +=250;
            this.HP+=200;
            this.Spell1ATK +=100;
            RewardCondition.getInstance().PlayerGivenBonus++;
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
        this.checkFlagCapture();
        this.checkTroll();
        this.EventActivator();
        this.BuffActivator();
        if (!BuffToggle.getInstance().Frozen && !EventToggle.getInstance().Troll) {
            float vx = 0, vy = 0;
            if (KeyPressed.getInstance().upPressed) {
                vy -= 5;
                faceDir = 0;
                if(!EventToggle.getInstance().InvisibleBattle) {
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/8.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/shield.png");
                }
                else{
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                }
            }
            if (KeyPressed.getInstance().downPressed) {
                vy += 5;
                faceDir = 1;
                if(!EventToggle.getInstance().InvisibleBattle) {
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/9.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/shield.png");
                }
                else {
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                }
            }
            if (KeyPressed.getInstance().rightPressed) {
                vx += 5;
                faceDir = 2;
                if(!EventToggle.getInstance().InvisibleBattle) {
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/10.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/shield.png");
                }
                else{
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                }
            }
            if (KeyPressed.getInstance().leftPressed) {
                vx -= 5;
                faceDir = 3;
                if(!EventToggle.getInstance().InvisibleBattle) {
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/11.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/shield.png");
                }
                 else{
                    this.image = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                    this.shield = SpriteUtils.loadImage("assets/images/players/straight/invisible_player.png");
                }
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

    @Override
    public void deActive() {
        super.deActive();
        ChangeSceneCnt.getInstance().SceneChanged = true;
        MatchResult.getInstance().YellowWin = true;
        SceneManager.signNewScene(new GameEndingScene());
    }

    public void deActiveIfNeeded(){
        if(this.HP <= 0 ){
            this.deActive();
        }
    }
}
