import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Write a description of class Button here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Button extends Actor implements IMenuInvoker {

    private IMenuCommand menuCommand;

    Button(Type buttonType) {
        //normal constructor for button(no world declaration)
        setPicture(buttonType);
    }

    private void setPicture(Type buttonType) {
        //sets pictures of buttons
        GreenfootImage greenfootImage;
        switch (buttonType) {
            case SINGLE_PLAYER:
                greenfootImage = new GreenfootImage("1 PLAYER GAME", 25, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
                break;
            case MULTI_PLAYER:
                greenfootImage = new GreenfootImage("2 PLAYER GAME", 25, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
                break;
            case HELP:
                greenfootImage = new GreenfootImage("HELP", 25, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
                break;
            case CREDITS:
                greenfootImage = new GreenfootImage("STATISTICS", 25, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
                break;
            case CONTINUE:
                greenfootImage = new GreenfootImage("EXIT", 25, Color.BLUE, new Color(0, 0, 0, 0));
                break;
            case EXIT:
                greenfootImage = new GreenfootImage("EXIT", 25, Color.LIGHT_GRAY, new Color(0, 0, 0, 0));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + buttonType);
        }
        setImage(greenfootImage);
    }

    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)) {
            click();
        }
    }

    @Override
    public void click() {
        if (null != menuCommand)
            menuCommand.executeCommand();
    }

    @Override
    public void setMenuCommand(IMenuCommand menuCommand) {
        this.menuCommand = menuCommand;
    }

    public enum Type {
        SINGLE_PLAYER,
        MULTI_PLAYER,
        TOGGLE_SOUND,
        HELP,
        CREDITS,
        CONTINUE,
        EXIT
    }
}
