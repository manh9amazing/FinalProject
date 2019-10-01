package bases;

public class SpellClampY {
    public static float clampY(float value ) {
        //von da tu tao 1 khoang bo nho trong may
        if (value>=700){
            return 340;
        }
        if (value <=0){
            return  360;
        }
        if (value>=340 && value <350){
            return  700;
        }
        if(value>350 && value <= 360){
            return 0;
        }
        return  value;
    }
}
