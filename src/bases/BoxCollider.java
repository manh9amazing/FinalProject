package bases;

public class BoxCollider {
    Vector2D position;
    Vector2D anchor;
    float width, height;

    public BoxCollider(GameObject master, float width, float height) {
        //lay thong tin cua phan tu chua boxCollider
        this.position = master.position;
        this.width = width;
        this.height = height;
        this.anchor = master.anchor;
    }

    public float top(){
        return this.position.y - this.anchor.y*this.height;
    }
    public float bot(){
        return this.top() + this.height;
    }
    public float left(){
        return this.position.x -this.anchor.y*this.width;
    }
    public float right(){
        return this.left() + this.width;
    }

    //ToDo: can lam gi
    public boolean collideWith(BoxCollider other){
        return  this.right() >= other.left()&&
                this.left() <= other.right() &&
                this.bot ()>= other.top()&&
                this.top()<= other.bot();

    }
}