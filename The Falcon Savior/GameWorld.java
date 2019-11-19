import greenfoot.*;

/**
 * Write a description of class GameWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameWorld extends World {

    /**
     * Constructor for objects of class GameWorld.
     */
    public GameWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        scaleBackground();
    }
    
    private void scaleBackground() {
        GreenfootImage backgroundImage = getBackground();
        backgroundImage.scale(1000, 800);
        setBackground(backgroundImage);
    }
}
