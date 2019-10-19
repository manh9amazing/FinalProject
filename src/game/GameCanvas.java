package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import bases.GameObject;
import bases.KeyPressed;
import bases.SpriteUtils;
import entities.*;

public class GameCanvas extends JPanel {
    Image troll;
    Image trollMessage;
    Player1 player1;
    Player1Spell player1Spell;
    Player2 player2;
    Player2Spell player2Spell;
    Supporter1Spawner supporter1Spawner;
    Supporter2Spawner supporter2Spawner;
//    Enemy enemy;
    EnemySpawner enemySpawner;
    FlagBlockSpawner flagBlockSpawner;

    BuffAvailable buffNotiAndCnt;

    public GameCanvas(){
        this.KeyListener();
        this.player1 = new Player1();
        this.player1Spell = new Player1Spell();
        this.player2 = new Player2();
        this.player2Spell = new Player2Spell();
        this.supporter1Spawner = new Supporter1Spawner();
        this.supporter2Spawner = new Supporter2Spawner();
        this.enemySpawner = new EnemySpawner();
        this.flagBlockSpawner = new FlagBlockSpawner();
        this.troll = SpriteUtils.loadImage("assets/images/players/straight/100.png");
        this.trollMessage = SpriteUtils.loadImage("assets/images/players/straight/101.png");
    }
    private void KeyListener() {
        this.setFocusable(true);
        //co kha nang bat su kien
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyPressed.getInstance().anyKeyPressed = true;
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyPressed.getInstance().upPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyPressed.getInstance().leftPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyPressed.getInstance().rightPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyPressed.getInstance().spacePressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyPressed.getInstance().wPressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyPressed.getInstance().aPressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyPressed.getInstance().sPressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyPressed.getInstance().dPressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    KeyPressed.getInstance().enterPressed= true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyPressed.getInstance().anyKeyPressed =false;
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyPressed.getInstance().upPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyPressed.getInstance().leftPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyPressed.getInstance().rightPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyPressed.getInstance().spacePressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyPressed.getInstance().wPressed= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyPressed.getInstance().aPressed= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyPressed.getInstance().sPressed= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyPressed.getInstance().dPressed= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    KeyPressed.getInstance().enterPressed= false;
                }
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {


        g.setColor(Color.black);
        g.fillRect(0,0,800,700);
        g.setColor(Color.GRAY);
        g.fillRect(0,320,800,40);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(800,0,400,340);
        g.setColor(Color.red);
        g.drawString("Player 1", 800,20);
        g.setColor(Color.cyan);
        g.drawString("3 Nearest Buff",800,170);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(800,340,400,350);
        g.setColor(Color.red);
        g.drawString("Player 2", 800,370);
        g.setColor(Color.black);
        g.drawString("3 Nearest Buff",800,520);
        GameObject.renderALL(g);
        if(BuffAvailable.getInstance().buffTime == false) {
            g.setColor(Color.PINK);
            g.drawString("BUFF: INCOMING", 930, 330);
        }
        if (BuffAvailable.getInstance().buffTime == true) {
            g.setColor(Color.GREEN);
            g.drawString("BUFF: GIVING", 930, 330);
        }
        if (EventToggle.getInstance().Troll){
            g.setColor(Color.white);
            g.fillRect(0,0,2000,1000);
            g.drawImage(troll,0,90,null);
            g.drawImage(trollMessage,650,0,null);
        }



//test git commit
    }
}
