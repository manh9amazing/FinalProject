package entities;

import bases.GameObject;

public class Supporter2Spawner extends GameObject {
    public Supporter2Spawner(){
    }

    @Override
    public void run() {
        super.run();
        if(BuffToggleP2.getInstance().SupporterSummon){
            Supporter2 newSupporter2 = new Supporter2();
            SupporterP2Cnt++;
            newSupporter2.Supporter2velocityX+= 5* SupporterP2Cnt;
            newSupporter2.Supporter2velocityY+= 5* SupporterP2Cnt;
            BuffToggleP2.getInstance().SupporterSummon = false;

        }

    }
}
