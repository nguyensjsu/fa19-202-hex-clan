import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display the  menu page with multiple options of New game , Scores , Credits
 * 
 * @author Shalabh Neema 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{

    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("star_wars_background_4.png");
        addObject(new Button("newgame"), getWidth() / 3, 150);
        addObject(new Button("help"), getWidth() / 3, 200);
        addObject(new Button("credits"), getWidth() / 3, 250);
        
        //Greenfoot.start();
        
    }
}
