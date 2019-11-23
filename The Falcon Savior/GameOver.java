import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Write a description of class GameOver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameOver extends World {

    /**
     * Constructor for objects of class GameOver.
     */
    GameOver(int score1) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);

        scaleBackground();
        GreenfootImage img = new GreenfootImage("PLAYER 1:    " + score1, 25, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
        getBackground().drawImage(img, 200, 200);
        pushScores(score1);
    }

    GameOver(int score1, int score2) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        scaleBackground();
        GreenfootImage img1 = new GreenfootImage("PLAYER 1:  " + score1, 25, Color.RED, new Color(0, 0, 0, 0));
        GreenfootImage img2 = new GreenfootImage("PLAYER 2:  " + score2, 25, Color.GREEN, new Color(0, 0, 0, 0));
        getBackground().drawImage(img1, 200, 200);
        getBackground().drawImage(img2, 200, 400);
        pushScores(score1);
        pushScores(score2);
    }

    private void pushScores(int s) {
        String newLine = System.getProperty("line.separator");
        String fileContent = Integer.toString(s);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Scores.txt", true));
            writer.write(newLine + fileContent);
            writer.close();
        } catch (Exception e) {
            getBackground().drawImage(new GreenfootImage("Error in File Retriveing . PLease Try Again Later", 35, Color.RED, new Color(0, 0, 0, 0)), 300, 600);
        }
    }

    private void scaleBackground() {
        GreenfootImage backgroundScreen = new GreenfootImage("HelpBack.png");
        backgroundScreen.scale(1000, 800);
        setBackground(backgroundScreen);
        getBackground().drawImage(new GreenfootImage("GAME OVER", 50, Color.LIGHT_GRAY, new Color(0, 0, 0, 0)), 400, 100);
        Button continueButton = new Button(Button.Type.CONTINUE);
        addObject(continueButton, 600, 600);
        IMenuCommand continueCommand = new MenuCommand();
        continueCommand.setReceiver(new IMenuReceiver() {
            @Override
            public void performAction() {
                Greenfoot.setWorld(new MenuWorld());
            }
        });

        continueButton.setMenuCommand(continueCommand);

    }
}
