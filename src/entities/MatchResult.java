package entities;

public class MatchResult {
    public boolean GreenWin;
    public boolean YellowWin;
    private static final MatchResult  INSTANCE = new MatchResult ();
    private MatchResult (){
        this.GreenWin = false;
        this.YellowWin = false;
    }
    public static MatchResult  getInstance(){
        return INSTANCE;
    }
}
