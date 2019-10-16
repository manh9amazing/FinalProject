package entities;

import bases.GameObject;

public class Supporter1Spawner extends GameObject {
//    Supporter1 supporter1;
    public Supporter1Spawner(){
//        this.supporter1 = new  Supporter1();
    }

    @Override
    public void run() {
        super.run();
        if(BuffToggle.getInstance().SupporterSummon){
            Supporter1 newSupporter1 = new Supporter1();
            SupporterCnt++;
            newSupporter1.Supporter1velocityX+= 5* SupporterCnt;
            newSupporter1.Supporter1velocityY+= 5* SupporterCnt;
            BuffToggle.getInstance().SupporterSummon = false;

        }

    }
}
