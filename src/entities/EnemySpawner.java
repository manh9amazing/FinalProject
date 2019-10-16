package entities;

import bases.GameObject;

public class EnemySpawner extends  GameObject {
    public EnemySpawner(){
    }
    @Override
    public void run() {
        if (EventToggle.getInstance().StandTogether && !EnemySpawnerToggle.getInstance().Spawned){
            Enemy newEnemy = GameObject.recycle(Enemy.class);
            newEnemy.HP = 100;
            EnemySpawnerToggle.getInstance().Spawned = true;
        }
    }
}
