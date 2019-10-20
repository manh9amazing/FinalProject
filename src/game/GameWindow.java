package game;

import bases.GameObject;
import entities.BuffAvailable;
import entities.BuffRunner;
import entities.ChangeSceneCnt;
import entities.EventRunner;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas = new GameCanvas();
    BuffRunner runner = new BuffRunner();
    EventRunner runnerEvent = new EventRunner();
    public GameWindow(){
        this.setResizable(false);
        this.setSize(1200,700);
        this.setContentPane(this.canvas);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void gameLoop(){
        while(true){
            GameObject.runALL();
            if (!ChangeSceneCnt.getInstance().SceneChanged) {
                runner.run();
                runnerEvent.run();
            }
            else {
                runner.reset();
                runnerEvent.reset();
            }
            this.canvas.repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
