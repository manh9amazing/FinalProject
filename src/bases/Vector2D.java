package bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other) {
        this.addUp(other.x, other.y);
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D other) {
        return this.add(this.x + other.x, this.y + other.y);
    }

    public void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public void subtractBy(Vector2D other) {
        this.subtractBy(other.x, other.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D other) {
        return this.subtract(this.x - other.x, this.y - other.y);
    }

    public void multiply(float k) {
        this.x *= k;
        this.y *= k;
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D normalize() {
        return new Vector2D(this.x / this.length(), this.y / this.length());
    }

    /**
     * hien ra dap an theo string
     *
     * @return
     */
    @Override
    public String toString() {
        return "bases.Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    public void set(float v, float i) {
        this.x = v;
        this.y = i;
    }

    public void set(Vector2D other) {
        this.set(other.x, other.y);
    }

    public void setAngle(double angle) {
        double currentLength = this.length();
        if (currentLength != 0) {
            this.x = (float) (currentLength * Math.cos(angle));
            this.y = (float) (currentLength * Math.sin(angle));
        }
    }


}