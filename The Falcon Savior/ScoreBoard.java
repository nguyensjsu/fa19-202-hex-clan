import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Write a description of class ScoreBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ScoreBoard extends Leaf implements IScoreObserver {
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int score = 0;

    ScoreBoard(int x, int y) {
        super(x, y);
    }


    public void act() {
        // Add your action code here.
        updateScore();
    }

    private void updateScore() {
        GreenfootImage img = new GreenfootImage("Score: " + score, 20, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
        setImage(img);
    }

    public void scoreUpdate() {
        this.score = this.score + 1;
    }
}
