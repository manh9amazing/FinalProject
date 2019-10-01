package bases;

public class KeyPressed {
    public boolean upPressed;
    public boolean downPressed;
    public boolean rightPressed;
    public boolean leftPressed;
    public boolean spacePressed;
    private static final KeyPressed INSTANCE = new KeyPressed();
    public boolean anyKeyPressed;
    public boolean wPressed;
    public boolean aPressed;
    public boolean sPressed;
    public boolean dPressed;
    public boolean enterPressed;


    private KeyPressed(){
        //chi co the khoi tao o day
        this.upPressed = false;
        this.downPressed = false;
        this.rightPressed = false;
        this.leftPressed = false;
        this.spacePressed = false;
        this.anyKeyPressed = false;
        this.aPressed = false;
        this.wPressed = false;
        this.dPressed = false;
        this.sPressed = false;
        this.enterPressed = false;
    }

    public static KeyPressed getInstance(){
        //static ko this
        return INSTANCE;
    }
}