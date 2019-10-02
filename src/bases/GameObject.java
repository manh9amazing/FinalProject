package bases;



import entities.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

//add la bc staging cua git
public class GameObject {

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList player1Statuses = new ArrayList();
    public static ArrayList player2Statuses = new ArrayList();
    public static ArrayList eventLogs = new ArrayList();
    private static Object Player1Spell;

    public static void add(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public static void clear() {
        gameObjects.clear();

    }

    public static void renderALL(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.render(g);
            }
        }
        if (player1Statuses != null) {
            if (player1Statuses.size() >= 3) {
                int i = 0;
                while (i < 3) {
                    String player1Status = (String) player1Statuses.get(player1Statuses.size() - 1 - i);
                    g.setColor(Color.orange);
                    int X_to_draw = 170 + (i + 1) * 30;
                    g.drawString(player1Status, 820, X_to_draw);
                    i++;
                }
            } else {
                for (int i = 0; i < player1Statuses.size(); i++) {
                    String player1Status = (String) player1Statuses.get(player1Statuses.size() - 1 - i);
                    g.setColor(Color.orange);
                    int X_to_draw = 170 + (i + 1) * 30;
                    g.drawString(player1Status, 820, X_to_draw);
                }
            }
        }
        if (player2Statuses != null) {
            if (player2Statuses.size() >= 3) {
                int i = 0;
                while (i < 3) {
                    String player2Status = (String) player2Statuses.get(player2Statuses.size() - 1 - i);
                    g.setColor(Color.black);
                    int X_to_draw = 520 + (i + 1) * 30;
                    g.drawString(player2Status, 820, X_to_draw);
                    i++;
                }
            } else {
                for (int i = 0; i < player2Statuses.size(); i++) {
                    String player2Status = (String) player2Statuses.get(player2Statuses.size() - 1 - i);
                    g.setColor(Color.black);
                    int X_to_draw = 520 + (i + 1) * 30;
                    g.drawString(player2Status, 820, X_to_draw);
                }
            }

        }
        if (EventAvailable.getInstance().eventTime == false) {
            g.setColor(Color.BLUE);
            g.drawString("EVENT: INCOMING", 930, 654);
        }
        if (EventAvailable.getInstance().eventTime == true) {
            if (eventLogs.size() >= 1) {
                g.setColor(Color.BLACK);
                g.drawString("EVENT: " + eventLogs.get(eventLogs.size() - 1), 930, 654);
            } else {
                g.setColor(Color.BLUE);
                g.drawString("EVENT: INCOMING", 930, 654);
            }
        }


    }

    public static void runALL() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.run();
            }
        }

//        System.out.println(gameObjects.size());
        if (BuffAvailable.getInstance().buffTime == true && !BuffAvailable.getInstance().buffActivated) {
            BuffRandomize buffRandomize = new BuffRandomize();
            BuffRandomizeP2 buffRandomizeP2 = new BuffRandomizeP2();
            buffRandomize.run();
            buffRandomizeP2.run();
            BuffAvailable.getInstance().buffActivated = true;
        }
        if (!BuffAvailable.getInstance().buffTime) {
            BuffAvailable.getInstance().buffActivated = false;
        }

        if (EventAvailable.getInstance().eventTime == true && !EventAvailable.getInstance().eventActivated) {
            EventRandomize eventRandomize = new EventRandomize();
            eventRandomize.run();
            EventAvailable.getInstance().eventActivated = true;
        }
        if (!EventAvailable.getInstance().eventTime) {
            EventAvailable.getInstance().eventActivated = false;
        }
    }


    //Generics
    public static <T extends GameObject> T checkCollider(GameObject master, Class<T> cls) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive && gameObject.getClass().equals(cls)) {
                if (gameObject.boxCollider != null) {
                    if (master.boxCollider.collideWith(gameObject.boxCollider)) {
                        return (T) gameObject;
                        //enemy la gameObject nhung gameObject java ko bt la enemy hay ko
                    }
                }
            }
        }
        return null;
    }

    public static <E extends GameObject> E recycle(Class<E> cls) {
        E gameObject = GameObject.findInactive(cls);
        if (gameObject != null) {
            gameObject.reset();
            System.out.println("recycle");
            System.out.println("hoi sinh" + gameObject.getClass());
            return (E) gameObject;
        }
        try {
            GameObject go = cls.getConstructor().newInstance();
//                    System.out.println("tao moi hoan toan" + go.getClass());
            return (E) go;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
            //co the sua doi
        }

    }

    private static <E extends GameObject> E findInactive(Class<E> cls) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (!gameObject.isActive && cls.isAssignableFrom(gameObject.getClass())) {
                return (E) gameObject;
            }

        }
        return null;
    }

    public static <E extends GameObject> E findObject(Class<E> cls) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive) {
                return (E) gameObject;
            }
        }
        return null;
    }

    FrameCounter poisonIfNeeded;
    FrameCounter poisonIfNeededP2;
    FrameCounter deFroze;
    FrameCounter deFrozeP2;
    FrameCounter eventLasting;
    public  Image troll;
    public Image image;
    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public boolean isActive;
    public Vector2D anchor;
    public int ExistX;
    public int ExistY;
    public int HP;
    public int MaxHP;
    public static int Spell1ATK;
    public static int Spell2ATK;
    public int Armor;
    public int Ammo;
    public int MaxAmmo;
    public int ReloadTime;


    public GameObject() {
        GameObject.add(this);
        this.troll = SpriteUtils.loadImage("assets/images/players/straight/100.png");
        this.position = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
        this.anchor = new Vector2D(0.5f, 0.5f);
        this.isActive = true;
        poisonIfNeeded = new FrameCounter(20);
        poisonIfNeededP2 = new FrameCounter(20);
        deFroze = new FrameCounter(50);
        deFrozeP2 = new FrameCounter(50);
        eventLasting = new FrameCounter(200);
        String s = 5 + "";
    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
//        if (EventToggle.getInstance().Troll){
//            g.drawImage(troll,0,0);
//        }
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void deActive() {
        this.isActive = false;
    }

    public void reset() {
        this.isActive = true;
        //va reset HP neu co
    }

    public void BuffActivator() {
        this.checkInstantHeal();
        this.checkFrozen();
        this.checkExcaliburn();
        this.checkPoisoned();
    }

    public void BuffActivatorP2() {
        this.checkInstantHealP2();
        this.checkFrozenP2();
        this.checkExcaliburnP2();
        this.checkPoisonedP2();
    }

    public void checkPoisoned() {
        if (BuffToggle.getInstance().Poisoned) {
            if (poisonIfNeeded.expired) {
                this.HP--;
                poisonIfNeeded.reset();
            } else {
                poisonIfNeeded.run();
            }
        }
    }

    public void checkInstantHeal() {
        if (BuffToggle.getInstance().InstantHeal) {
            this.HP += 10;
            if (this.HP > this.MaxHP) {
                this.HP = this.MaxHP;
            }
            this.checkPoisoned();
            BuffToggle.getInstance().InstantHeal = false;
        }
    }

    public void checkExcaliburn() {
        if (BuffToggle.getInstance().Excaliburn) {
            this.Spell1ATK = 999;
            this.checkPoisoned();
            BuffToggle.getInstance().Excaliburn = false;
        }
    }

    public void checkFrozen() {
        if (BuffToggle.getInstance().Frozen) {
            if (deFroze.expired) {
                BuffToggle.getInstance().Frozen = false;
                deFroze.reset();
            } else {
                deFroze.run();
            }
            this.checkPoisoned();
        }
    }


    //---------------------------------------------------------------
    public void checkPoisonedP2() {
        if (BuffToggleP2.getInstance().Poisoned) {
            if (poisonIfNeededP2.expired) {
                this.HP--;
                poisonIfNeededP2.reset();
            } else {
                poisonIfNeededP2.run();
            }
        }
    }

    public void checkInstantHealP2() {
        if (BuffToggleP2.getInstance().InstantHeal) {
            this.HP += 10;
            if (this.HP > this.MaxHP) {
                this.HP = this.MaxHP;
            }
            this.checkPoisonedP2();
            BuffToggleP2.getInstance().InstantHeal = false;
        }
    }

    public void checkExcaliburnP2() {
        if (BuffToggleP2.getInstance().Excaliburn) {
            this.Spell2ATK = 999;
            this.checkPoisonedP2();
            BuffToggleP2.getInstance().Excaliburn = false;
        }
    }

    public void checkFrozenP2() {
        if (BuffToggleP2.getInstance().Frozen) {
            if (deFrozeP2.expired) {
                BuffToggleP2.getInstance().Frozen = false;
                deFrozeP2.reset();
            } else {
                deFrozeP2.run();
            }
            this.checkPoisonedP2();
        }
    }
    //-----------------------------------------------

    public void EventActivator() {
        this.checkSuddenDeath();
    }

    public void checkSuddenDeath() {
        if (EventToggle.getInstance().SuddenDeath) {
          this.HP = 1;
        }
        if(EventAvailable.getInstance().eventTime==false){
            EventToggle.getInstance().SuddenDeath = false;
        }
    }


}

