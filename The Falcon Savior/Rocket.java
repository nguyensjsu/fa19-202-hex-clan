import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Leaf
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage("rocket.png");
    public Rocket(World world, int x, int y)
    {
        super(world, x, y);
    } 
    
    public void act() 
    {
        // Add your action code here.
        this.setLocation(getX(), getY() - 4);
        
        if(getY() <= 0)
        {
            getWorld().removeObject(this);
        }
        
    }  
    
    public void display()
    {
        setImage(image);
        world.addObject(this, x, y);
    }
}
