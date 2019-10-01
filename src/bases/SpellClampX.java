package bases;

public class SpellClampX {
    public static float clampX(float value ) {
        //von da tu tao 1 khoang bo nho trong may
       if (value>800){
           return 0;
       }
       if (value <0){
           return  800;
       }
       return  value;
    }
}
