package bases;

public class Utils {

    /**
     * gioi han player
     * @param value
     * @param min
     * @param max
     * @return
     */
    public static float clamp(float value, float min,float max) {
        //von da tu tao 1 khoang bo nho trong may
        if (value < min){
            return min;
        }
        if (value> max){
            return max;
        }
        return value;
    }
}