import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

/**
 * Write a description of class Help here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HelpWorld extends World {


    HelpWorld() {
        super(1000, 800, 1);
        scaleBackground();

    }

    private void scaleBackground() {
        GreenfootImage backgroundScreen = new GreenfootImage("HelpBack.png");
        GreenfootImage controlImage = new GreenfootImage(100, 500);

        backgroundScreen.scale(1000, 800);
        setBackground(backgroundScreen);
        getBackground().drawImage(new GreenfootImage("Han Solo and Chewbacca are on a mission to take down their worst ",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 85);

        getBackground().drawImage(new GreenfootImage("enemy, your mission is to take down all the enemy ships and then",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 115);

        getBackground().drawImage(new GreenfootImage("face the final boss.",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 145);

        getBackground().drawImage(new GreenfootImage("Controls(Player 1):",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 205);

        getBackground().drawImage(new GreenfootImage("Use ",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 255);

        getBackground().drawImage(new GreenfootImage("Right.png"), getWidth() / 28, 195);

        getBackground().drawImage(new GreenfootImage("and ",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 5, 255);

        getBackground().drawImage(new GreenfootImage("Left.png"), getWidth() / 5, 135);

        getBackground().drawImage(new GreenfootImage("to move the Falcon ship right and left.",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 3, 255);

        getBackground().drawImage(new GreenfootImage("Use SPACE bar to fire the missiles at enemy ships.",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 300);

        getBackground().drawImage(new GreenfootImage("Controls(Player 2):",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 380);

        getBackground().drawImage(new GreenfootImage("Use ",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 430);

        getBackground().drawImage(new GreenfootImage("A.png"), getWidth() / 22, 372);

        getBackground().drawImage(new GreenfootImage("and ",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 5, 430);

        getBackground().drawImage(new GreenfootImage("D.png"), getWidth() / 5, 372);

        getBackground().drawImage(new GreenfootImage("to move the Falcon ship right and left.",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 3, 432);

        getBackground().drawImage(new GreenfootImage("Use ",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 15, 482);

        getBackground().drawImage(new GreenfootImage("W.png"), getWidth() / 22, 422);

        getBackground().drawImage(new GreenfootImage("to fire the missiles at enemy ships.",
                30, Color.WHITE, new Color(0, 0, 0, 0)), getWidth() / 5, 482);


        // getBackground().drawImage(new GreenfootImage("hello text", 45, Color.BLUE, new Color(0, 0, 0, 0)), getWidth()/4, 50);
        Button exitHelpScreen = new Button(Button.Type.EXIT);
        addObject(exitHelpScreen, getWidth() / 2, 700);
        IMenuCommand exitCommand = new MenuCommand();
        exitCommand.setReceiver(new IMenuReceiver() {
            @Override
            public void performAction() {
                Greenfoot.setWorld(new MenuWorld());
            }
        });

        exitHelpScreen.setMenuCommand(exitCommand);

    }


}
