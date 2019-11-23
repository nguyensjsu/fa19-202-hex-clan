import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Write a description of class ScoreBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ScoreBoard extends Leaf implements IPlayerEventHandler {
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score = 0;
    private IPlayerEventHandler nextHandler;
    private Level level;

    ScoreBoard(int x, int y, Level level) {
        super(x, y);
        this.level = level;
    }

    public void act() {
        // Add your action code here.
        updateScore();
    }

    private void updateScore() {
        GreenfootImage img = new GreenfootImage("Score: " + score, 20, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
        setImage(img);
    }

    private void scoreUpdate() {
        this.score += 10;
        level.levelIncrementCheck(10);
    }

    public boolean hasNext() {
        return null != this.nextHandler;
    }

    public IPlayerEventHandler getNext() {
        return this.nextHandler;
    }

    public void setNext(IPlayerEventHandler handler) {
        this.nextHandler = handler;
    }

    public void handleEvent(Event event) {
        if (event == Event.SCORE) {
            scoreUpdate();
        } else if (null != nextHandler) {
            this.nextHandler.handleEvent(event);
        }
    }

    int getScore() {
        return score;
    }
}
