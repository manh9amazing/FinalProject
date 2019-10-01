package bases;

public class ReverseMethod {
    public static Vector2D reverse(Vector2D oldVelocity) {
        Vector2D newVelocity = new Vector2D();
        newVelocity.x = - oldVelocity.x;
        newVelocity.y= - oldVelocity.y;
        return  newVelocity;
    }
}
