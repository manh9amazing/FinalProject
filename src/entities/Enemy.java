package entities;

import bases.*;
import java.awt.*;

public class Enemy extends GameObject {
    int isShooting = 0;
    int spellNum = 9;
    boolean dir_switch;

    FrameCounter shootTime;
    FrameCounter aimTime;


    public Enemy(){
        this.HP = 100;
        this.image = SpriteUtils.loadImage("assets/images/players/straight/enemy.png");
        this.position = new Vector2D(400,270);
        this.boxCollider = new BoxCollider(this, 27, 27);
        this.shootTime = new FrameCounter(100);
        this.aimTime = new FrameCounter(200);
        this.dir_switch = false;

    }

    @Override
    public void render(Graphics g) {
            super.render(g);
            if (!aimTime.expired && shootTime.expired) {
                g.setColor(Color.red);
                for (int i = 0; i < spellNum; i++) {
                    double X_destination;
                    double Y_destination;
                    double XForCal;
                    double YForCal;
                    if (i % 2 == 1 && this.dir_switch == false) {
                        double tempAng = (180 / (spellNum - 1)) * i;
                        double radConvert = Math.toRadians(tempAng);
                        XForCal = this.position.x + 19;
                        YForCal = this.position.y + 2;
                        X_destination = XForCal - 2 * Math.cos(radConvert) * 1000;
                        Y_destination = YForCal - 2 * Math.sin(radConvert) * 1000;
                        if (tempAng >= 90) {
                            Y_destination = YForCal + (800 - XForCal) * (Y_destination - YForCal) / (X_destination - XForCal);
                            X_destination = 800;
                        }
                        g.drawLine((int) XForCal, (int) YForCal, (int) X_destination, (int) Y_destination);

                    }
                    if (i % 2 == 0 && this.dir_switch == true) {
                        double tempAng = (180 / (spellNum - 1)) * i;
                        double radConvert = Math.toRadians(tempAng);
                        XForCal = this.position.x + 19;
                        YForCal = this.position.y + 2;
                        X_destination = XForCal - 2 * Math.cos(radConvert) * 1000;
                        Y_destination = YForCal - 2 * Math.sin(radConvert) * 1000;
                        if (tempAng >= 90) {
                            Y_destination = YForCal + (800 - XForCal) * (Y_destination - YForCal) / (X_destination - XForCal);
                            X_destination = 800;
                        }
                        g.drawLine((int) XForCal, (int) YForCal, (int) X_destination, (int) Y_destination);
                    }

                }
            }
        }


    public void run() {
            this.deActiveifNeeded();
            if(!shootTime.expired) {
                if (isShooting == 20) {
                    this.castSpell();
                    isShooting = 0;
                    this.shootTime.run();
                } else {
                    isShooting++;
                    this.shootTime.run();
                }
            }
            else{
                if (!aimTime.expired){
//                    this.aiming();
                    aimTime.run();
                }
                else{
                    shootTime.reset();
                    aimTime.reset();
                    this.dir_switch = !this.dir_switch;
                }
            }
        Player1 player1 = GameObject.checkCollider(this, Player1.class);
        if (player1 != null ){
            this.deActive();
            player1.HP-=1000;
            }
        }


    public void castSpell() {
        for (int i = 0 ; i < spellNum  ; i++){
            if(i% 2 ==1 && this.dir_switch==true) {
                double tempAng = (180 / (spellNum - 1)) * i;
                double radConvert = Math.toRadians(tempAng);
                EnemySpell newSpell = GameObject.recycle(EnemySpell.class);
                newSpell.createAngle = radConvert;
                newSpell.position.x = this.position.x + 19;
                newSpell.position.y = this.position.y + 2;
            }
            if(i% 2 ==0 && this.dir_switch==false) {
                double tempAng = (180 / (spellNum - 1)) * i;
                double radConvert = Math.toRadians(tempAng);
                EnemySpell newSpell = GameObject.recycle(EnemySpell.class);
                newSpell.createAngle = radConvert;
                newSpell.position.x = this.position.x + 19;
                newSpell.position.y = this.position.y + 2;
            }
        }
    }

    @Override
    public void deActive() {
        super.deActive();
    }

    public  void deActiveifNeeded(){
        if (!EventToggle.getInstance().StandTogether){
            this.deActive();
        }
    }

}




