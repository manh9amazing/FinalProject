package entities;

public class MapState {
  public boolean MapReverse;
    private static final MapState INSTANCE = new MapState();
    private MapState(){
       this.MapReverse = false;
    }
    public static MapState getInstance(){
        return INSTANCE;
    }
}
