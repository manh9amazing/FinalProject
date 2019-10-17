package entities;

import bases.GameObject;

public class EnemySpawner extends  GameObject {
    public EnemySpawner(){
    }
    @Override
    public void run() {
        if (EventToggle.getInstance().StandTogether && !EnemySpawnerToggle.getInstance().Spawned){
            Enemy newEnemy = GameObject.recycle(Enemy.class);
            Enemy2 newEnemy2 = GameObject.recycle(Enemy2.class);
            newEnemy.HP = 100;
            newEnemy2 .HP = 100;
            EnemySpawnerToggle.getInstance().Spawned = true;
        }
    }
}
