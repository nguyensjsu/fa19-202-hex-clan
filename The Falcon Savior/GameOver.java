import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class GameOver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameOver extends World {

    private Button ContinueButton;

    /**
     * Constructor for objects of class GameOver.
     */
    public GameOver(int score1) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        scaleBackground();
        GreenfootImage img = new GreenfootImage("PLAYER 1:    " + score1, 25, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
        getBackground().drawImage(img, 200, 200);
    }


    public GameOver(int score1, int score2) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        scaleBackground();
        GreenfootImage img1 = new GreenfootImage("PLAYER 1:  " + score1, 25, Color.RED, new Color(0, 0, 0, 0));
        GreenfootImage img2 = new GreenfootImage("PLAYER 2:  " + score2, 25, Color.GREEN, new Color(0, 0, 0, 0));
        getBackground().drawImage(img1, 200, 200);
        getBackground().drawImage(img2, 200, 400);
    }


    private void scaleBackground() {
        GreenfootImage backgroundImage = getBackground();
        backgroundImage.scale(1000, 800);
        setBackground(backgroundImage);
        getBackground().drawImage(new GreenfootImage("GAME OVER", 50, Color.BLUE, new Color(0, 0, 0, 0)), 400, 100);
        ContinueButton = new Button(Button.Type.CONTINUE);
        addObject(ContinueButton, getWidth() / 4, 120);
        IMenuCommand ContinueCommand = new MenuCommand();
        ContinueCommand.setReceiver(new IMenuReceiver() {
            @Override
            public void performAction() {
                Greenfoot.setWorld(new MenuWorld());
            }
        });

        ContinueButton.setMenuCommand(ContinueCommand);

    }
}
